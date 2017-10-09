
public class Town extends Village {

	protected int cars;
	protected int stores;
	
	public Town(String name, int houses, int cars, int stores) {
		super(name, houses);
		this.cars=cars;
		this.stores=stores;
	}
	
	@Override
	public String toString() {
		return String.format("This TOWN is called %s and has %d houses.\n"
				+"In addition, this TOWN has %d cars and %d stores.\n\n",
				name, houses, cars, stores);
	}
}
