package sort.implementation;

import heap.Heap;
import heap.implementation.ArrayHeap;
import sort.Sort;

import java.util.Arrays;

// Most of the magic happens in the Heap class
public class HeapSort<T extends Comparable> implements Sort<T> {

    private T[] arrayToSort;

    private HeapSort(){

    }

    public HeapSort(T[] arrayToSort){
        this.arrayToSort = arrayToSort;
    }

    @Override
    public T[] sort(STRATEGY strategy) {
        if(strategy == STRATEGY.HEAPSORT_BOTTOMUP_ITERATIVE){
            sortIterative(arrayToSort);
        }

        return arrayToSort;
    }

    private void sortIterative(T[] arrayToSort){

        Heap<T> heap = new ArrayHeap<>();
        // building the heap first
        for(T item: arrayToSort){
            heap.insert(item);
        }

        int length = arrayToSort.length;
        for(int index = (length-1); index >= 0; index--){
            try {
                T maxValue = heap.extractMax();
                arrayToSort[index] = maxValue;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
