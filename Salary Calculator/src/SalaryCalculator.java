
public class SalaryCalculator {

	
	private String firstName,lastName;
	private int hoursWorked, hourlyRate;
	
	public SalaryCalculator(String firstName, String lastName, int hoursWorked, int hourlyRate) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
	}
	
	public void printEmployeeInfo() {
		
		int salary;
		if (hoursWorked <=40) {
			salary = hoursWorked*hourlyRate;
		}
		else if (hoursWorked > 40){
			salary = (int)(40*hourlyRate+1.5*hourlyRate*(hoursWorked-40));
		}
		else salary = 0;
		System.out.printf("%s %s's salary is $%,d. This employee is a %s%n%n", firstName, lastName, salary, 
				(salary>=2307 ? "Highly-Compensated Employee." : "Non-Highly Compensated Employee."));		
		
		
	}
	
	//setter and getter methods for instance variables
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getHoursWorked() {
		return hoursWorked;
	}
	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	public int getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	
	
}
