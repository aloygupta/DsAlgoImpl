package list;

public interface List<T> {

	//returns number of data elements in list
	int size(); 
	
	// - bool returns true if empty
	boolean empty();
	
	//- returns the value of the nth item (starting at 0 for first)
	T valueAt(int index);
	
	//- adds an item to the front of the list
	void pushFront(T value);
	
	//remove front item and return its value
	T popFront() throws Exception;
	
	//- adds an item at the end
	void pushBack(T value);
	
	// - removes end item and returns its value
	T popBack() throws Exception;
	
	// - get value of front item
	T front() throws Exception;
	
	// - get value of end item
	T back() throws Exception;
	
	// - insert value at index, so current item at that index is pointed to by new item at index
	void insert(int index, T value);
	
	// - removes node at given index 
	void erase(int index) throws Exception;
	
	// - returns the value of the node at nth position from the end of the list
	T valueNFromEnd(int n);
	
	//- reverses the list
	void reverse() throws Exception;
	
	// - removes the first item in the list with this value
	void removeValue(T value) throws Exception;
}
