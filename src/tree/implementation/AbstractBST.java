package tree.implementation;

import tree.Tree;

abstract class AbstractBST<T extends Comparable<T>> implements Tree<T> {

	protected Node<T> root;
	protected int nodeCount;

	@Override
	public void deleteTree() {
		this.root = null;
	}

	@Override
	public int getNodeCount() {
		return nodeCount;
	}

	protected class Node<T extends Comparable<T>> implements Comparable<Node<T>>{
		
		T value;
		Node left;
		Node right;
		
		private Node() {
			// making this private, so that an empty node without parameters can't be initialized.
		}
		
		public Node(T value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			
			/*String toString = "("+value+",L=";
			
			toString += (left == null)?left:left.value;
			toString += ",R=";
			toString += (right == null)?right:right.value;
			toString += ")";*/

			String toString = ""+value;
			
			return toString;
		}

		@Override
		public int compareTo(Node<T> other) {
			return this.value.compareTo(other.value);
		}

	}
		
}
