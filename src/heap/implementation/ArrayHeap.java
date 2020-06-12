package heap.implementation;

import array.Vector;
import array.vector.VectorImplementation;

/**
 * We are implementing a max heap here using array.
 *
 * @param <T> a generic paramter
 */

public class ArrayHeap<T extends Comparable<T>> implements heap.Heap<T> {

    private Vector<T> array;
    private int size;

    public ArrayHeap(){
        this.size = 0;
        this.array = new VectorImplementation<>();
    }

    public ArrayHeap(Vector<T> array){
        this.array = array;
        this.size = array.size();
        heapify();
    }

    @Override
    public void insert(T value) {

        this.array.push(value);
        ++size;
        siftUp(size-1);
    }

    private void siftUp(int index){

        // if current node value it greater than parent node value, keep swapping up and moving up
        while(index> 0 && array.at(index).compareTo(array.at(parentOf(index))) > 0){
            swapValues(index,parentOf(index));
            index = parentOf(index);
        }
    }

    @Override
    public T getMax() throws Exception {

        if(size == 0)
            throw new Exception("Max not found. Empty Heap!");

        return array.at(0);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public T extractMax() throws Exception {

        if(size == 0)
            throw new Exception("Can't extract max. Empty Heap!");

        T maxValue = array.at(0);
        // bring the last element of heap to top
        array.update(0,array.at(size-1));
        --size;
        // sift the topmost element down to its deserved position
        siftDown(0);

        return maxValue;
    }

    private void siftDown(int index){

        int indexOfMaxVal = index;

        // if left index is present and left index value greater than current max node (parent) value
        if(leftOf(index)>= 0 && leftOf(index) < size && array.at(leftOf(index)).compareTo(array.at(indexOfMaxVal))>0){
            indexOfMaxVal = leftOf(index);
        }

        // if right index is present and right index value greater than current max node (parent or sibling depending on previous step) value
        if(rightOf(index)>= 0 && rightOf(index) < size && array.at(rightOf(index)).compareTo(array.at(indexOfMaxVal))>0){
            indexOfMaxVal = rightOf(index);
        }

        // After above two steps we got the index of max value among parent and two children.

        if(index != indexOfMaxVal){
            swapValues(index,indexOfMaxVal);
            // after swapping, parent node is ok, but follow up on the swapped value at child (left or right)
            // and make them find their deserved position.
            siftDown(indexOfMaxVal);
        }
    }

    @Override
    public T remove(int index, T maxValue) throws Exception {

        if(index >= size)
            throw new IndexOutOfBoundsException("Index out of Heap: "+index);

        T valueRemoved = array.at(index);
        array.update(index,maxValue);
        // make the max value go to top of heap
        siftUp(index);
        extractMax();

        return valueRemoved;
    }

    @Override
    public void heapify() {

        int n = size;
        // leaf nodes already satisfy the heap property, so start at previous level n/2
        for(int index = (n/2); index>=0; index--){
            siftDown(index);
        }
    }

    private void swapValues(int index1, int index2){

        T temp = array.at(index1);
        array.update(index1,array.at(index2));
        array.update(index2,temp);
    }

    private int leftOf(int nodeIndex){

        if((2*nodeIndex +1) < size)
            return (2*nodeIndex + 1);
        else
            return -1;
    }

    private int rightOf(int nodeIndex){

        if((2*nodeIndex +1) < size)
            return (2*nodeIndex +2);
        else
            return -1;
    }

    private int parentOf(int nodeIndex){

        if(nodeIndex == 0)
            return -1;
        else
            return (int)((nodeIndex-1)/2);
    }

    @Override
    public String toString() {

        String desc = "[";

        if(!isEmpty()) {
            desc = "[ "+array.at(0);
        }

        for(int i=1;i<size;i++) {
            desc= desc +" , "+array.at(i);
        }

        desc += " ]";

        return desc;

    }
}
