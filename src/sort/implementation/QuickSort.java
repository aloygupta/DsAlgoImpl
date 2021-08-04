package sort.implementation;

import sort.Sort;

import java.util.Arrays;

public class QuickSort<T extends Comparable> implements Sort<T> {

    private T[] arrayToSort;

    private QuickSort(){
    }

    public QuickSort(T[] arrayToSort){
        this.arrayToSort = arrayToSort;
        //TODO: Random shuffle to improve efficiency
        //TODO: Make quicksort stable
        // TODO: Make it Djikstra's 3-way partitioning to speed up for duplicates (https://www.coursera.org/lecture/algorithms-part1/duplicate-keys-XvjPd)

    }

    @Override
    public T[] sort(STRATEGY strategy) {

        if(strategy == STRATEGY.QUICKSORT_TOPDOWN_RECURSIVE){
            sortRecursive(arrayToSort,0,arrayToSort.length-1);
        }

        return arrayToSort;
    }

    private void sortRecursive(T[] arr, int low, int high){

        if(low < high){
            int pivotIndex = partitionFirstElement(arr,low,high);

            sortRecursive(arr,low,pivotIndex-1);
            sortRecursive(arr,pivotIndex+1, high);
        }

       /* int size = high - low + 1;
        if(size<2)
            return;

        int pivotIndex = partitionRandomElement(arr,low,high);
        sortRecursive(arr,low,pivotIndex-1);
        sortRecursive(arr,pivotIndex+1, high);*/

    }

    private int partitionFirstElement(T[] arr, int low, int high){

        int leftPointer = low;
        int rightPointer = high +1;

        int pivotIndex = low;

        while (true){
            T pivotElement = arr[pivotIndex];
            // first element is being taken as partitioning element, so start comparing from the second element
            while(arr[++leftPointer].compareTo(pivotElement) <0){
                // keep moving leftPointer forward as long its less than pivot, but break off if we reach the end
                if(leftPointer == high)
                    break;
            }

            while (arr[--rightPointer].compareTo(pivotElement) >0){
                // keep moving rightPointer forward as long its grater than pivot, but break of if we reach start
                //TODO: Check why below test is redundant
                if(rightPointer == low)
                    break;
            }

            //break off if pointers have crossed each other
            if(leftPointer>=rightPointer)
                break;

            // swap the elements to put them on the correct side of the imagined pivot
            swap(arr,leftPointer,rightPointer);

        }
        // put the pivot in the correct place. (Everything left of rightPointer is <= Pivot. So, pivot has to be in rightPointer's place
        swap(arr,pivotIndex,rightPointer);

        // Since, rightPointer now points to the pivot element.
        return rightPointer;
    }

    private int partitionRandomElement(T[] arr, int low, int high){

        int size = high - low + 1;
        if(size<2)
            return low;

        int pivotIndex = high/2;
        T pivotElement = arr[pivotIndex];

        int leftPointer = low;
        int rightPointer = high;


        while(leftPointer <= rightPointer){

            while(arr[leftPointer].compareTo(pivotElement) <=0){
                ++leftPointer;
            }

            while(arr[rightPointer].compareTo(pivotElement) >=0){
                --rightPointer;
            }

            System.out.println("pivotIndex "+pivotIndex +" pivotElement "+pivotElement);
            System.out.println(leftPointer+" <---> "+rightPointer);
            if(leftPointer <= rightPointer){
                System.out.println(leftPointer+" <***> "+rightPointer);
                swap(arr,leftPointer,rightPointer);
            }

        }

        return leftPointer;
    }

    /**
     * After one partition pass, the index which gets assigned as pivotIndex, that element has found its rightful place in array.
     * In a sorted array, kth smallest element is arr[k]
     * So, when a pivot is same as k, it means, that the kth smallest element will reside at arr[k], even if the overall sorted at this point might be unsorted.
     * In worst case, it might lead to a full sorting of array, and then obviously arr[k] is the kth smallest element.
     *
     * Time Complexity: O(n) on avg.
     */
    public T getKthShortestElement(int k){

        int low = 0;
        int high = arrayToSort.length -1;

        while(high > low){
            int pivotIndex = partitionFirstElement(arrayToSort,low,high);
            //System.out.println(Arrays.toString(arrayToSort));
            //System.out.println("pivotIndex "+pivotIndex);
            if(pivotIndex < k){
                low = pivotIndex +1;
            }
            else if(pivotIndex > k){
                high = pivotIndex -1;
            }
            else
                return arrayToSort[k];
        }

        return arrayToSort[k];
    }

    private void swap(T[] arr,int index1, int index2){
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
