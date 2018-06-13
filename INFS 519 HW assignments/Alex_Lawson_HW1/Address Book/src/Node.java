
/**
 * 
 * @author alex lawson
 *
 */

public class Node {

	//instance variables of the Node class
	//key must be a unique value, this is verified during the process of the program
	private String key;
	private String value;
	private Node nextNode;
	
	public Node(String key, String value) {
		this.key = key;
		this.value = value;
		this.nextNode = null;
	}
	
	//setter and getter methods for all instance variables: key, value, nextNode
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Node getNextNode() {
		return nextNode;
	}
	public void setNextNode(Node nextNode) {
		
		this.nextNode = nextNode;		
	}
	
	//if there is a next node returns true, otherwise returns false
	public boolean hasNextNode() {
		if (nextNode == null)
			return false;
		
		return true;
	}
	
}
