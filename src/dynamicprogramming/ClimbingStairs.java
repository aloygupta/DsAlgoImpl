package dynamicprogramming;

import java.util.Arrays;

// https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {

    private static int[] DP = new int[45+1];

    public ClimbingStairs(){
        Arrays.fill(DP,-1);
    }

    public int climbStairs(int n) {

        if(DP[n] != -1)
            return DP[n];

        if(n==1)
            return 1;

        if(n==2)
            return 2;

        int count = 0;

        count += climbStairs(n-1) +climbStairs(n-2);

        DP[n] = count;

        return count;
    }
}
