package dynamicprogramming;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change-2/
public class CoinChangeNumberOfWays {

    private static final int MAX_DENOMINATIONS = 5000;
    private static final int MAX_AMOUNT = 5000;

    // DP[i][j] indicates that using denominations from (1 to i), in how many ways amount j can be made.
    // Note: 1 to i means valid denominations lying between 1 to i for example between 1 to 5 it might be 1,2,5
    private static int[][] DP = new int[MAX_DENOMINATIONS+1][MAX_AMOUNT+1];

    public CoinChangeNumberOfWays(){
        for(int i=0;i<MAX_DENOMINATIONS+1;i++){
            // clear the array
            Arrays.fill(DP[i],0);
        }
    }

    public int change(int amount,int[] coins) {

        // fill first column with zero. This indicates that to make amount "0" with any denomination, there is only 1 way - by not giving any coin
       for(int i = 0; i< MAX_DENOMINATIONS+1;i++){
           DP[i][0] = 1;
       }

        for(int coinIndex = 0; coinIndex< coins.length; coinIndex++){

            int coin = coins[coinIndex];
            for(int partialAmount = 0; partialAmount <= amount; partialAmount++){


                int prevCoin = -1;
                if(coinIndex-1 <0){
                    prevCoin = 0;
                }
                else{
                    prevCoin = coins[coinIndex-1];
                }



                if(coin > partialAmount){
                    // copy from previous coin row
                    DP[coin][partialAmount] = DP[prevCoin][partialAmount];
                }
                else{
                    // how many ways 1..(n-1) denominations can reach desired amount + how many ways 1..n denominations can reach (amount - n)
                    DP[coin][partialAmount] = DP[prevCoin][partialAmount] + DP[coin][partialAmount-coin];
                }
            }
        }


        // DP problem print out statement

        /*System.out.print("    ");
        for(int j=0; j<=amount; j++){
            System.out.print(j +"  ");
        }
        System.out.println();
        System.out.print("    ");
        for(int j=0; j<=amount; j++){
            System.out.print("---");
        }
        System.out.println();

        for(int i = 0;i<=coins[coins.length-1];i++){
            System.out.print(i+" | ");
            for(int j= 0; j <=amount; j++){
                System.out.print(DP[i][j]+"  ");
            }
            System.out.println();
        }
*/

        return DP[coins[coins.length-1]][amount];
    }
}
