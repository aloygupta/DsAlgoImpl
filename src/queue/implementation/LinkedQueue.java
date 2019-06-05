package queue.implementation;

import list.List;
import list.implementation.LinkedListWithTail;
import queue.Queue;

public class LinkedQueue<T> implements Queue<T> {

	private List<T> elements;
	private int size;
	
	public LinkedQueue() {
		this.elements = new LinkedListWithTail<>();
		this.size = 0;
	}
	
	@Override
	public void enqueue(T value) throws Exception {
		elements.pushBack(value);
		++size;
	}

	@Override
	public T dequeue() throws Exception {
		try{
			T element = elements.popFront();
			--size;
			return element;
		}
		catch(Exception e) {
			throw new Exception("Dequeue failed. Queue is empty!");
		}
		
	}

	@Override
	public boolean empty() {
		return elements.empty();
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		
		String desc = elements.toString();
		
		return desc;
	}
}
