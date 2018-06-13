
/**
 * 
 * @author alex lawson
 *
 */


//abstract table class
public abstract class Table {
	
//abstract methods that I implement in AddressBook class
	
	public abstract boolean insert(String key, String value);
	
	public abstract String lookUp(String key);
	
	public abstract boolean delete(String key);
	
	public abstract boolean update(String key, String newValue);
	
	public abstract boolean markToStart();
	
	public abstract boolean advanceMark();
	
	public abstract String keyAtMark();
	
	public abstract String valueAtMark();
	
	public abstract int displayAll();
	
}
