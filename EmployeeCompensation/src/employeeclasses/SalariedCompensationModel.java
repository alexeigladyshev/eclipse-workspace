package employeeclasses;

public class SalariedCompensationModel extends CompensationModel{

	private double weeklySalary;
	
	public SalariedCompensationModel(double weeklySalary) {
		
		this.weeklySalary = weeklySalary;
	}
	
	
	public double earnings() {
		
		return weeklySalary;
	}
	
	public void setWeeklySalary(double weeklySalary) {
		
		if (weeklySalary < 0.0) {
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");
		}
		this.weeklySalary=weeklySalary;
	}
}
