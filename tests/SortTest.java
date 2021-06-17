import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sort.Sort;
import sort.bubblesort.BubbleSort;
import sort.mergesort.MergeSort;

import java.util.Arrays;

public class SortTest {

    private Sort<Integer> testSortObj;

    @Test
    public void testSort(){

        Integer[] values = {2,0,9,-1,8,34,98,11,90,23,9};
        testSortObj = new MergeSort<>(values);
        Integer[] op = testSortObj.sort(Sort.STRATEGY.MERGESORT_TOPDOWN_RECURSIVE);
        Assert.assertEquals("[-1, 0, 2, 8, 9, 9, 11, 23, 34, 90, 98]",Arrays.toString(op));


        Integer[] values1 = {2,0,9,-1,8,34,98,11,90,23,9};
        testSortObj = new MergeSort<>(values1);
        Integer[] op1 = testSortObj.sort(Sort.STRATEGY.MERGESORT_BOTTOMUP_ITERATIVE);
        Assert.assertEquals("[-1, 0, 2, 8, 9, 9, 11, 23, 34, 90, 98]",Arrays.toString(op1));


        Integer[] values2 = {2,0,9,-1,8,34,98,11,90,23,9};
        testSortObj = new BubbleSort<>(values2);
        Integer[] op2 = testSortObj.sort(Sort.STRATEGY.BUBBLESORT_BOTTOMUP_ITERATIVE);
        Assert.assertEquals("[-1, 0, 2, 8, 9, 9, 11, 23, 34, 90, 98]",Arrays.toString(op2));


    }

    @Test
    public void testOneElement(){

        Integer[] values = {5};
        testSortObj = new MergeSort<>(values);
        Integer[] op = testSortObj.sort(Sort.STRATEGY.MERGESORT_TOPDOWN_RECURSIVE);
        Assert.assertEquals("[5]",Arrays.toString(op));

        Integer[] values1 = {5};
        testSortObj = new MergeSort<>(values1);
        Integer[] op1 = testSortObj.sort(Sort.STRATEGY.MERGESORT_BOTTOMUP_ITERATIVE);
        Assert.assertEquals("[5]",Arrays.toString(op1));

        Integer[] values2 = {5};
        testSortObj = new BubbleSort<>(values2);
        Integer[] op2 = testSortObj.sort(Sort.STRATEGY.BUBBLESORT_BOTTOMUP_ITERATIVE);
        Assert.assertEquals("[5]",Arrays.toString(op2));

    }

    @Test
    public void testZeroElements(){

        Integer[] values = {};
        testSortObj = new MergeSort<>(values);
        Integer[] op = testSortObj.sort(Sort.STRATEGY.MERGESORT_TOPDOWN_RECURSIVE);
        Assert.assertEquals("[]",Arrays.toString(op));

        Integer[] values1 = {};
        testSortObj = new MergeSort<>(values1);
        Integer[] op1 = testSortObj.sort(Sort.STRATEGY.MERGESORT_BOTTOMUP_ITERATIVE);
        Assert.assertEquals("[]",Arrays.toString(op1));

        Integer[] values2 = {};
        testSortObj = new BubbleSort<>(values2);
        Integer[] op2 = testSortObj.sort(Sort.STRATEGY.BUBBLESORT_BOTTOMUP_ITERATIVE);
        Assert.assertEquals("[]",Arrays.toString(op2));

    }

    @Test
    public void testReverseOrder(){

        Integer[] values = {132,111,89,88,45,39,23,10,-1,-99,-198};
        testSortObj = new MergeSort<>(values);
        Integer[] op = testSortObj.sort(Sort.STRATEGY.MERGESORT_TOPDOWN_RECURSIVE);
        Assert.assertEquals("[-198, -99, -1, 10, 23, 39, 45, 88, 89, 111, 132]",Arrays.toString(op));

        Integer[] values1 = {132,111,89,88,45,39,23,10,-1,-99,-198};
        testSortObj = new MergeSort<>(values1);
        Integer[] op1 = testSortObj.sort(Sort.STRATEGY.MERGESORT_BOTTOMUP_ITERATIVE);
        Assert.assertEquals("[-198, -99, -1, 10, 23, 39, 45, 88, 89, 111, 132]",Arrays.toString(op1));

        Integer[] values2 = {132,111,89,88,45,39,23,10,-1,-99,-198};
        testSortObj = new BubbleSort<>(values2);
        Integer[] op2 = testSortObj.sort(Sort.STRATEGY.BUBBLESORT_BOTTOMUP_ITERATIVE);
        Assert.assertEquals("[-198, -99, -1, 10, 23, 39, 45, 88, 89, 111, 132]",Arrays.toString(op2));

    }
}
