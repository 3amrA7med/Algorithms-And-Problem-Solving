package com.playground.dynamic_programming.medium;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 */
public class LongestIncreasingSubsequence {

    public void run() {
        System.out.println(lengthOfLIS(new int[]{4,10,4,3,8,9}));
    }

    /**
     * 65ms Beats 70.24%, best 4ms (binary search solution should be checked), best 41.5
     * 43.52mb Beats 37.31%
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] lisDp = new int[nums.length];
        Arrays.fill(lisDp, 1);
        int maxLis = Integer.MIN_VALUE;
        for(int i = nums.length - 1; i >= 0; i--) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] < nums[j]) lisDp[i] = Math.max(lisDp[i], lisDp[j] + 1);
            }
            maxLis = Math.max(lisDp[i], maxLis);
        }
        return maxLis;
    }

    /* Failed attempt
    int[] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return lengthOfLISTopDown(nums, 0, Integer.MIN_VALUE);
    }

    public int lengthOfLISTopDown(int[] nums, int index, int prev) {
        if(index >= nums.length) return 0;
        if(dp[index] != -1) return dp[index];

        if(nums[index] > prev)
            dp[index] = Math.max(1 + lengthOfLISTopDown(nums, index+1, nums[index]), lengthOfLISTopDown(nums, index+1, prev));
        else
            dp[index] = Math.max(lengthOfLISTopDown(nums, index+1, nums[index]), lengthOfLISTopDown(nums, index+1, prev));
        return dp[index];
    }
     */
}
