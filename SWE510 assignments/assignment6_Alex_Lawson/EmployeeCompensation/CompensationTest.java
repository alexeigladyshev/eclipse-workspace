
public class CompensationTest {

	/**
	 * @author Alex Lawson
	 * 
	 * Using the strategy pattern is a good way to keep your code clean, because your code only changes
	 * the very slightest bit in that instance where it must. Since in our example, employee was exactly the same 
	 * in every respect except for the CompensationModel, the code is very clean and easy to understand.
	 * 
	 * Another pro of this model is that if an employee changes roles in the company, changing the way that he or she
	 * is compensated becomes very easy, as we have seen in this class. You simply call a method to switch between 
	 * the different types of employees.
	 * 
	 * The cons of the strategy pattern are that there might be other differences in between the various types of employees
	 * than simply the way they are compensated.This type of model only tracks one change in the parameters, but for more
	 * changes, things can get complicated quickly, and it might be easier to use an inheritance model.
	 */
	
	public static void main(String[] args) {
		
		//all rates are weekly
		//create all 4 different types of classes that extend CompensationModel abstract class
		CompensationModel commissionCompensationModel = new CommissionCompensationModel(5000, 0.30);
		
		CompensationModel basePlusCommissionCompensationModel = new BasePlusCommissionCompensationModel(1000, 4500, 0.25);
		
		CompensationModel salariedCompensationModel = new SalariedCompensationModel(1250);
		
		CompensationModel hourlyCompensationModel = new HourlyCompensationModel(35, 50);
		
		//employee starts as commissionCompensationModel employee
		System.out.println("Employee starts as CommissionCompensationModel");
		Employee e = new Employee("Cassidy", "Smith", "xxx-xx-xxxx", commissionCompensationModel);
		System.out.printf("%s%n%n",e);
		
		//switch employee to BasePlusCommissionCompensationModel
		System.out.println("Changed employee to BasePlusCommissionCompensationModel");
		e.setCompensationModel(basePlusCommissionCompensationModel);
		System.out.printf("%s%n%n",e);
		
		//switch employee to SalariedCompensationModel
		System.out.println("Changed employee to SalariedCompensationModel");
		e.setCompensationModel(salariedCompensationModel);
		System.out.printf("%s%n%n",e);
		
		//finally, switch employee to HourlyCompensationModel
		System.out.println("Changed employee to HourlyCompensationModel");
		e.setCompensationModel(hourlyCompensationModel);
		System.out.printf("%s%n%n",e);
	}
}
