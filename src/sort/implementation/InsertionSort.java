package sort.implementation;

import sort.Sort;

public class InsertionSort<T extends Comparable> implements Sort<T> {

    private T[] arrayToSort;

    private InsertionSort(){

    }

    public InsertionSort(T[] arrayToSort){
        this.arrayToSort = arrayToSort;
    }

    @Override
    public T[] sort(STRATEGY strategy) {

        if(strategy == STRATEGY.INSERTIONSORT_BOTTOMUP_ITERATIVE){
            sortIterative(arrayToSort);
        }

        return arrayToSort;
    }

    private void sortIterative(T[] arrayToSort){

        int length = arrayToSort.length;
        // the first index, 0 represents "one element sorted subarray", hence we start at index 1
        for(int unsortedArrayIndex = 1; unsortedArrayIndex <= length-1; unsortedArrayIndex++){

            int index = unsortedArrayIndex;
            //loop back to check where the first element of the unsorted array should fit in the sorted array
            while((index > 0 && arrayToSort[index].compareTo(arrayToSort[index-1]) < 0)){
                swap(arrayToSort,index,index-1);
                --index;
            }
            // array from [0..unsortedArrayIndex] is now sorted
            // Note: [0...unsortedArrayIndex] do not necessarily represent the smallest elements of [0...length-1]
        }
    }

    private void swap(T[] arr,int index1, int index2){
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
