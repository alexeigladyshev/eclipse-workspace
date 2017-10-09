import java.util.Scanner;

public class HeartRatesTest {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String firstName, lastName;
		int month, day, year;
		
		System.out.print("Enter the first name: ");
		firstName = input.nextLine();
		System.out.println();
		
		System.out.print("Enter the last name: ");
		lastName = input.nextLine();
		System.out.println();
		
		System.out.print("Enter the month of birth: ");
		month = input.nextInt();
		System.out.println();
		
		System.out.print("Enter the day of birth: ");
		day = input.nextInt();
		System.out.println();
		
		System.out.print("Enter the year of birth: ");
		year = input.nextInt();
		System.out.println();
		
		HeartRates heartRates = new HeartRates(firstName, lastName, month, day, year);
		
		heartRates.printHeartRateInfo();
		
	}
}
