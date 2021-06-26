import sort.Sort;
import sort.implementation.InsertionSort;

import java.util.ArrayList;
import java.util.List;

public class InsertionSortTest extends SortTestBase{


    @Override
    Sort<Integer> getTestSortObj(Integer[] values) {
        Sort<Integer> testSortObj = new InsertionSort<>(values);
        return testSortObj;
    }

    @Override
    List<Sort.STRATEGY> getStrategyList() {
        List<Sort.STRATEGY> strategyList = new ArrayList<>();
        strategyList.add(Sort.STRATEGY.INSERTIONSORT_BOTTOMUP_ITERATIVE);
        return strategyList;
    }
}
