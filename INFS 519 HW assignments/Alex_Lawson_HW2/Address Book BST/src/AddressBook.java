import java.io.PrintWriter;

/**
 * @author alex lawson
 */


//a concrete implementation of the abstract Table class
public class AddressBook extends Table{

	public AddressBook() {
		//empty constructor
	}
//the root of the BST
	private Node root;
	private int count = 0;
//inner class used for this application
	Saver saver = new Saver();
	
	//inserts a new entry to the table. If an entry already exists with the given key value make no insertion
	//and return false
	@Override
	public boolean insert(String key, String value) {	
		
	//if tree is empty, make this Node the root node
		if ( isEmpty() ) {
			root = new Node(key, value);
			count++;				//for the initial node creation I also have to update count
			return true;
		}
		insertNode(root, key, value); //start from the root of the tree and start traversing
		
		count++;		//update the count after inserting a new node
		return true; // method returns true
	}
	
	private Node insertNode(Node node, String key, String value) {
		
		/*if the tree is empty, return a new node*/
		if (node == null) {
			node = new Node(key, value);
			return node;
		}
		/*otherwise, recur down the tree*/
		if (node.getKey().compareToIgnoreCase(key) > 0) {
			node.setLeftNode( insertNode(node.getLeftNode(), key, value) );
		}
		else if (node.getKey().compareToIgnoreCase(key) < 0) {
			node.setRightNode( insertNode(node.getRightNode(), key, value) );
		}
		
		/* return the unchanged node pointer */
		return node;
	}

	//Looks up the entry with the given key and returns the associated value.
	//if no entry is found null is returned.
	@Override
	public String lookUp(String key) {
		
		Node lookingForNode = lookUpNode(root, key);
		if (lookingForNode == null)     //if lookUpNode returns null, then this method returns null
			return null;
		
		return lookingForNode.getValue();  //else return the value associated with given node
		
	}
	
/*returns the node with the given key*/
	private Node lookUpNode(Node node, String key) {
		
		/*base case of our recursive method*/
		if (node == null || node.getKey().compareToIgnoreCase(key) == 0) {
			return node;
		}
		/*key we're looking for is less than current node's key*/
		if (node.getKey().compareToIgnoreCase(key) > 0) {
			return lookUpNode(node.getLeftNode(), key);
		}
		/*else return the right node*/
		return lookUpNode(node.getRightNode(), key);
	
	}

//Deletes the entry with the given key. If no entry is found returns false.
	@Override
	public boolean delete(String key) {
			
		if (lookUp(key) == null)
			return false;
		
		root = deleteNode(root, key);
		count--; 	//decrement the count variable
		return true;
	}
	
/* A recursive function to delete a node*/
    private Node deleteNode(Node node, String key)
    {
        // Base Case: If the tree is empty
        if (node == null)  return node;

        // Otherwise, recur down the tree
        if (node.getKey().compareToIgnoreCase(key) > 0)
            node.setLeftNode(deleteNode(node.getLeftNode(), key));
        else if (node.getKey().compareToIgnoreCase(key) < 0)
            node.setRightNode( deleteNode(node.getRightNode(), key));

        // if key is same as root's key, then This is the node to be deleted
        else
        {
            // node with only one child or no child
            if (node.getLeftNode() == null)
                return node.getRightNode();
            else if (node.getRightNode() == null)
                return node.getLeftNode();

            // node with two children: Get the smallest key in the right subtree
            node.setKey( minValue(node.getRightNode() ));

            // Delete the inOrder successor
            node.setRightNode( deleteNode(node.getRightNode(), node.getKey() ));
        }
        return node;
    }

//returns smallest in the right subtree
    private String minValue(Node node)
    {
        String minvalue = node.getKey();
        while (node.getLeftNode() != null)
        {
            minvalue = node.getLeftNode().getKey();
            node = node.getLeftNode();
        }
        return minvalue;
    }

	
	//replaces the old value associated with the given key with the newValue string.
	@Override
	public boolean update(String key, String newValue) {
		
		Node nodeToUpdate = lookUpNode(root, key);
		nodeToUpdate.setValue(newValue);
		
		return true;
	}

	//displays all values in the address book. 
	@Override
	public int displayAll() {	/*I chose to do InOrder traversal*/
		
		inOrderPrint(root);
		return count;
	}
	
	private void inOrderPrint(Node node) {
		
		if (node == null) return;
		inOrderPrint(node.getLeftNode() );
		System.out.printf("Name: %s, Address: %s\n", node.getKey(), node.getValue() );
		inOrderPrint(node.getRightNode() );
	}
	
	
	//returns whether there are any entries in the address book.
	private boolean isEmpty() {
		
		return (root == null);
	}
	
	@Override
	public void save(String filename) {
		
		saver.startWriting(filename);
		preOrderWrite(root);
		saver.close();
		
	}
	
	//this methods write to a file
		private void preOrderWrite(Node node) {
			
			if (node == null) return;
			
			saver.write(String.format("%s\n%s", node.getKey(), node.getValue()));
			
			preOrderWrite(node.getLeftNode() );
			preOrderWrite(node.getRightNode() );
		}
	
}


/*a separate inner class used to save to a file*/
class Saver{
	
	PrintWriter writer;

//initialize the object with the name of the text file to save to
	public void startWriting(String filename) {
		try {
			/*save the text file to the src folder of the application*/
			writer = new PrintWriter("src/" + filename);
			} catch (Exception e) {
				System.err.println("Error opening file");
			}
	}
	
//write a new line to the text file
	public void write(String line) {
		
		writer.println(line);
	}

//close the file so the information saves
	public void close(){
		
		writer.close();
	}
	
}