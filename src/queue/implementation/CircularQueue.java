package queue.implementation;

import queue.Queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] elements;
	private int size;
	private int rear = -1;
	private int front = -1;
	
	private static final int DEFAULT_CAPACITY = 6;
	
	public CircularQueue() {
		this.elements = (T[]) new Object[DEFAULT_CAPACITY];
		this.size = 0;
	}
	
	@Override
	public void enqueue(T value) throws Exception {
		
		if(isFull())
			throw new Exception("Enqueue failed. Queue is full!");
		
		if(empty()) {
			front =0; rear = -1;
		}
			
		rear = (rear+1) % DEFAULT_CAPACITY;
		elements[rear] = value;
		++size;
	}

	@Override
	public T dequeue() throws Exception {
		
		if(empty())
			throw new Exception("Dequeue failed. Queue is empty!");
		
		T element = elements[front];
		
		front = (front+1) % DEFAULT_CAPACITY;
		--size;
		
		return element;
		
	}

	private boolean isFull() {
		
		if((rear+1) % DEFAULT_CAPACITY == front)
			return true;
		else
			return false;
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
		
		for(int i=0;i<DEFAULT_CAPACITY;i++) {
			desc= desc +" , "+elements[i];
		}
		
		desc += " ]";
		
		desc += "front: "+front+" rear:"+rear; 
		
		System.out.println("Array: "+desc);

		desc = "[";
		
		int tempSize = size;
		int tempIndex = front;// % DEFAULT_CAPACITY;
		
		while(tempSize>0) {
			desc += ", "+elements[tempIndex];
			tempIndex = (tempIndex+1) % DEFAULT_CAPACITY;
			--tempSize;
		}
		
		desc += " ]";
		
		desc += "front: "+front+" rear:"+rear; 
		
		return desc;

	}

}
