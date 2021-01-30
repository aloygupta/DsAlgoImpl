import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sort.Sort;
import sort.mergesort.MergeSort;

import java.util.Arrays;

public class MergeSortTest {

    private Sort<Integer> testSortObj;

    @Test
    public void testSort(){

        Integer[] values = {2,0,9,-1,8,34,98,11,90,23,9};
        testSortObj = new MergeSort<>(values);

        Integer[] op = testSortObj.sort(Sort.STRATEGY.IN_PLACE);
        Assert.assertEquals("[-1, 0, 2, 8, 9, 9, 11, 23, 34, 90, 98]",Arrays.toString(op));

    }

    @Test
    public void testOneElement(){

        Integer[] values = {5};
        testSortObj = new MergeSort<>(values);

        Integer[] op = testSortObj.sort(Sort.STRATEGY.IN_PLACE);
        Assert.assertEquals("[5]",Arrays.toString(op));

    }

    @Test
    public void testZeroElements(){

        Integer[] values = {};
        testSortObj = new MergeSort<>(values);

        Integer[] op = testSortObj.sort(Sort.STRATEGY.IN_PLACE);
        Assert.assertEquals("[]",Arrays.toString(op));

    }
}
