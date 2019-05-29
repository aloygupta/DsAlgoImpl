package array.vector;

/**
 * 
 * @author agupta15
 * Vector class - Mutable array with automatic resizing (made it of generic objects not just ints)
 */
public class VectorImplementation<T> implements array.Vector<T> {
	
	private T[] arr;
	private int size;
	private static final int DEFAULT_CAPACITY = 16;

	/*can allocate int array under the hood, just not use its features
	start with 16, or if starting number is greater, use power of 2 - 16, 32, 64, 128*/	
	
	public VectorImplementation() {
		this(DEFAULT_CAPACITY);
	}
	
	public VectorImplementation(int capacity) {
		
		/*if(capacity<16)
			capacity = 16;
		else if(capacity )
		*/
		
		
		this.arr = (T[]) new Object[capacity];
		this.size = 0;
	}
	
	
	/*when you reach capacity, resize to double the size
	when popping an item, if size is 1/4 of capacity, resize to half*/
	private void resize(int newCapacity) {
		
		T[] newArr = (T[])new Object[newCapacity];

		for(int i=0;i<size;i++) {
			newArr[i] = arr[i];
		}
		
		this.arr = newArr;
	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public int capacity() {
		
		return arr.length;
	}

	@Override
	public boolean isEmpty() {
		
		 return (size == 0);
		
	}
	
	@Override
	public T at(int index) {

		if(index <0 || index >= size)
			throw new IndexOutOfBoundsException("Trying to retreive element outisde of array size");
		else
			return (T) arr[index];
	}

	@Override
	public void push(T item) {

		if(size == arr.length) {
			resize(arr.length * 2);
		}
		
		arr[size] = item;
		++size;
		
	}

	@Override
	public T pop() throws Exception {
		
		if(size == 0)
			throw new Exception("Vector is empty, nothing to pop");
		
		T valueToReturn = (T) arr[--size];
		
		if(size <= (arr.length/4)) {
			resize(arr.length/2);
		}
		
		return valueToReturn;
		
	}
	
	@Override
	public void insert(int index, T item) {
		
		if(index < 0 || index >= arr.length)
			throw new IndexOutOfBoundsException("Trying to insert element outside vector");
		
		int prevSize = size;
		
		if(size == arr.length) {
			resize(arr.length * 2);
		}
		
		int lastIndex = prevSize -1;
		while(lastIndex>=index) {
			arr[lastIndex+1] = arr[lastIndex];
			--lastIndex;
		}
		
		arr[index] = item;
		++size;
	}

	@Override
	public void prepend(T item) {
		
		insert(0, item);
		
	}
	
	@Override
	public void delete(int index) {
		
		if(index < 0 || index >= arr.length)
			throw new IndexOutOfBoundsException("Trying to delete element outside vector");
		
		int lastIndex = size-1;
		while(index<lastIndex) {
			arr[index] = arr[index+1];
			++index;
		}
		
		arr[lastIndex] = null;
		
		--size;
		
		if(size <= (arr.length/4)) {
			resize(arr.length/2);
		}
		
	}
	
	@Override
	public void remove(T item) {
		
		for(int index=0; index<size; index++) {
			
			if(arr[index].equals(item)) {
				delete(index);
			}
		}
	}

	@Override
	public int find(T item) {
		
		for(int index = 0; index<size; index++) {
			if(arr[index].equals(item)) {
				return index;
			}
		}
		
		return -1;
	}
	
	@Override
	public String toString() {

		String desc = "[";
		
		if(!isEmpty()) {
			desc = "[ "+arr[0];
		}
		
		for(int i=1;i<size;i++) {
			desc= desc +" , "+arr[i];
		}
		
		desc += " ]";
		
		return desc;

	}
	
}

