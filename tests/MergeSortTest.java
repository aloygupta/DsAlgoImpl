import sort.Sort;
import sort.implementation.MergeSort;

import java.util.ArrayList;
import java.util.List;

public class MergeSortTest extends SortTestBase {


    @Override
    Sort<Integer> getTestSortObj(Integer[] values) {
        Sort<Integer> testSortObj = new MergeSort<>(values);
        return testSortObj;
    }

    @Override
    List<Sort.STRATEGY> getStrategyList() {
        List<Sort.STRATEGY> strategyList = new ArrayList<>();
        strategyList.add(Sort.STRATEGY.MERGESORT_TOPDOWN_RECURSIVE);
        strategyList.add(Sort.STRATEGY.MERGESORT_BOTTOMUP_ITERATIVE);
        return strategyList;
    }
}
