import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

interface EmployeeWage {

	void addCompany(final String name, final int empRate, final int numOfWorkingDays, final int maxHrsInMonth);
	void computeEmpWage();
	int getTotalWageByCompanyName(final String name);

public class Day23EmployeeWageUC14 implements EmployeeWage {

        private List<Company> companies;
		  private Map<String,Integer> companyWages;

        //creating a object list

        public Day23EmployeeWageUC14() {
                companies = new ArrayList<Company>();
					 companyWages = new HashMap<String,Integer>();
        }

        public static void main(String[] args) {
                System.out.println("Starting...");
                final Day23EmployeeWageUC14 empBuilder = new Day23EmployeeWageUC14();
                empBuilder.addCompany("TCS", 20, 20, 100);
                empBuilder.addCompany("CTS", 15, 25, 100);

                empBuilder.computeEmpWage();

					 //Query fo TCS
					 final int totalWage = empBuilder.getTotalWageByCompanyName("TCS");
					 System.out.println("Total Emp Wages for TCS : "+totalWage);
        }

		  public int getTotalWageByCompanyName(final String name) {
					final int totalWage = companyWages.get(name);
					return totalWage;
		  }

		  // override
        public void addCompany(final String name, final int empRate, final int numOfWorkingDays, final int maxHrsInMonth) {
                System.out.println("Called add company function with name :"+name);
                companies.add(new Company(name, empRate, numOfWorkingDays, maxHrsInMonth));
        }


        public void computeEmpWage() {
                System.out.println("Called computeEmpwage --->");
                for(int i = 0; i<companies.size(); i++) {
                     final Company company = companies.get(i);
                     final int totalWage = computeEmpWage(company);
                     company.setTotalEmpWage(totalWage);
                     companyWages.put(company.getName(),totalWage);
                }
				
					System.out.println("Sorted values in Map --->" +companyWages.toString());
        }

 			/**
         * calculate total employee wages
         * @param company The Company
         * @return total employee wages.
         */
        private int computeEmpWage(final Company company) {
                int totalWage = 0;
                int totalEmpHrs = 0;
                int totalWorkingDays = 0;
                while(totalEmpHrs < company.getMaxHrsInMonth() && totalWorkingDays< company.getNumOfWorkingDays()){
                        totalWorkingDays++;

                        final int empHrs = getEmpHrs();
                        final int empWage = empHrs*company.getEmpRate();
                        totalEmpHrs+=empHrs;
                        totalWage+=empWage;
                        //System.out.println("Emp DAY : "+totalWorkingDays+" wages : "+empWage);
                }
                return totalWage;
        }

        /**
         * Get employee hours.
         * @return employee hrs
         */
        public int getEmpHrs() {

                final int isFullTime = 1;
                final int isPartTime = 2;
                int empHrs = 0;

                //get random value
                final double randomValue = Math.floor(Math.random()*10)%3;

                switch((int)randomValue) {

                        case isFullTime:
                                empHrs = 8;
                                break;
                        case isPartTime:
                                empHrs = 4;
                                break;
                        default:
                                break;

		 }
		 return empHrs;

}

/**
 * CompanyEmpWage
 */
class Company {

        private String name;
        private int empRate;
        private int numOfWorkingDays;
        private int maxHrsInMonth;
        private int totalEmpWage;

        public Company(final String name, final int empRate, final int numOfWorkingDays, final int maxHrsInMonth){
                this.name = name;
                this.empRate = empRate;
                this.numOfWorkingDays = numOfWorkingDays;
                this.maxHrsInMonth = maxHrsInMonth;
        }

        public String getName(){
                return this.name;
        }

        public int getEmpRate(){
                return this.empRate;
        }

        public int getNumOfWorkingDays(){
                return this.numOfWorkingDays;
        }

        public int getMaxHrsInMonth(){
                return this.maxHrsInMonth;
        }

		  public void setTotalEmpWage(final int totalEmpWage){
                this.totalEmpWage=totalEmpWage;
        }

        @Override
        public String toString(){
                return "Total emp wage for company: "+name+" is "+ totalEmpWage;
        }
		}
	}
}
