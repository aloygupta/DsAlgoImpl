package queue;

public interface Queue<T> {

	// adds value at position at tail
	public void enqueue(T value) throws Exception;
	
	// returns value and removes least recently added element (front)
	public T dequeue() throws Exception;
	
	// returns true if queue is empty
	public boolean empty();
	
	// returns the current size of the queue;
	public int size();

}
