package com.playground.dynamic_programming.one_dimension.medium;

/**
 * 279. Perfect Squares
 * ==================
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 * A perfect square is an integer that is the square of an integer; in other words, it is the product
 * of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 * ===================================
 * Example 1:
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 */
public class PerfectSquares {

    /**
     * Runtime 30ms
     * Beats 72.41%
     * Memory 41.95MB Beats 86.92%
     */
    public int numSquaresBotUp(int n) {
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;
        for(int i = 1; i <= n; i++) {
            dp[i] = i;
            for(int j = 1; j*j <= i; j++) {
                if(i - j*j >= 0) dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }

        return dp[n];
    }

    /**
     * Runtime 98ms Beats 20.80%
     * Memory 43.80MB Beats 17.47%
     */
    Integer[] dp;
    public int numSquaresTop(int n) {
        dp = new Integer[n+1];
        return numSquaresTopDown(n);
    }

    public int numSquaresTopDown(int n) {
        if(n == 0) return 0;
        if(dp[n] != null) return dp[n];

        dp[n] = n;
        for(int j = 1; j*j <= n; j++) {
            if(n - j*j >= 0) dp[n] = Math.min(dp[n], numSquaresTopDown(n - j*j) + 1);
        }

        return dp[n];
    }
}
