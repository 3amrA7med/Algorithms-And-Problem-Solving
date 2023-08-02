package com.playground.dynamic_programming.fib_dynamic_programming.medium;

/**
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
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
