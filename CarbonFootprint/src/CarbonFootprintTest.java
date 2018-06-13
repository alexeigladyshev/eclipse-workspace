import java.util.ArrayList;

public class CarbonFootprintTest {

	public static void main(String[] args) {
		
		/*create 3 different objects of each of the three types of
		 * classes that implement the CarbonFootprint interface
		 */
		
		Car car1 = new Car(110, 2002);
		Bicycle bike1 = new Bicycle();
		Building b1 = new Building(500);
		
		Car car2 = new Car(145, 2007);
		Bicycle bike2 = new Bicycle();
		Building b2 = new Building(595);
		
		Car car3 = new Car(187, 2009);
		Bicycle bike3 = new Bicycle();
		Building b3 = new Building(612);
		
		/*creating an ArrayList of type CarbonFootprint
		 * and adds all of the objects to the ArrayList
		 */
		
		ArrayList<CarbonFootprint> carbonOutputters = new ArrayList<CarbonFootprint>();
		
		carbonOutputters.add(car1);
		carbonOutputters.add(bike1);
		carbonOutputters.add(b1);
		
		carbonOutputters.add(car2);
		carbonOutputters.add(bike2);
		carbonOutputters.add(b2);
		
		carbonOutputters.add(car3);
		carbonOutputters.add(bike3);
		carbonOutputters.add(b3);		
		
		/*use a simplified for statement to cycle through the objects and call the
		 * method in the interface
		 */
		
		System.out.println("IMPORTANT: I calculate the carbon footprint by taking how much money is spent per year on fuel,"
		+"and mulpitlying it by 100.\nThis is similar to what I noticed on the EPA website on their Carbon Footprint calculator.\n");
		
		for(CarbonFootprint cfp : carbonOutputters) {
			cfp.getCarbonFootprint();
			
			if (cfp instanceof Car)
				System.out.print(cfp);
		}

	}

}
