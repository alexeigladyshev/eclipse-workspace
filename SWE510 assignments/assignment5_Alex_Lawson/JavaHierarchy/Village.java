
public class Village {

	//has 2 variables that are protected, so inheriting classes can access them
	protected String name;
	protected int houses;
	
	//constructor that initializes the values
	public Village(String name, int houses) {

		this.name = name;
		this.houses = houses;
	}

	//override the toString method from the Object class
	@Override
	public String toString() {
		return String.format("This VILLAGE is called %s and has %d houses.\n\n", name, houses);
	}

}
