package com.playground.dynamic_programming.medium;

/**
 * 1049. Last Stone Weight II
 * hard not intuitive
 */
public class LastStoneWeightII {

    /**
     * Runtime 2ms Beats 94.78%
     * Memory 41.05MB Beats 29.46%
     */
    Integer[][] dp;
    public int lastStoneWeightII(int[] stones) {
        int stoneSum = 0;
        for(int i: stones) stoneSum+=i;
        int target = (int)Math.ceil(stoneSum/2);
        dp = new Integer[target + 1][stones.length];
        return lastStoneWeightIIRec(stones, 0, 0, stoneSum, target);
    }

    public int lastStoneWeightIIRec(int[] stones, int i, int total, int stoneSum, int target) {
        if(i == stones.length || total >= target) return Math.abs(total - (stoneSum - total));

        if(dp[total][i] != null) return dp[total][i];

        dp[total][i] = Math.min(lastStoneWeightIIRec(stones, i + 1, total, stoneSum, target),
                lastStoneWeightIIRec(stones, i + 1, total + stones[i], stoneSum, target));

        return dp[total][i];
    }
}
