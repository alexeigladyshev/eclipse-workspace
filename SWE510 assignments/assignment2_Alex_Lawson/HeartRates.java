import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class HeartRates {

	private String firstName, lastName;
	int month, day, year;
	
	public HeartRates(String firstName, String lastName, int month,
			int day, int year) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	//calculates age of individual
	public float calculateAge()
	{
		float age = ChronoUnit.YEARS.between(
		LocalDate.of(year , Month.of(month), day), LocalDate.now());
		return age;

	}
	public float maximumHeartRate() {
		return (float) (220.0-calculateAge() );
	}
	
	public float bottomTargetHR() {
		return (float) (0.5*maximumHeartRate() );
	}
	public float topTargetHR() {
		return (float) (0.85*maximumHeartRate() );
	}
	
	public void printHeartRateInfo() {
		
		System.out.format("%s %s is %.0f years old. The maximum heart rate is %.1f. "+
		"The range of target heart rate is from %.1f to %.1f.", firstName, lastName, calculateAge(),
		maximumHeartRate(), bottomTargetHR(), topTargetHR() );
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
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
}
