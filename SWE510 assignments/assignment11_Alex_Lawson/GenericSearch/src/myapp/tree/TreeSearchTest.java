package myapp.tree;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.gmu.swe510.tree.Tree;

/**
 * 
 * @author Alex Lawson
 * test program for the search methods in the tree class
 *
 */

public class TreeSearchTest {

	public static void main(String[] args) {

		//creating a tree of Contact types
		Tree<Contact> contactTree = new Tree<>();
		
		String SSN, first, last, phoneNumber;
		// start reading from a file for a tree of type Contacts
		try (Scanner in = new Scanner(Paths.get("contact_sort.txt"))) {
			while (in.hasNext()) {
				SSN = in.next();
				first = in.next();
				last = in.next();
				phoneNumber = in.next();
				contactTree.insertNode(new Contact(SSN, first, last, phoneNumber));
			}
		} catch (IOException | NoSuchElementException | IllegalStateException e) {
			System.err.println("Invalid input");
		}
		
		//creating a tree of String types
		
		Tree<String> stringTree = new Tree<>();
		
		try (Scanner in = new Scanner(Paths.get("string_sort.txt"))){    
			while(in.hasNext()) {
				
				stringTree.insertNode(in.next().replaceAll("[^a-zA-Z0-9]", "").toLowerCase() );
				
			}				
		}catch(IOException | NoSuchElementException | IllegalStateException e) {
			System.err.println("Invalid input");
		}
	
		//creating a tree of Integer types
		
		Tree<Integer> integerTree = new Tree<>();
		
		try (Scanner in = new Scanner(Paths.get("integer_sort.txt"))){    
			while(in.hasNext()) {
				
				integerTree.insertNode(in.nextInt() );
			}				
		}catch(IOException | NoSuchElementException | IllegalStateException e) {
			System.err.println("Invalid input");
		}
	
		//getting input from user about which tree they want to traverse
		
		Scanner in = new Scanner(System.in);
		String decision = "", key;
		
		//ask the user whether they want to check if the given element exists, until they enter -1
		
		while (decision.compareTo("-1") != 0) {
			
			System.out.println(
					"Pls enter which tree you want to traverse (C for contact, S for string, I for integer). "
					+ "Enter -1 to quit: ");
			decision = in.nextLine();
			
			if (decision.compareTo("-1") == 0) {
				System.out.printf("\nGoodbye!");
				break;
			}
			
			System.out.println("Pls enter the key you want to search for: ");
			key = in.nextLine();
			System.out.println("\n" + key);

			//based on which decision the user makes, traverse the various trees
			
			switch (decision) {
			case "C":
			case "c":
				System.out.println(contactTree.search(new Contact(key, "", "", ""))+"\n");
				break;
			case "S":
			case "s":
				System.out.println(stringTree.search(key.toLowerCase() )+"\n");
				break;
			case "I":
			case "i":
				System.out.println(integerTree.search(Integer.parseInt(key))+"\n");
				break;
			default:
				System.out.println("You did not enter a valid option!\n");
					}
		}
	}
}
