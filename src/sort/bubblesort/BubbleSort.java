package sort.bubblesort;

import sort.Sort;

public class BubbleSort<T extends Comparable> implements Sort<T> {

    private T[] arrayToSort;

    private BubbleSort(){

    }

    public BubbleSort(T[] arrayToSort){
        this.arrayToSort = arrayToSort;
    }

    @Override
    public T[] sort(STRATEGY strategy) {

        if(strategy == STRATEGY.BUBBLESORT_BOTTOMUP_ITERATIVE){
            sortIterative(arrayToSort);
        }

        return arrayToSort;
    }

    private void sortIterative(T[] arrayToSort){

        int length = arrayToSort.length;

        // outer loop represents each pass
        // We perform (length-1) passes instead of (length) passes as optimization, because if we sort (length-1) elements, the remaining element, must already be in correct position
        for(int passNumber = 1; passNumber < length; passNumber++){
            boolean swapHappenedInThisPass = false;
            // inner loop represents array index
            // During first pass, alreadySortedNumberOfElements = 0; for 2nd pass, alreadySortedNumberOfElements = 1
            int alreadySortedNumberOfElements = passNumber -1;
            int effectiveLength = length-alreadySortedNumberOfElements;
            // max value of index can be (effectiveLength-2) , so that we can compare with the last element (effectiveLength-1)
            for(int index = 0; index <(effectiveLength-1); index++){
                if(arrayToSort[index].compareTo(arrayToSort[index+1])>0){
                    swap(arrayToSort,index,(index+1));
                    swapHappenedInThisPass = true;
                }
            }

            if(!swapHappenedInThisPass){
                // this pass saw no swaps, hence it is sorted now and we can break off
                break;
            }
        }
    }

    private void swap(T[] arr,int index1, int index2){
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
