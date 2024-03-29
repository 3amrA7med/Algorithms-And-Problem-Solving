package com.playground.dynamic_programming.one_dimension.medium;

/**
 * 198. House Robber
 * ========================
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems
 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you
 * can rob tonight without alerting the police.
 * =================================================
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * =====================================
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
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
