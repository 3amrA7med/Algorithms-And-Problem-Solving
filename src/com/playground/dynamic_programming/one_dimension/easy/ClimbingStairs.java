package com.playground.dynamic_programming.one_dimension.easy;

/**
  * 70. Climbing Stairs
 */
public class ClimbingStairs {

    /**
     * Can be reduced to O(1) memory space
     */
    public int climbStairs(int n) {
        if(n == 1) return 1;

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n - 1];
    }
}
