import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;
import java.io.IOException;
import java.util.Scanner;

/**@author Alex Lawson
 * 
 * This program alters the StringConverter program to read and write to a file in the project.
 * All additional annotations are provided inside of the code.
 */


public class StringConverterFileIO {

	private enum Menu {
		//invalid input means that the program doesn't know which one of the 3 cases you are attempting
		PHONE_NUMBER(13, "PHONE NUMBER:"), SSN(23, "SOCIAL SECURITY NUMBER:"), 
		WEBSITE_LOGIN_ID(9, "LOGIN ID:"), INVALID_INPUT(0, "<<INVALID INPUT:>>");
		private int numChars;
		private String phrase;
		
		Menu(int numChars, String phrase){
			this.numChars = numChars;
			this.phrase = phrase;
		}
		public int getNumChars() {
			return numChars;
		}
		public String getPhrase() {
			return phrase;
		}
	}

	public static void main(String[] args) {
	
		Path input, output;
		
		//make sure that two parameters are passed in during runtime
		try {
			input = Paths.get(args[0]);
			output = Paths.get(args[1]);
		}
		catch(Exception e) {
			System.err.print("Please enter valid input and output file names\n");
			return;
		}
		
		String value;
		Menu decision;
		
		//this arraylist records the output of the file, and then later we record it to a different file
		ArrayList<String> list = new ArrayList<String>();
		
		try (Scanner in = new Scanner(input)){    //start reading from a file
			while(in.hasNext()) {
				value = in.nextLine();
				//we have our enum value of what we want to do with our string
				decision = StringToEnum(value);
				//we have formatted our string to see if it's in the correct format or not
				value = value.substring(decision.getNumChars()).trim();

				//this switch statement is similar to the one used in StringConverter
				switch (decision) {
				case PHONE_NUMBER:
					if (!validPhoneNumber(value)) {
						list.add(String.format("%s <<Invalid phone number>>", decision.getPhrase()));
						break;
					}
					list.add(String.format("%s %s", decision.getPhrase(), printPhoneNumber(value)));
					break;
				case SSN:
					if (!validSocialSecurityNumber(value)) {
						list.add(String.format("%s <<Invalid Social Security number>>", decision.getPhrase()));
						break;
					}
					list.add(String.format("%s xxx-xx-%s",decision.getPhrase(), value.substring(7)));
					break;
				case WEBSITE_LOGIN_ID:
					if (!validWebsiteLoginID(value)) {
						list.add(String.format("%s <<Invalid loginID>>", decision.getPhrase()));
						break;
					}
					String loginID = value.split("@")[0].replaceAll("[^a-zA-Z0-9]", "");
					
					if (loginID.length()==0){
						list.add(String.format("%s Your loginID is zero characters after removing special characters. "
								+ "Please use another loginID", decision.getPhrase()));
						break;
					}
					if (loginID.length()>=8) {
						loginID = loginID.substring(0,8);
					}
					
					list.add(String.format("%s %s", decision.getPhrase(), loginID));
					break;
				default:
					list.add(String.format("%s %s", decision.getPhrase(), value));
				}
				
			}
		} catch(IOException | NoSuchElementException | IllegalStateException e) {
			//e.printStackTrace();
			System.err.println("Incorrect files, try again");
		}
		
		//this try-catch statement prints the arraylist to the output file specified by user
		try {
			Files.write(output,list, Charset.defaultCharset());
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("***Your file has been processed***");
	}
	//end of the Main method************************
	
	private static Menu StringToEnum(String str) {
		
		if (str.toLowerCase().startsWith("phone number:")) {
			return Menu.PHONE_NUMBER;
		}
		else if(str.toLowerCase().startsWith("social security number:")) {
			return Menu.SSN;
		}
		else if(str.toLowerCase().startsWith("login id:")) {
			return Menu.WEBSITE_LOGIN_ID;
		}
		else {
			return Menu.INVALID_INPUT;
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
		public static String printPhoneNumber(String number) {
			char[] numberChar = number.toCharArray();
			for (int i=0; i<numberChar.length; i++) {
				if (!Character.isDigit(numberChar[i]) && numberChar[i]!='-') {//if the char is not digit and not '-'
					numberChar[i] = letterToNumber(numberChar[i]);
				}
			}
			return new String(numberChar);
		}
		
		//converts letters into numbers of a phone number
		//a lot easier way to write this method, lol
		//don't even need this method, because can you regular statements
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
