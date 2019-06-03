package stack;

public interface Stack<T> {
	
	//Tests if this stack is empty.
	public boolean empty();
	
	//Looks at the object at the top of this stack without removing it from the stack.
	public T peek() throws Exception;

	//Removes the object at the top of this stack and returns that object as the value of this function.
	public T pop() throws Exception;
	
	//Pushes an item onto the top of this stack.
	public void push(T item);
	
	// current size of the stack
	public int getSize();
	
}
