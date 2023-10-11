package com.playground.dynamic_programming.fib_dynamic_programming.medium;

/**
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 * ==============================
 * You are given an array prices where prices[i] is the price of a given stock on the ith day,
 * and an integer fee representing a transaction fee.
 * Find the maximum profit you can achieve. You may complete as many transactions as you like,
 * but you need to pay the transaction fee for each transaction.
 * Note:
 * You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * The transaction fee is only charged once for each stock purchase and sale.
 * ================================
 * Input: prices = [1,3,2,8,4,9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * - Buying at prices[0] = 1
 * - Selling at prices[3] = 8
 * - Buying at prices[4] = 4
 * - Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    /**
     * 3ms Beats 100.00%
     * 54.54mb Beats 63.80%
     */
    public int maxProfitBottomUp(int[] prices, int fee) {
        if(prices.length == 1) return 0;

        int hold = -prices[0];
        int free = 0;
        for(int i = 1; i < prices.length; i++){
            int temp = hold;
            hold = Math.max(hold, free - prices[i]);
            free = Math.max(free, temp + prices[i] - fee);
        }

        return free;
    }

    /**
     * 46ms Beats 11.29%
     * 68.20mb Beats 5.15%
     */
    Integer[][] maxProfitDp;
    public int maxProfit(int[] prices, int fee) {
        if(prices.length == 1) return 0;
        maxProfitDp = new Integer[prices.length][2];
        return maxProfitTopDown(prices, 0, 0, fee, 0);
    }

    public int maxProfitTopDown(int[] prices, int index, int profit,int fee, int buyFlag) {
        if(index >= prices.length) return profit;
        if(maxProfitDp[index][buyFlag] != null) return maxProfitDp[index][buyFlag];

        // Previous purchase was buying a stock, then we cant buy again we must sell.
        if(buyFlag == 1) {
            maxProfitDp[index][buyFlag] = Math.max(maxProfitTopDown(prices, index+1, profit, fee, 1), maxProfitTopDown(prices, index+1, profit, fee, 0)+ prices[index]);
        }
        // No previous purchase was done, then we cant sell again we must buy.
        else {
            maxProfitDp[index][buyFlag] = Math.max(maxProfitTopDown(prices, index+1, profit, fee, 0), maxProfitTopDown(prices, index+1, profit, fee, 1)- prices[index] - fee);
        }
        return maxProfitDp[index][buyFlag];
    }
}
