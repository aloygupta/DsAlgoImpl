import sort.Sort;
import sort.bubblesort.BubbleSort;

import java.util.ArrayList;
import java.util.List;

public class BubbleSortTest extends SortTestBase{

    @Override
    Sort<Integer> getTestSortObj(Integer[] values) {
        Sort<Integer> testSortObj = new BubbleSort<>(values);
        return testSortObj;
    }

    @Override
    List<Sort.STRATEGY> getStrategyList() {
        List<Sort.STRATEGY> strategyList = new ArrayList<>();
        strategyList.add(Sort.STRATEGY.BUBBLESORT_BOTTOMUP_ITERATIVE);
        return strategyList;
    }
}
