package com.playground.dynamic_programming.one_dimension.medium;

/**
 * 343. Integer Break
 * ========================================
 * Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
 * Return the maximum product you can get.
 * =============================================
 * Example 1:
 * Input: n = 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * Example 2:
 * Input: n = 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * ====================================
 * Constraints:
 * 2 <= n <= 58
 */
public class IntegerBreak {
    /**
     * 2   1
     * 3   2
     * 4   4
     * 5   6
     * 6   9
     * 7   12
     * Runtime 1 ms Beats 61.46%
     * Memory 39.2 MB Beats 39.77%
     */
    final static int MAX_N = 58;
    public int integerBreak(int n) {
        int [] dp = new int[MAX_N + 1];

        dp[2] = 1;

        for(int num = 3; num <= n; num++) {
            dp[num] = 1;
            for(int i = 1; i <= num/2; i++) {
                dp[num] = Math.max(dp[num], Math.max(i * dp[num - i], i * (num - i)));
            }
        }

        return dp[n];
    }
}
