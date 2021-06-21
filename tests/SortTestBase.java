import org.junit.Assert;
import org.junit.Test;
import sort.Sort;

import java.util.Arrays;
import java.util.List;

public abstract class SortTestBase {

    private Sort<Integer> testSortObj;
    private List<Sort.STRATEGY> strategyList;

    abstract Sort<Integer> getTestSortObj(Integer[] values);

    abstract List<Sort.STRATEGY> getStrategyList();

    public SortTestBase(){
        this.strategyList = getStrategyList();
    }

    @Test
    public void testAlreadySorted() {
        for(Sort.STRATEGY strategy: strategyList){
            Integer[] values = {-1, 0, 2, 8, 9, 9, 11, 23, 34, 90, 98};
            testSortObj = getTestSortObj(values);
            Integer[] op = testSortObj.sort(strategy);
            Assert.assertEquals("[-1, 0, 2, 8, 9, 9, 11, 23, 34, 90, 98]",Arrays.toString(op));
        }
    }

    @Test
    public void testRandomElements(){
        for(Sort.STRATEGY strategy: strategyList){
            Integer[] values = {2,0,9,-1,8,34,98,11,90,23,9};
            testSortObj = getTestSortObj(values);
            Integer[] op = testSortObj.sort(strategy);
            Assert.assertEquals("[-1, 0, 2, 8, 9, 9, 11, 23, 34, 90, 98]",Arrays.toString(op));
        }
    }

    @Test
    public void testOneElement(){
        for(Sort.STRATEGY strategy: strategyList){
            Integer[] values = {5};
            testSortObj = getTestSortObj(values);
            Integer[] op = testSortObj.sort(strategy);
            Assert.assertEquals("[5]",Arrays.toString(op));
        }


    }

    @Test
    public void testZeroElements(){
        for(Sort.STRATEGY strategy: strategyList){
            Integer[] values = {};
            testSortObj = getTestSortObj(values);
            Integer[] op = testSortObj.sort(strategy);
            Assert.assertEquals("[]",Arrays.toString(op));
        }
    }

    @Test
    public void testReverseOrder(){
        for(Sort.STRATEGY strategy: strategyList){
            Integer[] values = {132,111,89,88,45,39,23,10,-1,-99,-198};
            testSortObj = getTestSortObj(values);
            Integer[] op = testSortObj.sort(strategy);
            Assert.assertEquals("[-198, -99, -1, 10, 23, 39, 45, 88, 89, 111, 132]",Arrays.toString(op));
        }

    }
}
