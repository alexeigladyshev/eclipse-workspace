
public class JavaHierarchyTest {

	public static void main(String[] args) {
		
		Village Towson = new Village("Towson", 30);
		Town Fairfax = new Town("Fairfax", 45, 60, 10);
		City Alexandria = new City("Alexandria", 87, 110, 32, 5);
		
		Village Albany = new Village("Albany", 22);
		Town Tulsa = new Town("Tulsa", 31, 65, 3);
		City Columbus = new City("Columbus", 100, 101, 15, 9);

		System.out.print(Towson);
		System.out.print(Fairfax);
		System.out.print(Alexandria);
		
		System.out.print(Albany);
		System.out.print(Tulsa);
		System.out.print(Columbus);
	}

}
