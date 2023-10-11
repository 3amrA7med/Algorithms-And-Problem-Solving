package com.playground.dynamic_programming.medium;

/**
 * 377. Combination Sum IV
 * =====================
 * Given an array of distinct integers nums and a target integer target,
 * return the number of possible combinations that add up to target.
 * The test cases are generated so that the answer can fit in a 32-bit integer.
 * ===============================
 * Example 1:
 * Input: nums = [1,2,3], target = 4
 * Output: 7
 * Explanation:
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * Note that different sequences are counted as different combinations.
 * =======================
 * Questions
 * -ve values?
 * no answer ? 0
 * 1 2 1 == 1 1 2?
 */
public class CombinationSum4 {

    public int combinationSum4BotUp(int[] nums, int target) {
        int[] dp = new int[target + 1];

        dp[0] = 1;

        for(int i = 1; i <= target; i++) {
            for(int num: nums) {
                if(i - num >= 0) dp[i] += dp[i-num];
            }
        }

        return dp[target];
    }

    Integer[][] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new Integer[nums.length + 1][target + 1];
        return combinationSum4Rec(nums, target, 0, 0);
    }


    public int combinationSum4Rec(int[] nums, int target, int index, int sum) {
        if(sum == target) return 1;
        if(index == nums.length) return 0;
        if(dp[index][sum] != null) return dp[index][sum];

        dp[index][sum] = 0;
        for(int i = 0; i < nums.length; i++) {
            if(sum+nums[i] <= target)
                dp[index][sum] += combinationSum4Rec(nums, target, i, sum+nums[i]);
        }

        return dp[index][sum];
    }
}
