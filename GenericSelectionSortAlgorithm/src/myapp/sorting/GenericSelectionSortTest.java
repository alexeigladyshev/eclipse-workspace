package myapp.sorting;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.gmu.swe510.sorting.GenericSelectionSort;

/**
 * This method tests the GenericSelectionSort class for 3 different types of elements that
 * implement interface comparable.
 */
public class GenericSelectionSortTest {

	public static <E extends Comparable<E>> void main(String[] args) {

		//reading and sorting the Contacts from a file, and printing it to the screen
		
		ArrayList<Contact> contactArrayList = new ArrayList<>();
		
		String SSN, first, last, phoneNumber;
		//start reading from a file
		try (Scanner in = new Scanner(Paths.get("contact_sort.txt"))){    
			while(in.hasNext()) {
				SSN = in.next();
				first = in.next();
				last = in.next();
				phoneNumber = in.next();
				contactArrayList.add(new Contact(SSN, first, last, phoneNumber) );
			}				
		}catch(IOException | NoSuchElementException | IllegalStateException e) {
			System.err.println("Invalid input");
		}
		//convert an arrayList to an array, to use it with my code
		Contact[] contactArray = contactArrayList.toArray(new Contact[contactArrayList.size()]);
		
		//create new instance of the sort class
		
		GenericSelectionSort<E> genSelSortContact = new GenericSelectionSort(contactArray);
		
		System.out.println("Contact array BEFORE sorting:");
		genSelSortContact.printArray();
		System.out.println();
		System.out.println("Contact array AFTER sorting:");
		genSelSortContact.selectionSort();
		genSelSortContact.printArray();
		
		System.out.println();

		//reading and sorting strings from a file, and printing the result to the screen
		//creating an arrayList of strings
		ArrayList<String> stringArrayList = new ArrayList<>();
		
		try (Scanner in = new Scanner(Paths.get("string_sort.txt"))){    
			while(in.hasNext()) {
				
				stringArrayList.add(in.next().replaceAll("[^a-zA-Z0-9]", "").toLowerCase() );
				
			}				
		}catch(IOException | NoSuchElementException | IllegalStateException e) {
			System.err.println("Invalid input");
		}
		
		//convert the arrayList to an array
		String[] stringArray = stringArrayList.toArray(new String[stringArrayList.size()]);
		
		GenericSelectionSort<E> genSelSortString = new GenericSelectionSort(stringArray);
		
		System.out.println("String array BEFORE sorting:");
		genSelSortString.printArray();
		System.out.println();
		System.out.println("String array AFTER sorting:");
		genSelSortString.selectionSort();
		genSelSortString.printArray();
		
		System.out.println();
		
		//reading and sorting integers from the integer file, and printing them to the screen
		
		ArrayList<Integer> integerArrayList = new ArrayList<>();
		
		try (Scanner in = new Scanner(Paths.get("integer_sort.txt"))){    
			while(in.hasNext()) {
				
				integerArrayList.add(in.nextInt() );
			}				
		}catch(IOException | NoSuchElementException | IllegalStateException e) {
			System.err.println("Invalid input");
		}
		
		//convert the integer arrayList to array
		
		Integer[] integerArray = integerArrayList.toArray(new Integer[integerArrayList.size()]);

		GenericSelectionSort<E> genSelSortInteger = new GenericSelectionSort(integerArray);
		
		System.out.println("Integer array BEFORE sorting:");
		genSelSortInteger.printArray();
		System.out.println();
		genSelSortInteger.selectionSort();
		System.out.println("Integer array AFTER sorting:");
		genSelSortInteger.printArray();
		
		System.out.println();
		
		
	}
}
