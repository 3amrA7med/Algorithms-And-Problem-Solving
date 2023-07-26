package com.playground.dynamic_programming.easy;

/**
 *  746. Min Cost Climbing Stairs
 *  Beats 100%
 *  43.2 MB Beats 56.4% , best 40
 * */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 2) return Math.min(cost[0], cost[1]);

        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < cost.length; i++)
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);

        return Math.min(dp[cost.length - 1],dp[cost.length - 2]);
    }

}
