package queue.implementation;

import queue.Queue;

/*
 * This ArrayQueue class will not shift elements to save space, only when queue is empty, it will reset.
 * Instead of shifting elements, CircularQueue class will accommodate elements in circular fashion.  
 */

public class ArrayQueue<T> implements Queue<T> {

	private T[] elements;
	private int size;
	private int rear = -1;
	private int front = -1;
	
	private static final int DEFAULT_CAPACITY = 100;
	
	public ArrayQueue() {
		this.elements = (T[]) new Object[DEFAULT_CAPACITY];
		this.size = 0;
	}
	
	@Override
	public void enqueue(T value) throws Exception {
		
		if(rear == elements.length -1)
			throw new Exception("Enqueue failed. Queue is full!");
		
		if(rear == -1) {
			// queue is empty
			rear = front = 0;
			elements[rear] = value;
			++size;
		}
		else {
			elements[++rear] = value;
			++size;
		}
	}

	@Override
	public T dequeue() throws Exception {
		
		if(front == -1)
			throw new Exception("Dequeue failed. Queue is empty!");
		
		T element = elements[front];
		++front;
		--size;
		
		if(front > rear) { //queue is now empty, so reset pointers to start
			front = rear = -1;
			size = 0;
		}
		
		return element;
	}

	@Override
	public boolean empty() {
		return (size == 0);
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {

		String desc = "[";
		
		if(size != 0) {
			desc = "[ "+elements[front];
		}
		
		for(int i=(front+1);i<=rear;i++) {
			desc= desc +" , "+elements[i];
		}
		
		desc += " ]";
		
		return desc;

	}

}
