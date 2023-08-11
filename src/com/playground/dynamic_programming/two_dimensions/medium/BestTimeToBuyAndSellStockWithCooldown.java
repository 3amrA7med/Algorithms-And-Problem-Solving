package com.playground.dynamic_programming.two_dimensions.medium;

import java.util.Arrays;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2]; // 2 actions
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        return maxProfitRec(prices, 0, dp, 0);
    }

    private int maxProfitRec(int[] prices, int index, int[][] dp, int state) {
        if(index >= prices.length) return 0;
        if(dp[index][state] != -1) return dp[index][state];

        // Buy state
        if(state == 0) dp[index][state] = Math.max(maxProfitRec(prices, index + 1, dp, 0), maxProfitRec(prices, index + 1, dp, 1) - prices[index]);
        else dp[index][state] = Math.max(maxProfitRec(prices, index + 1, dp, 1), maxProfitRec(prices, index + 2, dp, 0) + prices[index]);

        return dp[index][state];
    }
}
