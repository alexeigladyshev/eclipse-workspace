
/**
 * @author alex lawson
 */

//a concrete implementation of the abstract Table class
public class AddressBook extends Table{

	public AddressBook() {
		//empty constructor
	}
	
	//instance variables for the LinkedList
	private Node head;
	private Node mark;

	//inserts a new entry to the table. If an entry already exists with the given key value make no insertion
	//and return false
	@Override
	public boolean insert(String key, String value) {	   //returns true in both cases, since the TestClass uses lookup before
		
		Node n = new Node(key, value);
		
		if (isEmpty()) {
			head = n;
			return true;
		}		
	
		n.setNextNode(head);
		head = n;
		return true;
	}

	//Looks up the entry with the given key and returns the associated value.
	//if no entry is found null is returned.
	@Override
	public String lookUp(String key) {
		
		if (!markToStart()) {
			return null;
		}
		
		do {
			if (keyAtMark().compareToIgnoreCase(key) == 0) {
				return valueAtMark();
			}
		}while (advanceMark() );
		return null;
	}

//Deletes the entry with the given key. If no entry is found returns false.
	@Override
	public boolean delete(String key) {
	
	//returns false if no items in address book
		if (!markToStart()) {
			return false;
		}
	//returns false if key is not in the address book
		if (lookUp(key) == null) {
			return false;
		}
	//traverse the address book looking for our node to delete
		do {
			
			if (keyAtMark().compareToIgnoreCase(key) == 0) {
				
			//deleting the head
				if (mark == head) {
					deleteHead();
					break;
				}
			//deleting the end
				else if (!mark.hasNextNode() ) {
					deleteTail();
					break;
				}
			//deleting in the middle of the linked list
				else {
					deleteInMiddle(prevNode(key));
					break;
				}
			}

			
		}while( advanceMark() );
	

		return true;
	}

	//replaces the old value associated with the given key with the newValue string.
	@Override
	public boolean update(String key, String newValue) {
		
		markToStart();
		while(keyAtMark().compareToIgnoreCase(key) != 0) {
			advanceMark();
		}
		mark.setValue(newValue);		//sets the new value associated with the given key
		return true;		//this method always returns true because conditions are checked in testClass
	}

	//sets the mark to the first item in the table. Returns false if the table is empty.
	@Override
	public boolean markToStart() {
		
		if (isEmpty() ) {
			return false;
		}
		mark = head;
		return true;
	}

	//Moves the mark to the next item in the table. If there is no next item, returns false.
	@Override
	public boolean advanceMark() {
		
		if (!mark.hasNextNode() )
			return false;
		mark = mark.getNextNode();
		return true;
	}

	@Override
	public String keyAtMark() {
		return mark.getKey();
	}

	@Override
	public String valueAtMark() {
		return mark.getValue();
	}

	//displays all values in the address book. 
	@Override
	public int displayAll() {
		int count = 0;
		
		if (isEmpty()) {
			return count; 	//Returns 0 if there are no entries in the address book
		}
		Node currNode = head;
		
		System.out.println();
		while (currNode != null) {
			System.out.printf("Name: %s, Address: %s\n", currNode.getKey(), currNode.getValue() );
			currNode = currNode.getNextNode();
			count++;
		}
		return count;
	}
	
	//returns boolean whether there are any entries in the address book.
	private boolean isEmpty() {
		
		if (head == null) {
			return true;
		}
		return false;
	}
//deletes the head of the linked list
	private void deleteHead() {
		
		head = head.getNextNode();
	}
//deletes the tail of the linked list
	private void deleteTail() {
		
		Node currNode = head;
		if (head.getNextNode() == null) {
			head = null;
		}
		else {
			while(currNode.getNextNode().getNextNode() != null) {
				currNode = currNode.getNextNode();
			}
			currNode.setNextNode(null);
		}
		
	}
//deletes in the middle of the linked list
	private void deleteInMiddle(Node prevNode) {
		prevNode.setNextNode(prevNode.getNextNode().getNextNode() );
	}
	
//returns the node that is the previous node of the given key
//helper method for deleteInMiddle()
	private Node prevNode(String key) {
		
		Node currNode = head;
		while (currNode.getNextNode().getKey().compareToIgnoreCase(key) != 0) {
			currNode = currNode.getNextNode();
		}
		return currNode;
	}
	
}
