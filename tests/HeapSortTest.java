import sort.Sort;
import sort.implementation.HeapSort;

import java.util.ArrayList;
import java.util.List;

public class HeapSortTest<T extends Comparable> extends SortTestBase {


    @Override
    Sort<Integer> getTestSortObj(Integer[] values) {
        Sort<Integer> testSortObj = new HeapSort<>(values);
        return testSortObj;
    }

    @Override
    List<Sort.STRATEGY> getStrategyList() {
        List<Sort.STRATEGY> strategyList = new ArrayList<>();
        strategyList.add(Sort.STRATEGY.HEAPSORT_BOTTOMUP_ITERATIVE);
        return strategyList;
    }
}
