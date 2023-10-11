package com.playground.dynamic_programming.one_dimension.medium;

/**
 * Paint House
 * =======================================
 * There is a row of n houses; each house can be painted with one of the three colors: red, blue or green.
 * The cost of painting each house with a certain color is different. You have to paint all the houses such
 * that no two adjacent houses have the same color, and you need to cost the least. Return the minimum cost.
 * The cost of painting each house with a certain color is represented by an n x 3 cost matrix. For example,
 * costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with
 * color green, and so on... Find the minimum cost to paint all houses.
 * ========================================
 * Example 1:
 * Input: [[14,2,11],[11,14,5],[14,3,10]]
 * Output: 10
 * Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue. Minimum cost: 2 + 5 + 3 = 10.
 * Example 2:
 * Input: [[1,2,3],[1,4,6]]
 * Output: 3
 */
public class PaintHouse {

    public int minCost(int[][] costs) {
        // write your code here
        int[] dp = costs[0];

        for(int[] cost: costs) {

            int dp0 = cost[0] + Math.min(dp[1], dp[2]);
            int dp1 = cost[1] + Math.min(dp[0], dp[2]);
            int dp2 = cost[2] + Math.min(dp[1], dp[0]);

            dp[0] = dp0;
            dp[1] = dp1;
            dp[2] = dp2;
        }

        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}
