package list.implementation;

import list.List;


public class LinkedListWithTail<T> implements List<T> {

	
	private class Node{
		
		public T value;
		public Node next;
		
		public Node(T value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
	
	private Node head;
	private Node tail;
	private int size;
	
	public LinkedListWithTail() {
		
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean empty() {
		return (size == 0);
	}

	@Override
	public T valueAt(int index) {
		
		if(index <= 0 || index >= size )
			throw new IndexOutOfBoundsException("Can not fetch "+index+"th index value from start");
		
		if(index == (size-1))
			return tail.value;
		
		Node currentNode = head;
		for(int i=0 ;i<index;i++) {
			currentNode = currentNode.next;
		}
		
		return currentNode.value;
		
	}

	@Override
	public void pushFront(T value) {
		
		Node newFrontNode;
		if(head == null) {
			// empty linked list
			newFrontNode = new Node(value, null);
			tail = newFrontNode;
		}
		else {
			// at least one node is there, no need to change tail
			newFrontNode = new Node(value, head);
		}
		
		//point head to newFrontNode;
		head = newFrontNode;
		++size;
		
	}

	@Override
	public T popFront()throws Exception {
		
		if(head == null)
			throw new Exception("Empty Linked List");
		
		
		Node headNode = head;
		//redirect head to next node
		if(head.next == null) {
			// only 1 node, so tail has to be made null
			tail = null;
		}
		// no need to modify tail
		head = head.next;
		//isolate the node, not really required though.
		//headNode should get GC when this function finishes. 
		headNode.next = null;
		--size;
		return headNode.value;
	}

	@Override
	public void pushBack(T value) {
		
		Node newlastNode = new Node(value, null);
		if(head == null) {
			//empty linked list
			head = tail = newlastNode;
			
		}
		else {
			// go to the last node
			/*Node currentNode = head;
			while(currentNode.next != null) {
				
				currentNode = currentNode.next;
			}
			
			currentNode.next = newlastNode;
			*/
			tail.next = newlastNode;
			tail = newlastNode;
		}
		
		++size;		
	}

	@Override
	public T popBack() throws Exception {
		
		if(head == null)
			throw new Exception("Empty Linked List");
		
		
		if(head.next == null)
		{
			//only 1 item in list
			T valueOfHead = head.value;
			//make head and tail null, GC will collect it
			head = tail = null;
			--size;
			return valueOfHead;
		}
		else {
			Node currentNode = head;
			while(currentNode.next.next != null) {
				currentNode = currentNode.next;
			}
			
			//currentNode now points to 2nd last node
			T lastNodeValue = currentNode.next.value;
			tail = currentNode;
			//make 2nd last node point to null, thus allowing GC to collect last node
			currentNode.next = null;
			--size;
			return lastNodeValue;
		}
		
	}

	@Override
	public T front()throws Exception {
		
		if(head == null)
			throw new Exception("Empty Linked List");
		
		return head.value;
	}

	@Override
	public T back() throws Exception {
		
		if(head == null)
			throw new Exception("Empty Linked List");
		else
		{
			/*Node current = head;
			while(current.next != null) {
				current = current.next;
			}
			
			return current.value;*/
			return tail.value;
		}
	}

	@Override
	public void insert(int index, T value) {
		
		
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Can not insert at index: "+index);
		
		if(index == 0) {
			pushFront(value);
		}
		else {
			Node current = head;
			//navigate to just before the index
			for(int i = 1; i<index; i++) {
				current = current.next;
			}
			
			Node insertedNode = new Node(value, current.next);
			current.next = insertedNode;
			++size;
		}
			
	}

	@Override
	public void erase(int index) throws Exception {
		
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Can not erase at index: "+index);
		
		if(index == 0) {
			popFront();
		}
		else {
			Node current = head;
			for(int i = 1; i<index; i++) {
				current = current.next;
			}
			//point pre-target node's next pointer to post-target node
			current.next = current.next.next;
			if(index == (size-1)) {
				// last node has been removed, so modify tail to point to current, whose next is null
				tail = current;
			}
			--size;
		}
	}

	@Override
	public T valueNFromEnd(int n) {
		
		if(n < 0 || n >= size )
			throw new IndexOutOfBoundsException("Can not fetch value at "+n+"th index from end");
		
		if(n == 0)
			return tail.value;
		
		if(n == (size -1))
			return head.value;
		
		int nFromFront = size -1 -n;
		
		Node current = head;
		for(int i= 0; i < nFromFront; i++) {
			current = current.next;
		}
		
		return current.value;
	}

	@Override
	public void reverse() throws Exception {
		
		if(head == null)
			throw new Exception("Empty Linked List");
		
		if(head.next == null) // only 1 node in list
			return;
		
		Node previousNode = null;
		Node currentNode = head;
		Node nextNode = currentNode.next;
		
		while(currentNode != null) {
		
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
			
			// at one point currentNode will reach null, signifying end of list prevent NPE of nextNode
			if(currentNode != null)
			nextNode = currentNode.next;
		}
		//previously what was head node, is now tail
		this.tail = this.head;
		//since currentNode is now null after exit from while loop, previousNode is the head of the reversed list
		this.head = previousNode;
		
	}

	@Override
	public void removeValue(T value) throws Exception {
		
		if(head == null)
			throw new Exception("Empty Linked List");
		
		boolean nodeFound = false;
		
		Node previousNode = null;
		Node currentNode = head;
		
		while(currentNode != null) {
			
			if(currentNode.value.equals(value)) {
				
				if(previousNode == null) {
					//firstNode is matched
					head = head.next;
					
					if(head == null) // only one node was there, that too has been removed
						tail = null;
				}
				else {
					
					if(currentNode.next == null) {
						// check whether currentNode is last node, if yes, have to update tail pointer
						tail = previousNode;
					}
					
					previousNode.next = currentNode.next;
					currentNode.next = null;
					currentNode = null;
				}
				
				nodeFound = true;
				--size;
				
				break;
			}
			
			previousNode = currentNode;
			currentNode = currentNode.next;
		}
		
		if(nodeFound == false)
			throw new Exception("Node with value "+value+" not present");
		
	}
	
	@Override
	public String toString() {
		
		String desc = "[";
		
		if(size != 0) {
			desc = "[ "+head.value;
		}
		
		Node currentNode = head;
		
		for(int i=1;i<size;i++) {
			desc= desc +" , "+currentNode.next.value;
			currentNode = currentNode.next;
		}
		
		desc += " ]";
		
		//desc += " Head: "+head.value+" , Tail: "+tail.value;
		
		return desc;
		
	}

}
