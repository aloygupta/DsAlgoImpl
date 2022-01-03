package dynamicprogramming;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change/
public class CoinChangeMinCoins {

    private static final int MAX_TYPE_OF_COINS = 12;
    private static final int MAX_AMOUNT = 10000;

    // DP[i][j] indicates that using denominations from (1 to i), min DP[i][j] number of coins are required to make j.
    // Note: 1 to i means valid denominations lying between 1 to i for example between 1 to 5 it might be 1,2,5
    private static int[][] DP = new int[MAX_TYPE_OF_COINS +1][MAX_AMOUNT+1];

    public CoinChangeMinCoins(){
        for(int i = 0; i< MAX_TYPE_OF_COINS +1; i++){
            // clear the array
            Arrays.fill(DP[i],0);
        }
    }

    public int coinChange(int[] coins, int amount) {

        int[] tempCoins = new int[coins.length+1];
        tempCoins[0] = 0;

       for(int i =0; i<coins.length;i++){
           tempCoins[i+1]= coins[i];
       }
        coins = tempCoins;

        for(int i = 0; i< MAX_AMOUNT+1;i++){
            DP[0][i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i< MAX_TYPE_OF_COINS +1; i++){
            DP[i][0] = 0;
        }


        for(int coinIndex = 1; coinIndex< coins.length; coinIndex++){

            int coin = coins[coinIndex];
            for(int partialAmount = 1; partialAmount <= amount; partialAmount++){

                /*int prevCoinIndex = -1;
                if(coinIndex-1 <0){
                    prevCoinIndex = 0;
                }
                else{
                    prevCoinIndex = coinIndex -1;
                }*/
                int prevCoinIndex = coinIndex -1;

                if(coin > partialAmount){
                    // copy from previous coin row
                    DP[coinIndex][partialAmount] = DP[prevCoinIndex][partialAmount];
                }
                else{
                    // see how many coins with current (maxCoin = coin) can be used up first + (for remaining amount, check min number coins required using 1..prevCoin)
                    DP[coinIndex][partialAmount] = Math.min(DP[prevCoinIndex][partialAmount],effectiveMinCoinsForRemainder(DP[coinIndex][partialAmount-coin]));
                }
            }
        }


        // DP problem print out statement
      /*  System.out.print("    ");
        for(int j=0; j<=amount; j++){
            System.out.print(j +"  ");
        }
        System.out.println();
        System.out.print("    ");
        for(int j=0; j<=amount; j++){
            System.out.print("---");
        }
        System.out.println();

        for(int i = 0;i<coins.length;i++){
            System.out.print(i+" | ");
            for(int j= 0; j <=amount; j++){
                System.out.print(DP[i][j]+"  ");
            }
            System.out.println();
        }*/
        int minCoins = DP[coins.length-1][amount];
        if(minCoins == Integer.MAX_VALUE || minCoins == Integer.MIN_VALUE)
            minCoins = -1;

        return minCoins ;
    }

    private int effectiveMinCoinsForRemainder(int remCoins){
        if(remCoins == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else
            return 1+remCoins;
    }
}

