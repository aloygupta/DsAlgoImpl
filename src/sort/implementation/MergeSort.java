package sort.implementation;

import logging.LogUtils;
import sort.Sort;
import sort.SortObject;

public class MergeSort<T extends Comparable> implements Sort<T> {

    private LogUtils logUtils = new LogUtils(MergeSort.class.getSimpleName(),true);
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

        if(strategy == STRATEGY.MERGESORT_TOPDOWN_RECURSIVE){
            sortRecursive(arrayToSort,aux,0,(arrayToSort.length-1));
        }
        else{
            sortIterative(arrayToSort,aux);
        }

        return arrayToSort;

    }

    private void sortRecursive(T[] arr, SortObject[] aux, int low, int high){

            // if high and low are same, its an one element array, hence "sorted"
            if(high<=low)
                return;

            int mid = low + (high - low)/2;

            // sortRecursive the first half recursively
            sortRecursive(arr, aux, low, mid);
            // sortRecursive the second half recursively
            sortRecursive(arr, aux, mid+1, high);
            // merge both the halves
            merge(arr,aux,low,mid,high);

    }

    private void sortIterative(T[] arr, SortObject[] aux){

        //arrayBlockSize = 1,2,4,8,16..

        int length = arr.length;
        // arrayBlockSize can go on till (length-1) because in some cases, the last division would of two sorted arrays of (length-1) and 1, which have to be merged.
        // In most cases, it would be some other combination of sorted arrays of size m and n where m+n = length.
        for(int arrayBlockSize =1; arrayBlockSize <= (length-1); arrayBlockSize= 2*arrayBlockSize){

            //leftStart can go till (length-2) because lets say, in first pass, when arrayBlockSize =1,
            // we need to stop at (length-2) for left array (lone) element so that right array (lone) element is (length-1), the last one.
            for(int leftStart = 0; leftStart <(length-1); leftStart += 2*arrayBlockSize){

                int mid = Math.min(leftStart+arrayBlockSize-1,length-1);

                int rightEnd = Math.min(leftStart + 2*arrayBlockSize -1,length-1);

                logUtils.logI("arrayBlockSize: "+arrayBlockSize);
                logUtils.logI("leftStart: "+leftStart);
                logUtils.logI("mid: "+mid);
                logUtils.logI("rightEnd: "+rightEnd);

                // We have two sorted sub arrays now, each of size 1,2,4,8,... (size 1 array is sorted by definition)
                // First subarray is arr[leftStart..mid]
                // Second subarray is arr[mid+1...rightEnd]
                merge(arr,aux,leftStart,mid,rightEnd);
            }
        }
    }

    /**
     * arr is sorted from low to mid and mid to high. We use empty aux array to first copy and then
     * merge back an overall sorted array.
      */
    private void merge(T[] arr, SortObject[] aux,int low, int mid, int high){
        logUtils.logI("");
        logUtils.logI("Merging: low = "+low+" mid = "+mid+" high = "+high);

        String lowToMidArr = "[ ";
        for(int index = low; index <= mid; index++){
            lowToMidArr += arr[index] + ", ";
        }
        lowToMidArr += "]";
        logUtils.logI("Low to mid arr: arr["+low+"..."+mid+"] = "+lowToMidArr);

        String midToHighArr = "[ ";
        for(int index = mid+1; index <= high; index++){
            midToHighArr += arr[index] + ", ";
        }
        midToHighArr += "]";
        logUtils.logI("Mid+1 to high arr: arr["+(mid+1)+"..."+high+"] = "+midToHighArr);


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
