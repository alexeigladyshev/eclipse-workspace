
public class JavaHierarchyTest {

	//this application creates instances of all three objects with initialized values, and calls their toString methods
	
	public static void main(String[] args) {

		//create one of each of the populated areas
		
		Village Towson = new Village("Towson", 30);
		Town Fairfax = new Town("Fairfax", 45, 60, 10);
		City Alexandria = new City("Alexandria", 87, 110, 32, 5);
		
		//create another of each of the populated areas

		Village Albany = new Village("Albany", 22);
		Town Tulsa = new Town("Tulsa", 31, 65, 3);
		City Columbus = new City("Columbus", 100, 101, 15, 9);

		//call each of the object's toString() methods implicitly, by placing them inside of the "print" method
		
		System.out.print(Towson);
		System.out.print(Fairfax);
		System.out.print(Alexandria);

		System.out.print(Albany);
		System.out.print(Tulsa);
		System.out.print(Columbus);
	}

}
