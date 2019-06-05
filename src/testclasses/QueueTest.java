package testclasses;

import queue.Queue;
import queue.implementation.ArrayQueue;
import queue.implementation.LinkedQueue;

public class QueueTest {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedQueue<>();
		try {
			//queue.dequeue();
			queue.enqueue(32);
			queue.enqueue(43);
			queue.enqueue(90);
			System.out.println(queue);
			System.out.println("size: "+queue.size());
			System.out.println("Dequeued: "+queue.dequeue());
			System.out.println(queue);
			System.out.println("size: "+queue.size());
			queue.dequeue();
			queue.dequeue();
			System.out.println(queue);
			System.out.println("size: "+queue.size());
			System.out.println(queue.dequeue());
			
		} catch (Exception e) {	
			System.out.println(e);
		}
	}

}
