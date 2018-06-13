
import java.util.Scanner;


/**
 * 
 * @author alex lawson
 *
 */

public class TestClass {

//main method
	
//prompts to enter a name
	private static void promptName() {
		System.out.print("Please enter a name: ");
	}
//prompts to enter an address
	private static void promptAddress() {
		System.out.print("Please enter an address: ");
	}
	
		public static void main(String[] args) {
			
			AddressBook addressbook = new AddressBook();
			Character choice;
			String name, address;
			
			System.out.println("Welcome to the Address Book application!\n"
					+ "Note: all name entries are not case sensitive.\nPlease choose one of the options below:\n");
			
			//opens the scanner object in a try statement
				try (Scanner scan = new Scanner(System.in)) { 
					
				//continue presenting the menu until the user chooses to quit
					do {
						
						System.out.print("Add a name (n)\nLook up a name(l)\nUpdate address(u)\n"
								+ "Delete an entry(d)\nDisplay all entries(a)\nQuit(q)\n->");
						
					//application takes your choice as the first character of the string that you entered
						choice = scan.next().charAt(0);
						
						switch (choice) {
					//add a name
						case 'n':
						case 'N':
							promptName();
							scan.nextLine();		//need this to clear the next line and be ready to read user input
							name = scan.nextLine();
						//if the name is already in the address book
							if (addressbook.lookUp(name) != null) {
								System.out.println("This name already exists in your address book.\n");
								break;
							}
							
							promptAddress();
							address = scan.nextLine();
							addressbook.insert(name, address);		//insert the name if it's not already there
							System.out.println("Success!\n"); 				//double space for next option
							break;
					//look up a name
						case 'l':
						case 'L':
							promptName();
							scan.nextLine();		//need this to clear the next line and be ready to read user input
							name = scan.nextLine();
							address = addressbook.lookUp(name);
							if (address != null) {
								System.out.printf("Address of %s is: %s\n\n", name, address);
							}
							else {
								System.out.println("This name does not exist in your address book.\n");
							}
							break;
					//update address
						case 'u':
						case 'U':
							promptName();
							scan.nextLine();		//need this to clear the next line and be ready to read user input
							name = scan.nextLine();
							if (addressbook.lookUp(name) != null) { // if the entry exists in the address book
								System.out.print("Please enter new address: ");
								address = scan.nextLine();
								addressbook.update(name, address); // update the address for the user
								System.out.println("Address updated successfully!\n");
							}
							else {
								System.out.println("This name does not exist in your address book.\n");
							}								
							break;
					//delete an entry
						case 'd':
						case 'D':
							promptName();
							scan.nextLine();		//need this to clear the next line and be ready to read user input
							name = scan.nextLine();
							if (addressbook.delete(name) ) {			//deletes the name
								System.out.println("Deletion successful.\n");
							}
							else {
								System.out.println("No entry was deleted.\n");
							}
							break;
					//display all
						case 'a':
						case 'A':
							int numbOfEntries = addressbook.displayAll();	//display all the entries and return an int
							if (numbOfEntries == 0) {
								System.out.println("\nThere are no entries in your address book!\n");
								break;
							}
							
							System.out.printf("Number of entries: %d\n\n", numbOfEntries);
							break;
					//quit
						case 'q':
							System.out.println("\nHave a good day!\n");
							break;
					//if not one of the options above were selected, this is provided to the user
						default:
							System.out.println("\nPlease choose a valid option.\n");
						}
						
					} while (choice != 'q');
					
				} catch (Exception e) {
					System.err.println("Unable to open scanner object");
				}		
			
		}
	
}
