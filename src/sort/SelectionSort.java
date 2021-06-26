package sort;

import java.util.Arrays;

public class SelectionSort<T extends Comparable> implements Sort<T> {

    private T[] arrayToSort;

    private SelectionSort(){

    }

    public SelectionSort(T[] arrayToSort){
        this.arrayToSort = arrayToSort;
    }

    @Override
    public T[] sort(STRATEGY strategy) {

        if(strategy == STRATEGY.SELECTIONSORT_BOTTOMUP_ITERATIVE){
            sortIterative(arrayToSort);
        }

        return arrayToSort;
    }

    private void sortIterative(T[] arrayToSort){

        int length = arrayToSort.length;

        // going till n-1. If (n-1) elements are sorted, the nth element is automatically sorted.
        for(int indexToFix = 0; indexToFix < (length-1); indexToFix++){
            // assume that the current indexToFix is the smallest element
            int smallestElementIndex = indexToFix;

            // start checking is any element is smaller than the currently assumed element
            for(int index = (indexToFix+1); index < length; index++){
               if(arrayToSort[index].compareTo(arrayToSort[smallestElementIndex]) < 0){
                   // a smaller element found. Update the smallestElementIndex to keep track.
                   smallestElementIndex = index;
               }
            }
            swap(arrayToSort,indexToFix,smallestElementIndex);
            // After each pass, the ith smallest element is at ith position in array
        }

    }

    private void swap(T[] arr,int index1, int index2){
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
