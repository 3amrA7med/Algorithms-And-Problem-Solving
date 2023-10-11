package com.playground.dynamic_programming.two_dimensions.medium;

/**
 * 1911. Maximum Alternating Subsequence Sum
 * =========================
 * The alternating sum of a 0-indexed array is defined as the sum of the elements at even indices
 * minus the sum of the elements at odd indices.
 * For example, the alternating sum of [4,2,5,3] is (4 + 5) - (2 + 3) = 4.
 * Given an array nums, return the maximum alternating sum of any subsequence of nums
 * (after reindexing the elements of the subsequence).
 * A subsequence of an array is a new array generated from the original array by deleting
 * some elements (possibly none) without changing the remaining elements' relative order.
 * For example, [2,7,4] is a subsequence of [4,2,3,7,2,1,4] (the underlined elements), while [2,4,2] is not.
 * =========================
 * Example 1:
 * Input: nums = [4,2,5,3]
 * Output: 7
 * Explanation: It is optimal to choose the subsequence [4,2,5] with alternating sum (4 + 5) - 2 = 7.
 */
public class MaximumAlternatingSubsequenceSum {



    public void run() {
        System.out.println(this.maxAlternatingSum2(new int[] {4,2,5,3}));
    }

    /**
     * Runtime 6ms Beats 84.73%
     * Memory 57.12MB Beats 75.22%
     */
    public long maxAlternatingSum(int[] nums) {
        long sumEven = 0L;
        long sumOdd = 0L;
        long tempEven;
        long tempOdd;

        for (int num : nums) {
            tempEven = Math.max(sumOdd + num, sumEven);
            tempOdd = Math.max(sumEven - num, sumOdd);

            sumEven = tempEven;
            sumOdd = tempOdd;
        }

        return sumEven;
    }


    /**
     * ==========================
     * Runtime 83ms Beats 13.54%
     * Memory 83.08MB Beats 8.64%
     */
    final static int NUMBER_OF_OPERATIONS = 2;
    Long[][] dp;
    public long maxAlternatingSum2(int[] nums) {
        dp = new Long[nums.length][NUMBER_OF_OPERATIONS];
        return maxAlternatingSumRec(nums, 0, true);
    }

    public long maxAlternatingSumRec(int[] nums, int index, boolean isAdd) {
        if(index == nums.length) return 0;
        int operationIndex = (isAdd)? 0 : 1;
        if(dp[index][operationIndex] != null) return dp[index][operationIndex];

        int num = (isAdd)? nums[index]: -1*nums[index];

        dp[index][operationIndex] = Math.max(maxAlternatingSumRec(nums, index + 1, !isAdd) + num, maxAlternatingSumRec(nums, index + 1, isAdd));
        return dp[index][operationIndex];
    }
}
