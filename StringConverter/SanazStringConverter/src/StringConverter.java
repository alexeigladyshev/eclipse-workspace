//package assinment8;

import java.util.*;

/**
 * @author Zahra Rajabi
 *
 */
public class StringConverter {

	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		while(true) {
			int option = menue(in);
			switch(option) {
			case 1:
				// phone number must be in the form of (xxx)xxx-xxxx, where x is a digit or an alphabet letter.
				System.out.println("Enter a phone number in: (xxx)xxx-xxxx");  
				String phone = in.nextLine();
				//calls validation
				if (validatePhone(phone)) {
					phone = convertPhone(phone);
					System.out.println("The phone number is :" + phone);
				}
				in.nextLine();
				break;
				
			case 2:
				System.out.println("Enter a social security number:");
				String ssn = in.nextLine();
				//calls validation
				
				// social security number must be in the form of xxx-xx-xxxx where x is a digit
				if (validateSocialSecurity(ssn)) {
					System.out.println("The social security number is "+  ssn.replace(ssn.substring(0, 6),"xxx-xx"));
					//System.out.println("The social security number is "+  ssn.replace(,"x"));
				}
				in.nextLine();
				break;
			case 3:
				System.out.println("Enter a login ID:");  
				String loginId = in.nextLine();
				//calls validation: The input login id must be digits, alphabet letters, or the special characters of !@#$%^&*.
				if (validateLoginId(loginId)) {
					loginId = convertLoginId(loginId);
					if (loginId.length() > 8) { //If the length of the user id after removing the special characters is greater than eight, 
						loginId = loginId.substring(0, 8); //truncate the remaining characters.
					}
					
					if (loginId.length() == 0) {
						System.out.println("ERROR: The login ID is not valid!\n");
					}
					else {
						System.out.println("The login id is " + loginId + "\n");
					}
				}
				//in.nextLine();
				break;
			case 4:
				System.out.println("Bye! "); 
				in.close();
				System.exit(0);
				 
			}
			
		}
		
		
	}
	
	public static boolean validatePhone(String phone) {
		// used pattern: [a-d[m-p]]	a through d, or m through p: [a-dm-p] (union)
		// //(WOA)-2T2-22DR --> (962)-282-2237
		String regex = "\\([1-9[a-zA-Z]][0-9[a-zA-Z]]{2}\\)[0-9[a-zA-Z]]{3}-[0-9[a-zA-Z]]{4}";
		return phone.matches(regex);
	}
	
	public static String convertPhone(String phone) {
		
		phone = phone.replaceAll("[abcABC]", "2");
		phone = phone.replaceAll("[defDEF]", "3");
		phone = phone.replaceAll("[ghiGHI]", "4");
		phone = phone.replaceAll("[jklJKL]", "5");
		phone = phone.replaceAll("[mnoMNO]", "6");
		phone = phone.replaceAll("[pqrsPQRS]", "7");
		phone = phone.replaceAll("[tuvTUV]", "8");
		phone = phone.replaceAll("[wxyzWXYZ]", "9");
		
		return phone;
	}
	
	public static boolean validateSocialSecurity(String ssn) {
		String regex = "\\d{3}-\\d{2}-\\d{4}";
		return ssn.matches(regex);
	}
	
	public static boolean validateLoginId(String loginId) {
		//String regex = "[1-9]\\d{2}-\\d{3}-\\d{4}";
		String regex = "([0-9]|[a-zA-Z]|[!@#$%^&*])*";
		return loginId.matches(regex);
	}
	
	public static String convertLoginId(String loginId) {
		String regex = "[!@#$%^&*]";
		loginId = loginId.replaceAll(regex, "");
		return loginId;
	}
	
	public static int menue(Scanner in) {
		int choice;
		while(true) {
			try {
				System.out.println("Select a menue:");
				System.out.println("1. Convert a phone number");
				System.out.println("2. Convert a social security number");
				System.out.println("3. Convert a website login id");
				System.out.println("4. Quit");
				
				choice = in.nextInt();
				in.nextLine();
				
				if (choice >= 1 | choice <= 4) {
					return choice;
				}
				else{ // if alphabetic choice is made
					System.out.println("You had an invalid selection! Try again.");
					continue;
				}
			} catch(InputMismatchException e){
				System.out.println("You had an invalid selection! Try again.");
				in.nextLine();
			}
			
			
			
		}
	}
	
}