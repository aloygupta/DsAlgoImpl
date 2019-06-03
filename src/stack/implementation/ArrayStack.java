package stack.implementation;

import array.Vector;
import array.vector.VectorImplementation;
import stack.Stack;

public class ArrayStack<T> implements Stack<T>{

	private Vector<T> elements;
	private int size;
	
	//private static final int MAX_SIZE = Integer.MAX_VALUE;
	private static final int DEFAULT_SIZE = 100;
	
	public ArrayStack() {
		
		this.size = 0;
		this.elements = new VectorImplementation<>(DEFAULT_SIZE);
	}

	@Override
	public boolean empty() {
		return elements.isEmpty();
	}

	@Override
	public T peek() {
		T element = elements.at(elements.size()-1);
		return element;
	}

	@Override
	public T pop() throws Exception {
		T element = elements.pop();
		size = elements.size();
		return element;
	}

	@Override
	public void push(T item) {
		elements.push(item);
		size = elements.size();
	}
	
	@Override
	public int getSize() {
		return size;
	}
	
	@Override
	public String toString() {

		String desc = "[";
		
		if(!elements.isEmpty()) {
			desc = "[ "+elements.at(0);
		}
		
		for(int i=1;i<size;i++) {
			desc= desc +" <- "+elements.at(i);
		}
		
		desc += " ]";
		
		return desc;

	}
}
