import sort.InsertionSort;
import sort.SelectionSort;
import sort.Sort;

import java.util.ArrayList;
import java.util.List;

public class SelectionSortTest extends SortTestBase {
    @Override
    Sort<Integer> getTestSortObj(Integer[] values) {
        Sort<Integer> testSortObj = new SelectionSort<>(values);
        return testSortObj;
    }

    @Override
    List<Sort.STRATEGY> getStrategyList() {
        List<Sort.STRATEGY> strategyList = new ArrayList<>();
        strategyList.add(Sort.STRATEGY.SELECTIONSORT_BOTTOMUP_ITERATIVE);
        return strategyList;
    }
}
