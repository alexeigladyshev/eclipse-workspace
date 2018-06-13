
public class City extends Town {

	//has 1 new instance variable
	protected int parks;

	//calls the constructor from the inherited class
	public City(String name, int houses, int cars, int stores, int parks) {
		super(name, houses, cars, stores);
		this.parks = parks;
	}

	//overrides the toString method
	@Override
	public String toString() {
		return String.format("This CITY is called %s and has %d houses.\n"
				+ "In addition, this CITY has %d cars and %d stores.\n" + "Also, the CITY has %d parks.\n\n", name,
				houses, cars, stores, parks);
	}
}
