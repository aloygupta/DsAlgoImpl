package array;

public interface Vector<T> {

	//number of items
	int size();
	
	//number of items it can hold
	int capacity();
	
	boolean isEmpty();
	
	//returns item at given index, blows up if index out of bounds
	T at(int index);
	
	void push(T item);
	
	//inserts item at index, shifts that index's value and trailing elements to the right
	void insert(int index, T item);
	
	//can use insert above at index 0
	void prepend(T item);
	
	//remove from end, return value
	T pop() throws Exception;
	
	//delete item at index, shifting all trailing elements left
	void delete(int index);
	
	//looks for value and removes index holding it (even if in multiple places)
	void remove(T item);
	
	//looks for value and returns first index with that value, -1 if not found
	int find(T item);
	
	// update the value at current index with given value
	void update(int index, T value);
}
