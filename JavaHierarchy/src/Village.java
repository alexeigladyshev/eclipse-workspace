

public class Village {

	protected String name;
	protected int houses;
	
	public Village(String name, int houses) {
		
		this.name=name;
		this.houses=houses;	
	}
	
	@Override
	public String toString() {
		return String.format("This VILLAGE is called %s and has %d houses.\n\n", 
				name, houses);
	}
	
}
