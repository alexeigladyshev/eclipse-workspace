
/**
 * 
 * @author alex lawson
 *
 */


//abstract table class
//implemented as a Binary Search Tree
public abstract class Table {
	
//abstract methods that I implement in AddressBook class
	
	public abstract boolean insert(String key, String value);
	
	public abstract String lookUp(String key);
	
	public abstract boolean delete(String key);
	
	public abstract boolean update(String key, String newValue);
	
	public abstract int displayAll();

//new method for the BST address book
	public abstract void save(String filename);
	
}
