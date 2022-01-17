package dynamicprogramming;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeBuySellStock {

    private static int[][] DP = new int[100000][100000];
    public BestTimeBuySellStock(){

    }

    public int maxProfit(int[] prices) {

     /*   int maxProfit = 0;
        for(int buyDate = 0; buyDate <prices.length-1; buyDate++){
            for(int sellDate = buyDate+1; sellDate <prices.length; sellDate++){
                if((prices[sellDate] - prices[buyDate]) > maxProfit)
                    maxProfit = prices[sellDate] - prices[buyDate];
            }
        }

        return maxProfit;*/

        return linearNormalLogic(prices);
    }

    private int linearNormalLogic(int[] prices){

        int minPrice = prices[0];
        int max = 0;
        for(int date = 0; date < prices.length; date++){
            if(prices[date] > minPrice){
                max = Math.max(max,prices[date] - minPrice);
            }
            else{
                // if a new low price has been found, assign it. Then try to find the max diff possible of prices[date] and minPrice
                minPrice = prices[date];
            }
        }

        return max;
    }

    private int maxSubArray(int[] prices){
        // TODO: In future using max sub array
        return 0;
    }
}
