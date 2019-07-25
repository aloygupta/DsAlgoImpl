package tree.implementation;

import queue.Queue;
import queue.implementation.LinkedQueue;
import stack.Stack;
import stack.implementation.LinkedStack;
import tree.Tree;

public class BSTIterative<T extends Comparable<T>> extends AbstractBST<T> implements Tree<T> {

	public BSTIterative() {
		this.root = null;
		this.nodeCount = 0;
	}

	@Override
	public void insert(T value) throws Exception {

		Node<T> valueToInsert = new Node<T>(value);

		Node<T> temp = root;

		if (root == null) {
			root = valueToInsert;
			++nodeCount;
			return;
		}

		while (temp != null) {
			if (temp.compareTo(valueToInsert) > 0) {

				if (temp.left == null) {
					temp.left = valueToInsert;
					++nodeCount;
					return;
				} else
					temp = temp.left;

			} else if (temp.compareTo(valueToInsert) < 0) {

				if (temp.right == null) {
					temp.right = valueToInsert;
					++nodeCount;
					return;
				} else
					temp = temp.right;
			} else {
				// duplicate value in tree, throw exception
				throw new Exception("Value " + value + " already present in BST!");
			}
		}
	}

	@Override
	public void deleteValue(T value) throws Exception {

		if (root == null)
			throw new Exception("Empty BST!");

		Node<T> valueToDelete = new Node<T>(value);
		Node<T> current = root;
		Node<T> parent = null;
		boolean foundValue = false;

		while (current != null) {

			if (current.compareTo(valueToDelete) > 0) {
				parent = current;
				current = current.left;
			} else if (current.compareTo(valueToDelete) < 0) {
				parent = current;
				current = current.right;
			} else {
				foundValue = true;
				--nodeCount;
				// found match, current = valueToDelete, now delete it.
				break;
			}
		}

		// if current is null, it means value was not found in tree.
		if (!foundValue)
			throw new Exception("Value " + value + " is not found in BST!");

		// case 1: no children
		if (current.left == null && current.right == null) {

			// root with no child
			if (current.equals(root)) {
				root = null;
				return;
			}

			if (parent.left.equals(current)) {
				// the left child is to be deleted
				parent.left = null;
			} else {
				// the right child is to be deleted
				parent.right = null;
			}
		}
		// case 2: has 2 children
		else if (current.left != null && current.right != null) {

			Node<T> inorderSuccessor = new Node<T>(getSuccessor((T) current.value));
			// inorderSuccessor will have at most 1 child
			deleteValue(inorderSuccessor.value);
			// copy the least value in its right subtree into the node to be deleted
			current.value = inorderSuccessor.value;

			//adjust the nodeCount;
			++nodeCount;
		}
		// case 3: has 1 child
		else {

			Node<T> childToLinkUp = (current.left != null) ? current.left : current.right;

			// root with 1 child
			if (current.equals(root)) {
				root = childToLinkUp;
				return;
			}

			if (parent.left.equals(current)) {
				parent.left = childToLinkUp;
			} else {
				parent.right = childToLinkUp;
			}
		}
	}

	@Override
	public void printValues(TraversalStyle style) {
		System.out.print("[ ");
		if (style == TraversalStyle.PREORDER)
			printPreOrder();
		else if (style == TraversalStyle.POSTORDER)
			printPostOrder();
		else if (style == TraversalStyle.INORDER)
			printInOrder();
		else
			printLevelOrder();    // if style is LEVELORDER or if its null, it will default to LEVELORDER

		System.out.println("]");

	}

	private void printPreOrder() {

		if (root == null)
			return;

		Stack<Node<T>> stack = new LinkedStack<>();
		try {
			stack.push(root);
			while (!stack.empty()) {
				Node<T> topNode = stack.pop();
				System.out.print(topNode + " ");

				if (topNode.right != null)
					stack.push(topNode.right);

				if (topNode.left != null)
					stack.push(topNode.left);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void printInOrder() {

		if (root == null)
			return;

		Node<T> current = root;
		Stack<Node<T>> stack = new LinkedStack<>();
		try {
			while (current != null || !stack.empty()) {

				while (current != null) {
					stack.push(current);
					current = current.left;
				}
				current = stack.pop();
				System.out.print(current + " ");

				current = current.right;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void printPostOrder() {
		// TODO: Aloy: Implement iterative version
	}

	private void printLevelOrder() {

		if (root == null)
			return;

		Queue<Node<T>> queue = new LinkedQueue<Node<T>>();
		try {
			queue.enqueue(root);

			while (!queue.empty()) {
				Node<T> frontNode = queue.dequeue();

				// if the node has left and/or right child, add them in queue
				if (frontNode.left != null)
					queue.enqueue(frontNode.left);
				if (frontNode.right != null)
					queue.enqueue(frontNode.right);

				// print out the node, it has already been dequeued.
				System.out.print(frontNode + " ");
			}
		} catch (Exception e) {
			System.out.println("Exception occured while traversing: " + e);
		}
	}

	@Override
	public boolean isInTree(T value) throws Exception {

		if (root == null)
			throw new Exception("Empty BST!");

		Node<T> valueToSearch = new Node<T>(value);
		Node<T> current = root;

		while (current != null) {

			if (current.compareTo(valueToSearch) > 0)
				current = current.left;        // search in left subtree
			else if (current.compareTo(valueToSearch) < 0)
				current = current.right;    // search in right subtree
			else
				return true;    // match found
		}
		// if current became false, we have traversed the possible path and yet not found the value
		return false;
	}

	@Override
	public int getHeight() {

		if (root == null)
			return 0;

		int height = -1;
		Queue<Node<T>> queue = new LinkedQueue<>();
		try {
			queue.enqueue(root);

			while (true) {

				if (queue.empty())
					return height;
				else
					++height;

				int nodesAtCurrentLevel = queue.size();
				while (nodesAtCurrentLevel > 0) {

					Node<T> dequeuedNode = queue.dequeue();

					if (dequeuedNode.left != null)
						queue.enqueue(dequeuedNode.left);

					if (dequeuedNode.right != null)
						queue.enqueue(dequeuedNode.right);

					--nodesAtCurrentLevel;
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
		}

		return height;
	}

	@Override
	public T getMin() throws Exception {

		if (root == null)
			throw new Exception("Empty BST!");

		Node<T> current = root;

		while (current.left != null) {
			current = current.left;
		}
		return current.value;
	}

	@Override
	public T getMax() throws Exception {

		if (root == null)
			throw new Exception("Empty BST!");

		Node<T> current = root;

		while (current.right != null) {
			current = current.right;
		}
		return current.value;
	}

	@Override
	public boolean isBinarySearchTree(T minValue, T maxValue) {
		// TODO: Aloy: Implement iterative version
		return false;
	}

	@Override
	public T getSuccessor(T value) throws Exception {

		if (root == null)
			throw new Exception("Empty BST!");

		Node<T> valueToSearch = new Node<T>(value);
		Node<T> current = root;
		Node<T> successor = null;

		boolean valueFound = false;

		while (current != null) {

			if (current.compareTo(valueToSearch) > 0) {
				successor = current;
				current = current.left;        // search in left subtree
			} else if (current.compareTo(valueToSearch) < 0) {
				current = current.right;    // search in right subtree
			} else {
				valueFound = true;
				break;
			}
		}

		if (!valueFound) {
			return null;
		} else {

			if (current.right != null){
				// find min in right subtree
				Node<T> temp = current.right;

				while (temp.left != null) {
					temp = temp.left;
				}
				return temp.value;
			}
			else
				return (successor == null) ? null : successor.value;

		}
	}
}
