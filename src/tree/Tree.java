package tree;

public interface Tree<T> {
	
	// insert value into tree
	void insert(T value) throws Exception;
	
	// deletes a particular value from tree
	void deleteValue(T value) throws Exception;
	
	// visit and print the values in the tree, depending on traversal style
	void printValues(TraversalStyle style);
		
	 // get count of values stored
	int getNodeCount();
	
	// delete the tree
	void deleteTree();
	
	// returns true if given value exists in the tree
	boolean isInTree(T value) throws Exception;
	
	// returns the height in nodes (single node's height is 1)
	int getHeight() throws Exception;
	
	//int depth();
	
	 // returns the minimum value stored in the tree
	T getMin() throws Exception;
	
	// returns the maximum value stored in the tree
	T getMax() throws Exception;
	
	// returns true if this tree is a BST
	boolean isBinarySearchTree(T minValue, T maxValue);
	
	// returns next-highest value in tree after given value, null if none
	T getSuccessor(T value) throws Exception;
	
	
	public enum TraversalStyle{
		PREORDER,
		INORDER,
		POSTORDER,
		LEVELORDER
	}

}
