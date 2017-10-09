import java.util.Scanner;

public class SalaryCalculatorTest {

	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the number of employees you want to process: ");
		int numberOfEmployees = input.nextInt();
		
		SalaryCalculator[] employees = new SalaryCalculator[numberOfEmployees];
		
		
		String firstName, lastName;
		int hoursWorked, hourlyRate;
		
		int i=0;
		while(i<employees.length)
		{
			System.out.println("Please enter an employee's information below.");
			
			System.out.print("First name: "); input.nextLine();
			firstName = input.nextLine();
			
			System.out.print("Last name: ");
			lastName = input.nextLine();
			
			System.out.print("Number of hours worked last week: ");
			hoursWorked=input.nextInt();
			
			System.out.print("Hourly rate: ");
			hourlyRate=input.nextInt();
			System.out.println();
			
			employees[i] = new SalaryCalculator(firstName, lastName, hoursWorked, hourlyRate);
			employees[i].printEmployeeInfo();
			
			i++;
		}
		System.out.println("All employees have been processed!");
		
		
	}
}
