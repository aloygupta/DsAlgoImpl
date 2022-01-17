package dynamicprogramming;

import java.util.Arrays;

//https://leetcode.com/problems/combination-sum-iv/
public class CombinationSumIV {

    private static final int TARGET = 1000;
    private static int[] DP = new int[TARGET+1];

    public CombinationSumIV(){
        Arrays.fill(DP,-1);
    }

    public int combinationSum4(int[] coins, int amount) {

        if(DP[amount] != -1)
            return DP[amount];

        if(amount == 0)
            return 1;

        int count = 0;

        for(int i=0; i<coins.length; i++){
            if((amount-coins[i])>=0){
                count += combinationSum4(coins,amount-coins[i]);
            }
        }

        DP[amount] = count;
        return count;

    }
}
