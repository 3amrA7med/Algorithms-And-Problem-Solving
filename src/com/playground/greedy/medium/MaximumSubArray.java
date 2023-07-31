package com.playground.greedy.medium;

/**
 * 53. Maximum SubArray
 */
public class MaximumSubArray {

    /**
     * 1ms Beats 100.00%
     * 59.66mb Beats 54.13%
     */
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = nums[0];
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(sum, maxSum);
            if(sum <= 0) sum = 0;
        }
        return maxSum;
    }
}
