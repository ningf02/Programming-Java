
public class PayrollSystemTest {

	public static void main(String[] args) {
		String[] firstNameOfEmployees = {"John", "Karen", "Sue", "Bob", "Rick"};
		String[] lastNameOfEmployees = {"Smith", "Price", "Jones", "Lewis", "Bridges"};
		String[] socialSecurityNumbers = {"111-11-1111", "222-22-2222", "333-33-3333", "444-44-4444", "555-55-5555"};
		System.out.println("Employees processed polymorphically: \n");
		
		SalariedEmployee salariedEmployee = new SalariedEmployee(firstNameOfEmployees[0],lastNameOfEmployees[0],socialSecurityNumbers[0],800);
        System.out.println(salariedEmployee.toString());
        System.out.println("earned $" + salariedEmployee.earnings() + "\n");
		
        HourlyEmployee hourlyEmployee = new HourlyEmployee(firstNameOfEmployees[1],lastNameOfEmployees[1],socialSecurityNumbers[1],16.75,40.00);
        System.out.println(hourlyEmployee.toString());
        System.out.println("earned $" + hourlyEmployee.earnings() + "\n");
        
        CommissionEmployee commissionEmployee = new CommissionEmployee(firstNameOfEmployees[2],lastNameOfEmployees[2],socialSecurityNumbers[2],10000.00,0.06);
        System.out.println(commissionEmployee.toString());
        System.out.println("earned $" + commissionEmployee.earnings() + "\n");
        
        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee(firstNameOfEmployees[3],lastNameOfEmployees[3],socialSecurityNumbers[3],5000.00,0.04,300.00);
        System.out.println(basePlusCommissionEmployee.toString());
        System.out.println("earned $" + basePlusCommissionEmployee.earnings() + "\n");
        
        PieceWorker pieceWorker = new PieceWorker(firstNameOfEmployees[4],lastNameOfEmployees[4],socialSecurityNumbers[4],2.25, 400);
        System.out.println(pieceWorker.toString());
        System.out.println("earned $" + pieceWorker.earnings() + "\n"); 
	}

}
