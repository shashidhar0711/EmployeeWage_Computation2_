public class Day23EmployeeWageUC9 {
        private String companyName;
        private int empRate;
        private int numberofWorkingDays;
        private int maxHrsInMonth;
        private int totalEmpWage;

        /**
        *instance variable initialized with constructor
        */
        public Day23EmployeeWageUC9(final String companyName,final int empRate, final int numberofWorkingDays,final int maxHrsInMonth) {
                this.companyName=companyName;
                this.empRate=empRate;
                this.numberofWorkingDays=numberofWorkingDays;
                this.maxHrsInMonth=maxHrsInMonth;
        }

        public static void main(String args[]) {
                final Day23EmployeeWageUC9 ewb1bridgelabz= new Day23EmployeeWageUC9("BRIDGELABZ", 20, 20, 100);
                ewb1bridgelabz.computeEmpWage();
                System.out.println("Total BRIDGELABZ Employee wage: "+ewb1bridgelabz);

                final Day23EmployeeWageUC9 ewb1tcs= new Day23EmployeeWageUC9("TCS", 15, 25, 100);
                ewb1tcs.computeEmpWage();
                System.out.println("Total TCS Employee wage: "+ewb1tcs);

			    final Day23EmployeeWageUC9 ewb1infosys= new Day23EmployeeWageUC9("INFOSYS", 15, 25, 100);
                ewb1infosys.computeEmpWage();
                System.out.println("Total INFOSYS Employee wage: "+ewb1infosys);

        }

        /**
        *@return totalWage
        */
        public void computeEmpWage() {
                int totalWage=0;
                int totalEmpHrs=0;
                int totalWorkingDays=0;

                while(totalEmpHrs<maxHrsInMonth && totalWorkingDays<numberofWorkingDays) {
                        totalWorkingDays++;

                        final int empHrs=getEmpHrs();
                        final int empWage=empHrs*empRate;
                        totalEmpHrs=empHrs;
                        totalWage+=empWage;
                }
                totalEmpWage = totalWage;
        }

        /**
        *get employee hours
        *@return total Employee Wages
        */
        public int getEmpHrs() {
                final int isFullTime=1;
                final int isPartTime=2;
                int empHrs=0;

                //get random value
                final double randomValue=Math.floor(Math.random()*10)%3;

                switch((int)randomValue) {
                        case isFullTime:
                 empHrs = 8;
                 break;
         case isPartTime:
                 empHrs = 4;
                 break;
         default:
                 empHrs = 0;
                 break;
                }
                return empHrs;
        }
        
        
        // @override 
        public String toString() {
        	return "Total emp Wage got company :"+companyName+" is "+totalEmpWage;
        }
} 
