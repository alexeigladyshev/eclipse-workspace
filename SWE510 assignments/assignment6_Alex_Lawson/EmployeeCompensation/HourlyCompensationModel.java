

public class HourlyCompensationModel extends CompensationModel{

	private double wage;
	private double hours;
	
	public HourlyCompensationModel(double wage, double hours) {
		this.wage = wage;
		this.hours = hours;
	}

	
	public double earnings() {
		
		if (getHours()<=40) {
			return getWage()*getHours();
		}
		else {
			return 40*getWage() + (getHours()-40) * getWage() * 1.5;
		}
	}

	//setter and getter methods
	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		this.wage = wage;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}
	
}
