package stack.implementation;

import list.List;
import list.implementation.LinkedListWithTail;
import stack.Stack;

public class LinkedStack<T> implements Stack<T> {

	private int size;
	private List<T> elements;
	
	public LinkedStack() {
	
		this.size = 0;
		this.elements = new LinkedListWithTail<>();
	}
	
	@Override
	public boolean empty() {
		return elements.empty();
	}

	@Override
	public T peek() throws Exception {
		return elements.back();
	}

	@Override
	public T pop() throws Exception {
		T element = elements.popBack();
		size = elements.size();
		return element;
	}

	@Override
	public void push(T item) {
		elements.pushBack(item);
		size = elements.size();
	}

	@Override
	public int getSize() {
		return size;
	}
	
	@Override
	public String toString() {

		String desc = "[";
		
		if(!elements.empty()) {
			desc = "[ "+elements.valueAt(0);
		}
		
		for(int i=1;i<size;i++) {
			desc= desc +" <- "+elements.valueAt(i);
		}
		
		desc += " ]";
		
		return desc;

	}

}
