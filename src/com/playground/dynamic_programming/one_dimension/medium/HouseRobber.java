package com.playground.dynamic_programming.one_dimension.medium;

/**
  *  198. House Robber
 */
public class HouseRobber {

// 100%
public int rob(int[] nums) {

        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);


        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];

        for(int i =3; i < nums.length; i++)
            dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);

        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }

    // Neetcode, O(1) Memory
    public int rob2(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;

        for(int val: nums) {
            int temp = Math.max(rob1 + val, rob2);
            rob1 = rob2;
            rob2 = val;
        }
        return rob2;
    }
}
