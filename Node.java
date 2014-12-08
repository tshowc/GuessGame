/**
 * 
 */

/**
 * This class creates a Node that holds a String and left,right nodes. 
 * @author chao
 *
 */
public class Node {

	/**
	 * Default Constructor, sets left and right nodes to null
	 */
	Node(){
		left = null;
		right = null;
	}
	/**
	 * Non-default Constuctor, sets left and right nodes to null and sets String data to info
	 * @param info String value
	 */
	Node(String info){
		left = null;
		right = null;
		data = info;
		
	}
	
	protected Node left;
	protected Node right;
	protected String data;
	
	
}
