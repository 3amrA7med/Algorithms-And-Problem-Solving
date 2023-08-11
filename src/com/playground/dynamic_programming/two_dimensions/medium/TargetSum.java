package com.playground.dynamic_programming.two_dimensions.medium;

import java.util.Arrays;

/**
 * 494. Target Sum
 */
public class TargetSum {

    // 65% runtime (11ms) but nearly similar to the fastest solution, 20% memory but not too far away.
    public static final int MAX_SUM = 1000;

    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[nums.length][2 * MAX_SUM  +1];
        for(int i = 0; i < nums.length; i++) Arrays.fill(dp[i], -1);
        return findTargetSumWaysTopDownRec(nums, 0, 0, target, dp);
    }

    public int findTargetSumWaysTopDownRec(int[] nums, int numIndex, int val, int target, int[][] dp) {
        if(val == target && numIndex == nums.length) return 1;
        if(numIndex >= nums.length) return 0;
        if(dp[numIndex][val + MAX_SUM] != -1) return dp[numIndex][val + MAX_SUM];

        dp[numIndex][val + MAX_SUM] = findTargetSumWaysTopDownRec(nums, numIndex + 1, val + nums[numIndex], target, dp) + findTargetSumWaysTopDownRec(nums, numIndex + 1, val - nums[numIndex], target, dp);

        return dp[numIndex][val + MAX_SUM];
    }
}
