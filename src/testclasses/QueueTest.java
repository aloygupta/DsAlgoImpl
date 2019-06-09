package testclasses;

import queue.Queue;
import queue.implementation.ArrayQueue;
import queue.implementation.CircularQueue;
import queue.implementation.LinkedQueue;

public class QueueTest {

	public static void main(String[] args) {
		Queue<Integer> queue = new CircularQueue<>();
		try {

		/*	for(int i = 1;i<=6;i++) {
				queue.enqueue(i);
				System.out.println(queue);
			}
			//System.out.println(queue);
			System.out.println("Dequeued: "+queue.dequeue());
			System.out.println(queue);
			System.out.println("enqueued 7:");queue.enqueue(7);
			System.out.println(queue);
			System.out.println("enqueued 8");
			queue.enqueue(8);
			System.out.println(queue);*/

			//queue.dequeue();
			queue.enqueue(32);
			System.out.println(queue);
			queue.enqueue(43);
			System.out.println(queue);
			queue.enqueue(90);
			System.out.println(queue);
			System.out.println("size: "+queue.size());
			System.out.println("Dequeued: "+queue.dequeue());
			System.out.println(queue);
			System.out.println("size: "+queue.size());
			System.out.println("Dequeued: "+queue.dequeue());
			System.out.println("Enqueued 77: ");queue.enqueue(77);
			System.out.println("Enqueued 10: ");queue.enqueue(10);
			System.out.println(queue);
			System.out.println("size: "+queue.size());
			System.out.println("Dequeued: "+queue.dequeue());
			System.out.println(queue);
			System.out.println("size: "+queue.size());
			System.out.println("Enqueued 14: ");queue.enqueue(14);
			System.out.println("Enqueued 33: ");queue.enqueue(33);
			System.out.println(queue);
			System.out.println("Enqueued 21: ");queue.enqueue(22);
			System.out.println("Enqueued 18: ");queue.enqueue(18);
			System.out.println(queue);
			System.out.println("Dequeued: "+queue.dequeue());
			System.out.println("Enqueued 44: ");queue.enqueue(44);
			System.out.println(queue);
			//System.out.println("Enqueue 78");queue.enqueue(78);
		} catch (Exception e) {	
			System.out.println(e);
		}
	}

}
