
public class Building implements CarbonFootprint {

	// this class has 2 instance variables unique to this class

	private int moneySpentOnElectricity;

	public Building(int moneySpentOnElectricity) {

		this.moneySpentOnElectricity = moneySpentOnElectricity;
	}
	
	@Override
	public String toString() {
		return String.format("The money spent on electricity is $%,d."+
		"I multiply that number by 1000 to get the pounds per year of CO_2 emissions", moneySpentOnElectricity);
	}

	//this is the method that we must implement from the interface
	//to calculate the Carbon output per year, I multiply the money spent on fuel by 1000
	@Override
	public void getCarbonFootprint() {

		System.out.printf("The building owners spends $%,d on electricity. "
				+"This Building outputs %,d pounds of CO_2 each year.\n", moneySpentOnElectricity, moneySpentOnElectricity * 1000);
	}
}
