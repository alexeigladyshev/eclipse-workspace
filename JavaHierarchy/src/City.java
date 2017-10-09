

public class City extends Town {

	protected int parks;
	
	public City(String name, int houses, int cars, int stores, int parks) {
		super(name, houses, cars, stores);
		this.parks= parks;
	}
	
	@Override
	public String toString() {
		return String.format("This CITY is called %s and has %d houses.\n"
				+"In addition, this CITY has %d cars and %d stores.\n"
				+"Also, the CITY has %d parks.\n\n", name, houses, cars, stores, parks);
	}
}
