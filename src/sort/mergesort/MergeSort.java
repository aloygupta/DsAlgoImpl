package sort.mergesort;

import sort.Sort;
import sort.SortObject;

public class MergeSort<T extends Comparable> implements Sort<T>{

    private T[] arrayToSort;

    private MergeSort(){
    }

    public MergeSort(T[] arrayToSort){
        this.arrayToSort = arrayToSort;
    }

    @Override
    public T[] sort(STRATEGY strategy) {

        SortObject[] aux =  new SortObject[arrayToSort.length];

        for(int i=0; i<arrayToSort.length; i++){
            aux[i] = new SortObject(arrayToSort[i]);
        }

        sort(strategy,arrayToSort,aux,0,(arrayToSort.length-1));

        return arrayToSort;

    }

    private void sort(STRATEGY strategy,T[] arr, SortObject[] aux,int low, int high){

        // if high and low are same, its an one element array, hence "sorted"
        if(high<=low)
            return;

        int mid = low + (high - low)/2;

        // sort the first half recursively
        sort(strategy, arr, aux, low, mid);
        // sort the second half recursively
        sort(strategy, arr, aux, mid+1, high);
        // merge both the halves
        merge(arr,aux,low,mid,high);

    }

    /**
     * arr is sorted from low to mid and mid to high. We use empty aux array to first copy and then
     * merge back an overall sorted array.
      */
    private void merge(T[] arr, SortObject[] aux,int low, int mid, int high){

        //aux = Arrays.copyOfRange(arr,low,high);

        //  Copy the entire array to the aux array
        for(int index = low; index <= high; index++){
            aux[index].actualObjValue = arr[index];
        }

        int leftIndex = low;
        int rightIndex = mid+1;

        for(int index = low; index <= high; index++){

            if(leftIndex > mid){
                // we have exhausted our left pointer, so keep copying remaining of the right array
                arr[index] = (T) aux[rightIndex++].actualObjValue;
            }
            else if(rightIndex > high){
                // we have exhausted our right pointer, so keep copying remaining of the left array
                arr[index] = (T) aux[leftIndex++].actualObjValue;
            }
            else if(aux[leftIndex].actualObjValue.compareTo(aux[rightIndex].actualObjValue)<=0){
                // left element <= right element, so copy left(smaller) element and move the left pointer
                arr[index] = (T) aux[leftIndex++].actualObjValue;
            }
            else if(aux[leftIndex].actualObjValue.compareTo(aux[rightIndex].actualObjValue)>0){
                // left element > right element, so copy right(smaller) element and move the right pointer
                arr[index] = (T) aux[rightIndex++].actualObjValue;
            }

        }
    }
}
