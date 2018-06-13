
//Town class extends the Village class
public class Town extends Village {

	//has 2 additional variables in addition to the variables in the base class
	protected int cars;
	protected int stores;

	//constructor calls the constructor from the inherited class
	public Town(String name, int houses, int cars, int stores) {
		
		super(name, houses);
		this.cars = cars;
		this.stores = stores;
	}

	//Again this class overrides the toString method from the inherited class
	@Override
	public String toString() {
		return String.format(
				"This TOWN is called %s and has %d houses.\n" + "In addition, this TOWN has %d cars and %d stores.\n\n",
				name, houses, cars, stores);
	}

}
