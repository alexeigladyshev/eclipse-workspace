package testproject;

import employeeclasses.*;

public class CompensationTest {

	/**
	 * @author Alex Lawson
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
