// Reads contacts from an input file, stores them in different data structures, and writes back to output files
import java.io.*;
import java.util.*;
import java.nio.file.Paths;
public class GenericCollectionTest {
	public static void main(String[] args) {
		
		ArrayList<Contact> arrayList = new ArrayList<Contact>();
		List<Contact> linkedList= new LinkedList<>(); 
		PriorityQueue<Contact> priorityQueue = new PriorityQueue<>();
		Set<Contact> hashSet = new HashSet<>();
		SortedSet<Contact> treeSet = new TreeSet<>();
		SortedSet<Contact> sortedTreeSet = new TreeSet<>(new LastNameComparator()); // uses construct comparator instead of natural
		Map<String, Contact> hashMap = new HashMap<>();
		
		// open contacts.txt read contacts
		try (Scanner input = new Scanner(Paths.get("contacts.txt")).useDelimiter("\\s+")){ // In fact, you can omit useDelimiter("\\s+") because default delimiter for Scanner is whitespace
			// use white space delimiter so the first string is assigned to SSN , the second to firstName, the third to lastName
			// and the fourth to phone number
			
			while (input.hasNext()) {
				//initialize instance variables
				String socialSecurity = input.next();
				String firstName= input.next();
				String lastName = input.next();
				String phoneNumber = input.next();
				
				//store each contact as an object in an arrayList 
				arrayList.add(new Contact(socialSecurity,firstName,lastName,phoneNumber));
				//store each contact as an object in a linked list
				linkedList.add(new Contact(socialSecurity,firstName,lastName,phoneNumber));
				//store contacts as an object in a priority queue
				priorityQueue.offer(new Contact(socialSecurity,firstName,lastName,phoneNumber));
				// store in an object in hash sets
				hashSet.add(new Contact(socialSecurity,firstName,lastName,phoneNumber));
				// store an object in a tree set
				treeSet.add(new Contact(socialSecurity,firstName,lastName,phoneNumber));
				// store contacts an object in a hash map
				hashMap.put(socialSecurity, new Contact(socialSecurity,firstName,lastName,phoneNumber));
			}
			//new tree set to hold the sorted contacts in the treeSet
			sortedTreeSet.addAll(treeSet); 
		}
		catch (IOException e) {
			System.out.println("File not found");
		}

												//WRITE BACK TO UTPUT FILES
		// store arrayList of contacts in arrayList file
		storeToFile("contactsArrayList.txt", arrayList);
		
		// store sorted arrayList in file
		Collections.sort(arrayList,new LastNameComparator()); // use comparator to sort by last name
		storeToFile("contactsArrayListOrderByLastName.txt", arrayList);
		
		// store linkedList of contacts in linkedList file
		storeToFile("contactsLinkedList.txt", linkedList);
		
		// Store priority queue contacts in a file
		storeToFile("contactsPriorityQueue.txt", priorityQueue);
		
		// store hash set contacts in a file
		storeToFile("contactsHashSet.txt",hashSet);
		
		// store tree set contacts in a file
		storeToFile("contactsTreeSet.txt", treeSet);
		
		// store sorted treeSet in file 
		storeToFile("contactsTreeSetOrderByLastname.txt", sortedTreeSet);
		
		// Store hashMap contacts (values only/not keys)in a file
		Set<String> hashMapKeys = hashMap.keySet();  // return a set of the keys in the hashMap
		storeToFile("contactsHashMap.txt", hashMapKeys,hashMap);
	}
	
	
	// method to store/write contact from an Iterable data structure to a file
	//takes in outPut file name and data structure type (arrayList, treeSet etc...) as a parameter
	public static void storeToFile(String outputFile, Iterable<Contact> collection) {
		try (Formatter output = new Formatter(outputFile)) {
			// if data structure is a priority queue use poll method to read each contact 
			if (collection instanceof PriorityQueue) {
				while (((PriorityQueue) collection).size() > 0) {
					output.format("%s", ((PriorityQueue) collection).poll());
				}
				
			}
			// for arrayList, linkedList, hashSet and treeSet iterate through the collection and print each object to output file
			for (Contact contact: collection) {
				output.format("%s", contact);
			}
		}
		catch (IOException e) {
			System.out.println("File not found");
		}
	}
	
	// method storeToFile above is overloaded here to be specifically used for hashMaps 
	// takes in String set that contains the keys, the out put file name, and hash map as a parameter
	public static void storeToFile(String outputFile, Set<String> keys, Map<String, Contact> map) {
		try (Formatter output = new Formatter(outputFile)) {
			// iterate through the keys string set
			for (String key: keys) {
				 //store the hash set values (the contacts) into a file
				output.format("%s", map.get(key));	
			}
		}
		catch (IOException e) {
			System.out.println("File not found");
		}
	}


}
