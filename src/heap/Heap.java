package heap;


import array.Vector;

public interface Heap<T> {

    void insert(T value);

    // return the max item, without removing it.
    T getMax() throws Exception;

    //returns the number of elements stored
    int getSize();

    //returns true if heap contains no elements
    boolean isEmpty();

    // returns the max item, after removing it
    T extractMax() throws Exception;

    //removes item at index
    T remove(int index, T maxValue) throws Exception;

    // create heap from array, required for heapsort
    void heapify();
}
