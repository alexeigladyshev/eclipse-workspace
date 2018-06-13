
/**
 * 
 * @author alex lawson
 *
 */

public class Node {

	//instance variables of the Node class
	//key must be a unique value, this is verified during the process of the program
	private String key;  //name
	private String value; //address
	private Node leftNode; //left node of a binary search tree
	private Node rightNode; //right node of a binary search tree

//constructor
	public Node(String key, String value) {
		this.key = key;
		this.value = value;
		this.leftNode = null;
		this.rightNode = null;
	}
	
	//setter and getter methods for all instance variables: key, value, leftNode, rightNode
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
	
	public void setLeftNode(Node leftNode) {
		
		this.leftNode = leftNode;	
	}
	
	public Node getLeftNode() {
		
		return leftNode;
	}
	
	public void setRightNode(Node rightNode) {
		
		this.rightNode = rightNode;
	}
	
	public Node getRightNode() {
		
		return rightNode;
	}
	
}
