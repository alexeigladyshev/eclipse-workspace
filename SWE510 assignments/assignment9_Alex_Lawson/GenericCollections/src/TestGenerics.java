import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 
 * @author Alex Lawson
 *
 *We implement the hashCode() and equals() methods our own way so the programs compares objects
 *based on social security number, not the generic methods from the Object class.
 *
 *
 */

public class TestGenerics {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		//1. store contacts to an ArrayList
		ArrayList<Contact> arrayList = new ArrayList<Contact>();
		
		//we will use these instance variables throughout the code
		String SSN, first, last, phoneNumber;
		//String s;
		//start reading from a file
		try (Scanner in = new Scanner(Paths.get("contacts.txt"))){    
			while(in.hasNext()) {
				SSN = in.next();
				first = in.next();
				last = in.next();
				phoneNumber = in.next();
				arrayList.add(new Contact(SSN, first, last, phoneNumber) );
			}
		System.out.println("ArrayList of Contacts created");
				
		}catch(IOException | NoSuchElementException | IllegalStateException e) {
			System.err.println("Invalid input");
		}
		
		//print the arrayList to the contactsArrayList.txt file
		try (Formatter out = new Formatter("contactsArrayList.txt")){
			for (int i =0; i< arrayList.size(); i++) {
				out.format("%s%n",arrayList.get(i).toString());
			}
			
		}catch (FileNotFoundException | NoSuchElementException e) {
			System.err.println("Invalid output");
		}
		
		//2. create LastNameComparator object
		LastNameComparator comparator = new LastNameComparator();
		//sort the arrayList
		Collections.sort(arrayList, comparator);
		
		try (Formatter out = new Formatter("contactsArrayListOrderByLastName.txt")){
			for (int i =0; i< arrayList.size(); i++) {
				out.format("%s%n",arrayList.get(i).toString());
			}
			
		}catch (FileNotFoundException | NoSuchElementException e) {
			System.err.println("Invalid output");
		}
		System.out.println("ArrayList of Contacts by Last Name created");
		
		/*3. create linked list, and store the contacts into the LinkedList
		 similar process to what I did with ArrayList above
		 */
		LinkedList<Contact> linkedList = new LinkedList<Contact>();
			
		try (Scanner in = new Scanner(Paths.get("contacts.txt"))){    
			while(in.hasNext()) {
				SSN = in.next();
				first = in.next();
				last = in.next();
				phoneNumber = in.next();
				linkedList.add(new Contact(SSN, first, last, phoneNumber) );
			}
				
		}catch(IOException | NoSuchElementException | IllegalStateException e) {
			System.err.println("Invalid input");
		}
		System.out.println("LinkedList of Contacts by created");
		
		// print the linkedList to the contactsArrayList.txt file
		try (Formatter out = new Formatter("contactsLinkedList.txt")) {
			while(linkedList.peekFirst() != null){
				out.format("%s%n", linkedList.pollFirst().toString());
			}

		} catch (FileNotFoundException | NoSuchElementException e) {
			System.err.println("Invalid output");
		}
		
		//4. PriorityQueue
		PriorityQueue<Contact> priorityQueue = new PriorityQueue<Contact>();
		
		try (Scanner in = new Scanner(Paths.get("contacts.txt"))){    
			while(in.hasNext()) {
				SSN = in.next();
				first = in.next();
				last = in.next();
				phoneNumber = in.next();
				priorityQueue.offer(new Contact(SSN, first, last, phoneNumber) );
			}
			System.out.println("PriorityQueue of Contacts created");	
		}catch(IOException | NoSuchElementException | IllegalStateException e) {
			System.err.println("Invalid input");
		}
		
		try (Formatter out = new Formatter("contactsPriorityQueue.txt")) {
			while(priorityQueue.peek()!=null) {
				out.format("%s%n", priorityQueue.poll().toString());
			}

		} catch (FileNotFoundException | NoSuchElementException e) {
			System.err.println("Invalid output");
		}
		
		//5. HashSet
		HashSet<Contact> hashSet = new HashSet<Contact>();
		
		try (Scanner in = new Scanner(Paths.get("contacts.txt"))){    
			while(in.hasNext()) {
				SSN = in.next();
				first = in.next();
				last = in.next();
				phoneNumber = in.next();
				hashSet.add(new Contact(SSN, first, last, phoneNumber) );
			}
			System.out.println("HashSet of Contacts created");	
		}catch(IOException | NoSuchElementException | IllegalStateException e) {
			System.err.println("Invalid input");
		}
		
		try (Formatter out = new Formatter("contactsHashSet.txt")) {
			//create an Iterator of type Contact
			Iterator<Contact> hashSetIterator = hashSet.iterator();
			while(hashSetIterator.hasNext() ) {
				out.format("%s%n", hashSetIterator.next().toString());
			}
			

		} catch (FileNotFoundException | NoSuchElementException e) {
			System.err.println("Invalid output");
		}
		
		//6. TreeSet
		TreeSet<Contact> treeSet = new TreeSet<Contact>();
		
		try (Scanner in = new Scanner(Paths.get("contacts.txt"))){    
			while(in.hasNext()) {
				SSN = in.next();
				first = in.next();
				last = in.next();
				phoneNumber = in.next();
				treeSet.add(new Contact(SSN, first, last, phoneNumber) );
			}
			System.out.println("TreeSet of Contacts created");	
		}catch(IOException | NoSuchElementException | IllegalStateException e) {
			System.err.println("Invalid input");
		}
		
		try (Formatter out = new Formatter("contactsTreeSet.txt")) {
			//create an Iterator of type Contact
			while(!treeSet.isEmpty()) {
				out.format("%s%n", treeSet.pollFirst().toString());
			}
			

		} catch (FileNotFoundException | NoSuchElementException e) {
			System.err.println("Invalid output");
		}
		
		//7. LastNameComparator class with TreeSet
		TreeSet<Contact> treeSetSortedByLastName = new TreeSet<Contact>(comparator);
		
		try (Scanner in = new Scanner(Paths.get("contacts.txt"))){    
			while(in.hasNext()) {
				SSN = in.next();
				first = in.next();
				last = in.next();
				phoneNumber = in.next();
				treeSetSortedByLastName.add(new Contact(SSN, first, last, phoneNumber) );
			}
			System.out.println("TreeSetSortedByLastName of Contacts created");	
		}catch(IOException | NoSuchElementException | IllegalStateException e) {
			System.err.println("Invalid input");
		}
		
		try (Formatter out = new Formatter("contactsTreeSetOrderByLastName.txt")) {
			//create an Iterator of type Contact
			while(!treeSetSortedByLastName.isEmpty()) {
				out.format("%s%n", treeSetSortedByLastName.pollFirst().toString());
			}
			
		} catch (FileNotFoundException | NoSuchElementException e) {
			System.err.println("Invalid output");
		}
		
		/*8. HashMap using a Social Security number as key and Contact as value
		Social Security number is the key and Contact Object is the value.
		*/
		HashMap<String, Contact> hashMap = new HashMap<String, Contact>();
		
		try (Scanner in = new Scanner(Paths.get("contacts.txt"))){    
			while(in.hasNext()) {
				SSN = in.next();
				first = in.next();
				last = in.next();
				phoneNumber = in.next();
				hashMap.put(SSN, new Contact(SSN, first, last, phoneNumber) );
			}
			System.out.println("HashMap of Social Security Number(key) and Contacts(value) created");	
		}catch(IOException | NoSuchElementException | IllegalStateException e) {
			System.err.println("Invalid input");
		}
		
		//I find it hardest to iterate through a HashMap
		Iterator<Entry<String, Contact>> it = hashMap.entrySet().iterator();
	    
	    try (Formatter out = new Formatter("contactsHashMap.txt")) {
			//create an Iterator of type Contact
			while(it.hasNext()) {
				HashMap.Entry pair = (HashMap.Entry) it.next();
				out.format("%s%n", pair.getValue().toString());
			}
			
		} catch (FileNotFoundException | NoSuchElementException e) {
			System.err.println("Invalid output");
		}
		
		
	}
}
