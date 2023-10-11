package com.playground.dynamic_programming.one_dimension.medium;

/**
 * 983. Minimum Cost For Tickets
 * =========================
 * You have planned some train traveling one year in advance. The days of the year in
 * which you will travel are given as an integer array days. Each day is an integer from 1 to 365.
 * Train tickets are sold in three different ways:
 * a 1-day pass is sold for costs[0] dollars,
 * a 7-day pass is sold for costs[1] dollars, and
 * a 30-day pass is sold for costs[2] dollars.
 * The passes allow that many days of consecutive travel.
 * For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
 * Return the minimum number of dollars you need to travel every day in the given list of days.
 * =====================================
 * Input: days = [1,4,6,7,8,20], costs = [2,7,15]
 * Output: 11
 * Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
 * On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
 * On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
 * In total, you spent $11 and covered all the days of your travel.
 * ==================
 * Example 2
 * days = [1,4,6,7,8,20]
 * costs = [7,2,15]
 * output = 6
 */
public class MinimumCostForTickets {

    public void run() {
        System.out.println(this.mincostTicketsBotUp(new int[]{1,4,6,9,10,11,12,13,14,15,16,17,18,20,21,22,23,27,28}, new int[]{3,13,45}));
    }

    /**
     * Don't put test case as the last value in the array,
     * Runtime 0ms Beats 100.00%
     * Memory 40.44MB Beats 47.08%
     */
    Integer[] dp;
    public int mincostTickets(int[] days, int[] costs) {
        dp = new Integer[days.length];
        return mincostTicketsTopDown(days, costs, days[0], 0);
    }

    public int mincostTicketsTopDown(int[] days, int[] costs, int day, int index) {
        if(index >= days.length) return 0;
        if(day > days[index]) return mincostTicketsTopDown(days, costs, day, index + 1);
        if(dp[index] != null) return dp[index];

        dp[index] = Math.min(mincostTicketsTopDown(days, costs, days[index] + 1, index + 1) + costs[0],
                mincostTicketsTopDown(days, costs, days[index] + 7, index + 1) + costs[1]);
        dp[index] = Math.min(dp[index], mincostTicketsTopDown(days, costs, days[index] + 30, index + 1) + costs[2]);

        return dp[index];
    }

    //=================================
    /**
     * Runtime 1ms Beats 79.97%
     * Memory 40.31MB Beats 55.31%
     */

    final static int ONE_DAY_PASS = 1;
    final static int SEVEN_DAY_PASS = 7;
    final static int THIRTY_DAY_PASS = 30;

    public int mincostTicketsBotUp(int[] days, int[] costs) {
        int[] dp = new int[days.length + 1];

        for(int index = days.length - 1; index >= 0; index--) {
            dp[index] = Math.min(calcPassCost(days,index,ONE_DAY_PASS, costs[0], dp), calcPassCost(days,index,SEVEN_DAY_PASS, costs[1], dp));
            dp[index] = Math.min(dp[index], calcPassCost(days,index,THIRTY_DAY_PASS, costs[2], dp));
        }

        return dp[0];
    }

    private int calcPassCost(int days[], int index, int passDays, int passCost, int[] dp) {
        int index2 = index;
        while(index2 < days.length && days[index2] < days[index] + passDays) index2++;
        return dp[index2] + passCost;
    }

}
