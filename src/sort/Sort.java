package sort;

import list.List;

public interface Sort<T>  {

    enum STRATEGY{
        MERGESORT_TOPDOWN_RECURSIVE, MERGESORT_BOTTOMUP_ITERATIVE,
        BUBBLESORT_BOTTOMUP_ITERATIVE;
    }

    /**
     * Function to be implemented to sort an array
     * @param strategy the strategy of sorting
     * @return sorted array. If strategy was IN_PLACE then array passed as input contains
     * the sorted array and that is returned. If strategy was OUTPUT_ARRAY then another array is returned.
     */
    //TODO: Aloy: Implemented order - asc, desc, comparator
    T[] sort(STRATEGY strategy);
}
