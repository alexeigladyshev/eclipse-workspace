
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
	//added parent, height, and balanceFactor parameters to the AVL tree
	private Node parent;
	private int height;

//constructor
	public Node(String key, String value) {
		this.key = key;
		this.value = value;
		this.leftNode = null;
		this.rightNode = null;
		this.parent = null;
		height = 0;
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
	
	public Node getParent() {
		return parent;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getBalanceFactor() {
		
		
		
		if (this.getLeftNode() != null && this.getRightNode() != null) {
			return (this.getLeftNode().getHeight() - this.getRightNode().getHeight());
		}
		else if (this.getLeftNode() == null && this.getRightNode() == null) {
			return 0;
		}
		else if (this.getLeftNode() == null)
			return this.getRightNode().getHeight() + 1;
		else
			return this.getLeftNode().getHeight() + 1;
	}

	
}
