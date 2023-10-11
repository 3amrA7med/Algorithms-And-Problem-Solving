package com.playground.dynamic_programming.easy;

/**
 * 746. Min Cost Climbing Stairs
 * ===========================
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 * ===========================
 * Beats 100%
 * 43.2 MB Beats 56.4% , best 40
 * ==========================
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
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
