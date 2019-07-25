package tree.implementation;

import queue.Queue;
import queue.implementation.LinkedQueue;
import tree.Tree;

public class BSTRecursive<T extends Comparable<T>> extends tree.implementation.AbstractBST<T> implements Tree<T> {

	public BSTRecursive() {
		// init an empty BST with root null
		this.root = null;
		this.nodeCount = 0;
	}

	@Override
	public void insert(T value) throws Exception {
		
		this.root = insertRecursive(value,root);
		++nodeCount;
	}

	private Node<T> insertRecursive(T value, Node<T> root) throws Exception {
		
		Node<T> valueToInsert = new Node<T>(value);
		
		if(root == null) {
			root = valueToInsert; //base case: insertion happening here
			return root;
		}
		
		if(root.compareTo(valueToInsert) > 0) {	// root is bigger, hence go left
			root.left = insertRecursive(value, root.left);
		}
		else if(root.compareTo(valueToInsert) < 0) { // root is smaller, hence go right
			root.right = insertRecursive(value, root.right);
		}
		else {
			// duplicate value in tree, throw exception
			throw new Exception("Value "+value+" already present in BST!");
		}
		
		return root;
	}

	@Override
	public void deleteValue(T value) throws Exception {
		this.root = deleteRecursive(value,root);
		--nodeCount;
	}

	private Node<T> deleteRecursive(T value, Node<T> root) throws Exception {

		if(root == null)
			//return root;	// if tree is empty
			throw new Exception("Value "+value+" is not found in BST!");

		Node<T> valueToDelete = new Node<T>(value);

		if(root.compareTo(valueToDelete) > 0) {	// root is bigger, hence go left
			root.left = deleteRecursive(value, root.left);
		}
		else if(root.compareTo(valueToDelete) < 0) { // root is smaller, hence go right
			root.right = deleteRecursive(value, root.right);
		}
		else {
			// finally, found the value to delete

			// if there is one child, return that.
			// This will also work, if there are no children, hence root.left / root.right will be null
			if(root.right == null)
				return root.left;
			else if(root.left == null)
				return  root.right;
			else{
				// it has two children.
				// get the lowest value in right subtree.
				// In other implementations, we can also use highest value in left subtree
				Node lowestValueInRight = root.right;
				while(lowestValueInRight.left != null){
					lowestValueInRight = lowestValueInRight.left;
				}
				// copy the value in the node to be originally deleted.
				root.value = (T)lowestValueInRight.value;
				// delete the new value to be deleted
				root.right = deleteRecursive((T)lowestValueInRight.value,root.right);

				return  root;
			}
		}
		return root;
	}

	@Override
	public void printValues(TraversalStyle style) {
		System.out.print("[ ");
		if(style == TraversalStyle.PREORDER)
			printPreOrder(root);
		else if(style == TraversalStyle.POSTORDER)
			printPostOrder(root);
		else if(style == TraversalStyle.INORDER)
			printInOrder(root);
		else
			printLevelOrder(root);	// if style is LEVELORDER or if its null, it will default to LEVELORDER

		System.out.println("]");
	}

	private void printPreOrder(Node<T> root){

		if(root == null)
			return;

		System.out.print(root+" ");
		printPreOrder(root.left);
		printPreOrder(root.right);
	}

	private void printInOrder(Node<T> root){

		if(root == null)
			return;

		printInOrder(root.left);
		System.out.print(root+" ");
		printInOrder(root.right);
	}

	private void printPostOrder(Node<T> root){

		if(root == null)
			return;

		printPostOrder(root.left);
		printPostOrder(root.right);
		System.out.print(root+" ");
	}

	private void printLevelOrder(Node<T> root){

        try {
            int heightOfTree = getHeight();
            for(int level=0; level<=heightOfTree; level++) {
                printLevelOrderRecursive(root,level);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void printLevelOrderRecursive(Node<T> root,int level){

        if (root == null)
            return;

        if (level == 0)
            System.out.print(root + " ");
        else {
            printLevelOrderRecursive(root.left, level - 1);
            printLevelOrderRecursive(root.right, level - 1);
        }
    }

	@Override
	public boolean isInTree(T value) throws Exception {

		if(root == null)
			throw new Exception("Empty BST!");

		return isInTreeRecursive(value,root);
	}

	private boolean isInTreeRecursive(T value,Node<T> root) {

		if(root == null){
			// traversed the possible path, but didnt find the value
			return false;
		}

		Node<T> valueToSearch = new Node<T>(value);
		if(root.compareTo(valueToSearch)> 0)
			return isInTreeRecursive(value,root.left);
		else if(root.compareTo(valueToSearch) < 0)
			return isInTreeRecursive(value,root.right);
		else{
			// match found
			return true;
		}
	}

	@Override
	public int getHeight() throws Exception {

		if(root == null)
			throw new Exception("Empty BST!");

		return getHeightRecursive(root);
	}

	private int getHeightRecursive(Node<T> root){

		if(root == null)
			// if we have gone beyond the leaf nodes,
			// then return -1 as height, leaf nodes will gain height as 0 in below step, when it returns from recursive call
			// NOTE: height of leaf node = 0 . Correct definition of height = no. of EDGES from node to leaf
			return -1;

		return 1+ Math.max(getHeightRecursive(root.left),getHeightRecursive(root.right));
	}

	@Override
	public T getMin() throws Exception {

		if(root == null)
			throw new Exception("Empty BST!");

		Node<T> min = getMinRecursive(root);
		return min.value;
	}

	private Node<T> getMinRecursive(Node<T> root) {

		if(root.left == null)
			return root;

		return getMinRecursive(root.left);
	}

	@Override
	public T getMax() throws Exception {

		if(root == null)
			throw new Exception("Empty BST!");

		Node<T> max = getMaxRecursive(root);
		return max.value;
	}

	private Node<T> getMaxRecursive(Node<T> root) {

		if(root.right == null)
			return root;

		return getMaxRecursive(root.right);
	}

	@Override
	public boolean isBinarySearchTree(T minValue, T maxValue) {

		Node<T> min = new Node<T>(minValue);
		Node<T> max = new Node<T>(maxValue);

		return isBinarySearchTreeRecursive(root,min,max);
	}

	private boolean isBinarySearchTreeRecursive(Node<T> root, Node<T> min, Node<T> max){

		if(root == null)
			return true;

		if(root.compareTo(min) > 0 && root.compareTo(max) < 0		// the current node should fulfill the criteria of being BST
			&& isBinarySearchTreeRecursive(root.left,min,root)		// left subtree must be BST
			&& isBinarySearchTreeRecursive(root.right,root,max))	// right subtree must be BST
			return true;
		else
			return false;
	}

	@Override
	public T getSuccessor(T value) throws Exception {

		if(root == null)
			throw new Exception("Empty BST!");

		Node<T> inorderSucessor = getSuccessorRecursive(value,root,null);

		return (inorderSucessor == null)?null:inorderSucessor.value;
	}

	private Node<T> getSuccessorRecursive(T value, Node<T> root,Node<T> successor) throws Exception {

		if(root == null)
			return null;

		Node<T> searchNode = new Node<T>(value);

		if(searchNode.compareTo(root) < 0){
			// go one step to the left, mark the 'current' root as the inorder successor, in case root.left matches value
			return getSuccessorRecursive(value,root.left,root);
		}
		else if(searchNode.compareTo(root) > 0){
			// the current successor continues to be successor,
			// this can be null, if we keep going in right subtree of original root
			// or if its a right subtree in left of original root, it would mean inorder successor of it immediate parent
			return getSuccessorRecursive(value,root.right,successor);
		}
		else{
			// now we have a match.

			if(root.right != null)	//the inorder successor will be the smallest value in its right subtree
				return getMinRecursive(root.right);

		}

		return successor;
	}

}
