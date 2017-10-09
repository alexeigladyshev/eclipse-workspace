
public class TableOfSquaresAndCubes {

	public static void main(String[] args) {
	

		
		System.out.printf("%-10s%-10s%-10s\n","number","square","cube" );
		
		for (int i=0; i<=15;i++) {
			
			
			System.out.format("%-10d%-10d%-10d%n",i, i*i, i*i*i);
		}

	}

}
