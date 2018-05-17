/*** 
 * This is class implements a compressed trie that holds a set of strings.
 * MyCompressedTrie stores nodes using class TreeNodeWithData
 * 
 * Name: Michael Sault
 * Student Number: 8459820
 * Uottawa Email: msaul025@uottawa.ca
 * 
 *
 */
public class MyCompressedTrie {
	
	private TreeNodeWithData root;

	
	private int numNodes;
	
	public MyCompressedTrie() { // simple constructor (empty trie consisting of root only)
		root = new TreeNodeWithData(null, null, null,false,null);
		numNodes=1;
	}
	
	// to be implemented by you see handout Part 2A
	// Constructor that receives a regular trie and creates this
	// instance (which is a compressed trie)
	public MyCompressedTrie(MyTrie trie) { 
		this(); // call to the simple constructor above (empty trie consisting of root only)
		
		//Used for preparing Trie to compress
		if (trie.root() == null) {
			root = null;
			numNodes = 1;
		} else {
			root = new TreeNodeWithData(null, null, null, false, "root");
		}
		
		compressTrie("",trie.root(),root); //calls the method to compress the trie, sends an empty string, and a root node for our regular and compressed tries
	
	}
	
	//Main method for compressing the Trie
	private void compressTrie(String s,TreeNode trieNode,TreeNodeWithData node){
		TreeNode tempNode = trieNode;
		TreeNodeWithData tempNodeData = node;
		
		//if empty, return and move up a layer
		if ((tempNode.getLeftChild()==null)&&(tempNode.getRightChild()==null)){
			return;
		}
		
		//Left child handling
		if (tempNode.getLeftChild()!=null){  //if the node has a left child
            if (!tempNode.getLeftChild().getIsUsed()){  //and the child is not used
					if ((tempNode.getLeftChild().getLeftChild()!=null)&&(tempNode.getLeftChild().getRightChild()!=null)) {  //if the child is not the node at the end of the branch
						tempNodeData.setLeftChild(new TreeNodeWithData(tempNodeData,null,null,false,null));	 //create a new NodeWithData as the left child of the current (empty)NodeWithData
						numNodes++;  
						compressTrie(s+"0",tempNode.getLeftChild(),(TreeNodeWithData)tempNodeData.getLeftChild());  //calls this function, adding 0 to the string, moving the node to the left, and moving to the new DataNode
					} else { //if the child is at the end of the node
						compressTrie(s+"0",tempNode.getLeftChild(),(TreeNodeWithData)tempNodeData);  //calls this function, adds 0 and moves to the left, but keeps the same DataNode
					}
			} else { //if child is used
				tempNodeData.setLeftChild(new TreeNodeWithData(tempNodeData,null,null,true,s+"0"));  //create and place a NodeWithData as the left child of the temp
				numNodes++;
				compressTrie(s+"0",tempNode.getLeftChild(),(TreeNodeWithData)tempNodeData.getLeftChild()); //recursive call, adds 0 to string, moves both nodes left
			}
		}
		
		//Right child handling (mirrors left child)
		if (tempNode.getRightChild()!=null){  //if the node has a right child
            if (!tempNode.getRightChild().getIsUsed()){  //and the child is not used
				if ((tempNode.getRightChild().getLeftChild()!=null)&&(tempNode.getRightChild().getRightChild()!=null)) {  //if the child is not the node at the end of the branch
					tempNodeData.setRightChild(new TreeNodeWithData(tempNodeData,null,null,false,null));  //place the new NodeWithData as the right child of the current NodeWithData
					numNodes++;	  
					compressTrie(s+"1",tempNode.getRightChild(),(TreeNodeWithData)tempNodeData.getRightChild()); //adds 1 to string, moves both nodes right
				} else {
						compressTrie(s+"1",tempNode.getRightChild(),(TreeNodeWithData)tempNodeData); //adds 1 to string, moves only node right
				}
			} else {
				tempNodeData.setRightChild(new TreeNodeWithData(tempNodeData,null,null,true,s+"1")); //create and place a NodeWithData as the right child of the temp
				numNodes++;
				compressTrie(s+"1",tempNode.getRightChild(),(TreeNodeWithData)tempNodeData.getRightChild()); //recursive call, adds 1 to string, moves both nodes right
			}
		}
	}
	
	
	// Method to be implemented by you. See handout part 2A	
	// Now with recursion ;)
	// Altered, doesn't use original way 
	public void printStringsInLexicoOrder() {
		InLexicoOrder(root);   
	}

	private void InLexicoOrder(TreeNodeWithData N){
		
		//If leaf, done here
		if ((N==null)){
			return;
		}
		
		//Left Child handling
        if (N.getLeftChild()!=null){
			if (N.getLeftChild().getIsUsed()){
				TreeNode tempNode = N.getLeftChild();
				System.out.println(((TreeNodeWithData)tempNode).getData());
			}
			InLexicoOrder((TreeNodeWithData)N.getLeftChild());
		}
        
        //Right Child handling
		if (N.getRightChild()!=null){
			if (N.getRightChild().getIsUsed()){
				TreeNode tempNode = N.getRightChild();
				System.out.println(((TreeNodeWithData)tempNode).getData());
			}
			InLexicoOrder((TreeNodeWithData)N.getRightChild());
		}

	}
	
	
	// the following method that calls its recursive counterpart
	// prints the tree and its data values at nodes in 
	// in-order traversal order
	
	public void printInOrder() { // not to be changed
		printInOrder(root);
	}
	
	private void printInOrder(TreeNode N) { // not to be changed
		System.out.print("(");
		if (N!=null) {
			printInOrder(N.getLeftChild());
			System.out.print(((TreeNodeWithData)N).getData());
			printInOrder(N.getRightChild());

		}
		System.out.print(")");
	}
	

	
	public int numNodes() {
		return numNodes;	
	}
	

}
