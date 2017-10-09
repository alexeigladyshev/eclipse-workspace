import java.util.Scanner;

public class TemperatureConverter {

	private enum Menu {CELCIUS_TO_FAHRENHEIT, FAHRENHEIT_TO_CELCIUS, QUIT, TRY_AGAIN};
	
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int num;
		int numberOfConversions=0;
		Menu decision;
		do {
			System.out.println("1. Convert from Celcius to Fahrenheit");
			System.out.println("2. Convert from Fahrenheit to Celcius");
			System.out.println("3. Quit");
			System.out.print("Select a menu: ");
			
			num = input.nextInt();
			
			decision = intToEnumMenu(num);
			
			double temp;
			switch( decision ) {
			
				case CELCIUS_TO_FAHRENHEIT: 
				case FAHRENHEIT_TO_CELCIUS: {
					System.out.print("Enter a temperature: ");
					temp = input.nextDouble();
				
					calcTemp(decision, temp);
					numberOfConversions++;
				} break;
				
			case TRY_AGAIN:
				System.out.println("Please enter a correct number.\n");
				break;
			case QUIT:
				System.out.println("Thank you. Goodbye!\n");
			}
			
			
		}while(decision != Menu.QUIT && numberOfConversions<3);
		
		if (decision != Menu.QUIT)
			System.out.println("Thank you. Goodbye!\n");
		
	}
	
	static void calcTemp(Menu decision, double temp) {
		System.out.printf("Answer: %.0f%s = %.2f%s\n\n", 
				temp,
				(decision== Menu.CELCIUS_TO_FAHRENHEIT? "C":"F"),
				(decision== Menu.CELCIUS_TO_FAHRENHEIT? temp*9/5+32 : (temp-32)*5/9),
				(decision== Menu.CELCIUS_TO_FAHRENHEIT? "F":"C")
				);
	}
	
	static Menu intToEnumMenu(int selection) {
		
		switch(selection) {
		case 1:
			return Menu.CELCIUS_TO_FAHRENHEIT;
		case 2:
			return Menu.FAHRENHEIT_TO_CELCIUS;
		case 3:
			return Menu.QUIT;
		default:
			return Menu.TRY_AGAIN;
		}
		
	}
	
}
