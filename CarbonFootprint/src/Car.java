
public class Car implements CarbonFootprint {

	// this class has 2 instance variables unique to this class
	//all three classes have instance variables and methods unique to them

	private int moneySpentOnGasoline;
	private int year;

	public Car(int moneySpentOnGasoline, int year) {

		this.moneySpentOnGasoline = moneySpentOnGasoline;
		this.year = year;
	}


	@Override
	public String toString() {

		return String.format("This car was made in %d.\n", year);
	}

	//this is the method that we must implement from the interface
	//to calculate the Carbon output per year, I multiply the money spent on fuel by 1000
	@Override
	public void getCarbonFootprint() {

		System.out.printf("The owner of the car spends $%,d on gasoline. "
		+"This car outputs %,d pounds of CO_2 per year.\n", moneySpentOnGasoline, moneySpentOnGasoline * 1000);

	}
}
