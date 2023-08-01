package com.playground.dynamic_programming.medium;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    /**
     * Not working
     */
    int[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 == 1) return false;
        dp = new int[nums.length][sum+1];
        return canPartitionTopDown(nums, 0, 0, 0) == 1;
    }

    public int canPartitionTopDown(int[] nums, int index, int s1, int s2) {
        if(index >= nums.length && s1 == s2) return 1;
        else if(index >= nums.length && s1 != s2) return -1;
        if(dp[index][s1] != -1) return dp[index][s1];

        dp[index][s1] = Math.max(canPartitionTopDown(nums, index + 1, s1+nums[index], s2), canPartitionTopDown(nums, index + 1, s1, s2+nums[index]));

        return dp[index][s1];
    }
}
