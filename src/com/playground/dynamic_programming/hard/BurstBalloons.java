package com.playground.dynamic_programming.hard;

/**
 * 312. Burst Balloons
 */
public class BurstBalloons {
    Integer[][] dp;

    /**
     * 195ms Beats 8.95%
     * 47.28mb Beats 5.19%
     */
    public int maxCoins(int[] nums) {
        if(nums.length == 1) return nums[0];

        int[] newNums = new int[nums.length + 2];
        for(int i = 1; i < newNums.length - 1; i++)
            newNums[i] = nums[i-1];
        newNums[0] = 1;
        newNums[newNums.length - 1] = 1;
        dp = new Integer[newNums.length][newNums.length];
        return maxCoinsDfs(newNums, 1, newNums.length - 2);
    }

    public int maxCoinsDfs(int[] nums, int l, int r) {
        if(r < l) return 0;
        if(dp[l][r] != null) return dp[l][r];

        dp[l][r] = 0;
        for(int i = l; i <= r; i++) {
            int coins = nums[l - 1] * nums[i] * nums[r + 1];
            coins+= maxCoinsDfs(nums, l, i - 1);
            coins+= maxCoinsDfs(nums, i + 1, r);
            dp[l][r] = Math.max(dp[l][r], coins);
        }
        return dp[l][r];
    }
}
