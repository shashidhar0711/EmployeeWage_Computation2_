/**
* Use case 1 
*/
public class Day21EmployeeWageUC7 {
	
	private static final int EMP_RATE_PER_HRS = 20;
	private static final int NUM_OF_WORKING_DAYS = 20;
	private static final int MAX_HRS_IN_MONTH = 100;

	public static void main(String[] args) {
		calDailyEmpWage();
	}

	/**
	 * calculate employee daily wages based on type of employee 
	 */
	public static void calDailyEmpWage() {
		int totalWage = 0;
		int totalEmpHrs = 0;
		int totalWorkingDays = 0;
		while(totalEmpHrs < MAX_HRS_IN_MONTH && totalWorkingDays<NUM_OF_WORKING_DAYS){
			totalWorkingDays++;

			final int empHrs = getEmpHrs();
			final int empWage = empHrs*EMP_RATE_PER_HRS;
			totalEmpHrs+=empHrs;
			totalWage+=empWage;
			System.out.println("Emp DAY : "+totalWorkingDays+" wages : "+empWage);
		}
		System.out.println("Total emp wage : "+ totalWage);
	}

	/**
	 * Get employee hours. 
	 * @return employee hrs
	 */
	public static int getEmpHrs() {

		final int isFullTime = 1;
		final int isPartTime = 2;
		int empHrs = 0;

		//get random value
		final double randomValue = Math.floor(Math.random()*10)%3;

		switch((int)randomValue) {

			case isFullTime:
				empHrs = 8;
				System.out.println("Emp is present for full time.");
				break;
			case isPartTime:
				empHrs = 4;
				System.out.println("Emp is present for part time.");
				break;
			default:
				System.out.println("Emp is absent");
				break;
		}
		return empHrs;
	}
}
