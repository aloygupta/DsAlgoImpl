import org.junit.Assert;
import org.junit.Test;
import sort.Sort;
import sort.implementation.MergeSort;
import sort.implementation.QuickSort;

import java.util.ArrayList;
import java.util.List;

public class QuickSortTest extends SortTestBase {


    @Override
    Sort<Integer> getTestSortObj(Integer[] values) {
        Sort<Integer> testSortObj = new QuickSort<>(values);
        return testSortObj;
    }

    @Override
    List<Sort.STRATEGY> getStrategyList() {
        List<Sort.STRATEGY> strategyList = new ArrayList<>();
        strategyList.add(Sort.STRATEGY.QUICKSORT_TOPDOWN_RECURSIVE);
        return strategyList;
    }

    @Test
    public void testKthShortestElement(){
        Integer[] values = {2,0,9,-1,8,34,98,11,90,23,9};
        QuickSort<Integer> testSortObj = (QuickSort<Integer>) getTestSortObj(values);

        //4th smallest element
        Assert.assertEquals(""+8,""+testSortObj.getKthShortestElement(3));

        //9th smalllest element
        Assert.assertEquals(""+34,""+testSortObj.getKthShortestElement(8));


    }
}
