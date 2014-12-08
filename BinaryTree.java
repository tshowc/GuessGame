/**
 * This class creates a Binary Tree that hold Nodes filled with a String. 
 * @author chao
 *
 */
public class BinaryTree {
	/**
	 * Default Constructor, sets root and current to null.
	 */
	BinaryTree(){
		root = null;
		current = null;
		
	}
	
	/**
	 * Inserts String info into Binary Tree based on String Move using a private
	 * recursive function.
	 * @param info Value to be inserted into Binary Tree
	 * @param move Value that is considered in order to properly place info
	 */
	void Insert(String info, String move){
		root = InsertItem(root, info, move);
	}
	
	/**
	 * Prints out the Binary Tree using private recursive function
	 */
	void Print(){
		PrintTree(root);
	}
	
	/**
	 * Evaluates whether or not Binary Tree is empty or not
	 * @return trueOrfalse True if root equals null
	 */
	boolean isEmpty(){
		if (root == null){
			return true;
		}
		else{
		return false;
		}
		
	}
	
	/**
	 * Evaluates whether or not current is located at a ending leaf/child node
	 * @return trueOrfalse True if current has to nodes to travel to
	 */
	boolean isAtEnd(){
		if ((current!= null) && (current.left == null && current.right == null)){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * Returns the value of the current node
	 * @return current.data The string located in the current node. 
	 */
	String getCurrentData(){
		return current.data;
		
	}
	
	/**
	 * Moves current pointer to the following right node, signaling a YES
	 */
	void moveCurrentYes(){
		current = current.right;
	}
	
	/**
	 * Moves current pointer to the following left node, signaling a NO
	 */
	void moveCurrentNo(){
		current = current.left;
	}
	/**
	 * Moves current to root, the starting point. 
	 */
	void setCurrentToStart(){
		current = root;
		
	}
	
	//Recursive Functions
	/**
	 * Inserts String value into the appropriate node.
	 * If newRoot is not fill then this method will fill it recursively
	 * @param newRoot node that is considered for insertion
	 * @param value String to be inserted into new Node
	 * @param move String that determines where to place other String values
	 * @return newRoot The node that was inserted into the Binary Tree
	 */
	private Node InsertItem(Node newRoot, String value, String move){
		if (newRoot == null)
        {
        			newRoot = new Node(value);
        //			System.out.println("ROOT INSERTED");
        			return newRoot;                  
		}
        else if (move == "Y"){
       // 	System.out.println("YES INSERTED");
			newRoot.right = InsertItem(newRoot.right, value, move);
		}
		else{ 
		//	System.out.println("NO INSERTED");
			newRoot.left = InsertItem(newRoot.left, value, move);
		}
		return newRoot;
	}
	 
	/**
	 * Prints the Binary Trees values in a preorder traversal
	 * @param root Starting node of the tree
	 */
	private void PrintTree(Node root){
		if (root != null){
			System.out.println(root.data);
			PrintTree(root.left);
			PrintTree(root.right);
		}
	}
	
	//Data Members
	protected Node root; //Starting Point of Binary Tree
	protected Node current; //Current position

}
