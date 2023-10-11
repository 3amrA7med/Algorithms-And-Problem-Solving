package com.playground.dynamic_programming.two_dimensions.medium;

import java.util.Arrays;

/**
 * 494. Target Sum
 * ======================
 * You are given an integer array nums and an integer target.
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before
 * each integer in nums and then concatenate all the integers.
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and
 * concatenate them to build the expression "+2-1". Return the number of different expressions
 * that you can build, which evaluates to target.
 * ====================================
 * Example 1:
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * Example 2:
 * Input: nums = [1], target = 1
 * Output: 1
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
