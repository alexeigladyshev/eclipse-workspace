
//employee class as in the book, except with the compensationModel object inserted for different types of employees
public class Employee {

	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	private CompensationModel compensationModel;
	
	public Employee(String firstName, String lastName,
			String socialSecurityNumber, CompensationModel compensationModel) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.compensationModel = compensationModel;
	}
	
	public double earnings() {
		
		return compensationModel.earnings();
	}
	
	@Override
	public String toString() {
		
		return String.format("%s: %s %s%n%s: %s%n%s: $%.2f", "Employee name", getFirstName(), getLastName(), 
				"Social security number", getSocialSecurityNumber(), "earnings", this.earnings() );
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	
	//method to switch between the different compensation models
	public void setCompensationModel(CompensationModel compensationModel) {
		
		this.compensationModel = compensationModel;
	}
}
