
public class Bicycle implements CarbonFootprint {

	// this class doesn't have any instance variables

	//this is the method that we must implement from the interface
	@Override
	public void getCarbonFootprint() {

		System.out.println("This bicycle doesn't output any carbon when you ride it!!");
	}

}
