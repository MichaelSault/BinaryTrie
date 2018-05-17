/*** 
 * This is class implements a trie that holds a set of strings.
 * MyTrie stores stores nodes using class TreeNode
 * 
 * Name:  Michael Sault
 * Student Number: 8459820
 * Uottawa Email: msaul025@uottawa.ca
 * 
 *
 */

public class MyTrie {
	
	private TreeNode root = null;
	private TreeNode left, right = null;

	private int numNodes;

    // Constructor. Note that an empty trie (no strings added) contains the root node
	public MyTrie() {
		root = new TreeNode(null, null, null,false); 
		numNodes=1;
	}

	// Method to be implemented by you. See handout part 1A								
	public boolean insert(String s){
		if (s == null) {
			return false;
		}
		TreeNode current = root;
		while (current != null) {
			for (int i = 0; i<=s.length(); i++) { //for each character in the string
		
				if (s.length() == i) {		//if it is the last character
					if (current.getIsUsed() == true) {		//if this node is flagged already return false
						return false;
					} else {			//if not flag it as true
						current.setIsUsed(true);
						return true;
					}
					
				}else if (s.charAt(i) == '0') {  //checks if we move left
					if (current.getLeftChild() == null) {  //creates a new node to set as the left child if necessary
						left = new TreeNode(current, null, null, false);
						current.setLeftChild(left);
						current = current.getLeftChild();
						numNodes++;
					}else current = current.getLeftChild();
					
				} else if (s.charAt(i) == '1') {  //checks if we move right
					if (current.getRightChild() == null) {    //creates a new node to set as the right child if necessary
						right = new TreeNode(current, null, null, false);
						current.setRightChild(right);
						current = current.getRightChild();
						numNodes++;
					}else current = current.getRightChild();
						
				}
			}
		}
		return false;
		
	}
	
	public boolean search(String s) {													
		
		TreeNode current = root;
		System.out.println("\nSearch for string: " + s);
		
		
		for (int i = 0; i<s.length(); i++) {  
				if (s.charAt(i) == '0') {
					if (current.getLeftChild() != null) {
						current = current.getLeftChild();  //move left if 0 bit
					} else if (current.getLeftChild() == null){
						System.out.println("String not found :(");
						return false;
					}
					
				} else if (s.charAt(i) == '1') {
					if (current.getRightChild() != null) {
						current = current.getRightChild();  //move right if 1 bit
					} else if (current.getRightChild() == null) {
						System.out.println("String not found :(");
						return false;
					}
				}
			}
		return current.getIsUsed();
	    
	}

	public void printStringsInLexicoOrder() {
		String currNode = "";
		lexOrder(root, currNode);
	}
	private void lexOrder(TreeNode N, String currNode) {
		if (N == null) {
			return;
		}
		if (N.getIsUsed() == true) {
			System.out.print(currNode + ",");
		}
		currNode += '0';
		lexOrder(N.getLeftChild(), currNode);
		currNode = currNode.substring(0, currNode.length() - 1);
		currNode += "1";
		lexOrder(N.getRightChild(), currNode);
		currNode = currNode.substring(0, currNode.length() - 1);
	}
	
	
	public void printInOrder() { // not to be changed
		printInOrder(root);
	}
	private void printInOrder(TreeNode N) { // not to be changed
		System.out.print("(");
		if (N!=null) {
			printInOrder(N.getLeftChild());
			System.out.print(N.getIsUsed());
			printInOrder(N.getRightChild());
		}
		System.out.print(")");
	}
	

	
	public TreeNode root() { // not to be changed
		return root;
	}
	
	public int numNodes() { // not to be changed
		return numNodes;
	}


}