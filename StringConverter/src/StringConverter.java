/**@author Alex Lawson
 * 
 * This program converts 3 different types of inputs into the correct format 
 * using regular expressions. All additional annotations are provided inside of the code
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringConverter {

	private enum Menu {
		PHONE_NUMBER, SSN, WEBSITE_LOGIN_ID, QUIT, TRY_AGAIN
	};

	public static void main(String[] args) throws InterruptedException {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int num=0;
		Menu decision;

		System.out.printf("**Welcome to the ID formatter program**\n\n");
		
		//user picks one of the 4 options
		do {
			//I need this thread sleep  because otherwise the error message prints incorrectly
			Thread.sleep(1);
			System.out.println("1. Convert a phone number");
			System.out.println("2. Convert a social security number");
			System.out.println("3. Convert a website login id");
			System.out.println("4. Quit\n");

			//catches an inputMismatchException from user
			boolean invalidinput = false;
			do {
				try {
					num = input.nextInt();
					invalidinput = true;
				} catch (InputMismatchException e) {
					System.err.println("Invalid selection");
					input.nextLine();
				}
			} while (!invalidinput);
			
			//change the integer to an enum object
			decision = intToEnumMenu(num);
			
			String value;
			
			input.nextLine();
			
			switch (decision) {
			case PHONE_NUMBER:
				System.out.print("Please enter a phone number in format xxx-xxx-xxxx: ");
				value = input.nextLine();
				if (!validPhoneNumber(value)) {
					System.out.println("Invalid phone number\n");
					break;
				}
				printPhoneNumber(value);
				break;
				
			case SSN:
				System.out.print("Please enter the Social Security Number in format xxx-xx-xxxx: ");
				value = input.nextLine();
				if (!validSocialSecurityNumber(value)) {
					System.out.println("Invalid Social Security number\n");
					break;
				}
				System.out.printf("The social security number is xxx-xx-%s\n\n", value.substring(7));
				break;
			
			case WEBSITE_LOGIN_ID:
				System.out.print("Please enter a loginID: ");
				value = input.nextLine();
				if (!validWebsiteLoginID(value)) {
					System.out.println("Invalid loginID\n");
					break;
				}
				//this line of code gets the string before the @ symbol, and gets rid of all the Special Characters
				String loginID = value.split("@")[0].replaceAll("[^a-zA-Z0-9]", "");
				
				if (loginID.length()==0){
					System.err.println("Your loginID is zero characters after removing special characters. "
							+ "Please use another loginID\n");
					break;
				}
				if (loginID.length()>=8) {
					loginID = loginID.substring(0,8);
				}
				
				System.out.printf("The loginID is: %s\n\n", loginID);
				
				break;
			case QUIT:
				System.out.println("Goodbye!");
				return;
			default:
				System.out.println("Please enter a valid selection\n");
			}

		} while (decision != Menu.QUIT);

	}

	//converts a number into an enum of type Menu
	static Menu intToEnumMenu(int selection) {

		switch (selection) {
		case 1:
			return Menu.PHONE_NUMBER;
		case 2:
			return Menu.SSN;
		case 3:
			return Menu.WEBSITE_LOGIN_ID;
		case 4:
			return Menu.QUIT;
		default:
			return Menu.TRY_AGAIN;
		}

	}
	
	//tests whether a phone number is in the valid format
	public static boolean validPhoneNumber(String number) {
		return number.matches("[a-zA-Z0-9]{3}-[a-zA-Z0-9]{3}-[a-zA-Z0-9]{4}");
	}
	//tests whether a social security number is in the valid format 
	public static boolean validSocialSecurityNumber(String number) {
		return number.matches("[0-9]{3}-[0-9]{2}-[0-9]{4}");
	}
	//tests whether a websiteLoginID is in the valid format
	public static boolean validWebsiteLoginID(String websiteID) {
		return websiteID.matches("\\S+@\\S+");
	}
	
	//prints a phone number but first converts any letters into digits
	public static void printPhoneNumber(String number) {
		char[] numberChar = number.toCharArray();
		for (int i=0; i<numberChar.length; i++) {
			if (!Character.isDigit(numberChar[i]) && numberChar[i]!='-') {//if the char is not digit and not '-'
				numberChar[i] = letterToNumber(numberChar[i]);
			}
		}
		System.out.printf("The telephone number is: %s\n\n", new String(numberChar));
	}
	
	//converts letters into numbers of a phone number
	private static char letterToNumber(char c) {
		
		switch(c) {
		case 'a':
		case 'A':
		case 'b':
		case 'B':
		case 'c':
		case 'C':
			return '2';
		case 'd':
		case 'D':
		case 'e':
		case 'E':
		case 'f':
		case 'F':
			return '3';
		case 'g':
		case 'G':
		case 'h':
		case 'H':
		case 'i':
		case 'I':
			return '4';
		case 'j':
		case 'J':
		case 'k':
		case 'K':
		case 'l':
		case 'L':
			return '5';
		case 'm':
		case 'M':
		case 'n':
		case 'N':
		case 'o':
		case 'O':
			return '6';
		case 'p':
		case 'P':
		case 'q':
		case 'Q':
		case 'r':
		case 'R':
		case 's':
		case 'S':
			return '7';
		case 't':
		case 'T':
		case 'u':
		case 'U':
		case 'v':
		case 'V':
			return '8';
		default:
			return '9';
		}
		
	}
	
}
