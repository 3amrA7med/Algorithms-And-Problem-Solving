package com.playground.dynamic_programming.one_dimension.medium;

/**
 * 2466. Count Ways To Build Good Strings
 * ======================================
 * Given the integers zero, one, low, and high, we can construct a string by starting with an empty string,
 * and then at each step perform either of the following:
 * Append the character '0' zero times.
 * Append the character '1' one time.
 * This can be performed any number of times.
 * A good string is a string constructed by the above process having a length between low and high (inclusive).
 * Return the number of different good strings that can be constructed satisfying these properties. Since the answer
 * can be large, return it modulo 109 + 7.
 * ===========================================
 * Example 1:
 * Input: low = 3, high = 3, zero = 1, one = 1
 * Output: 8
 * Explanation:
 * One possible valid good string is "011".
 * It can be constructed as follows: "" -> "0" -> "01" -> "011".
 * All binary strings from "000" to "111" are good strings in this example.
 * Example 2:
 * Input: low = 2, high = 3, zero = 1, one = 2
 * Output: 5
 * Explanation: The good strings are "00", "11", "000", "110", and "011".
 * =====================================
 * Constraints:
 * 1 <= low <= high <= 105
 * 1 <= zero, one <= low
 */
public class CountWaysToBuildGoodStrings {
    /**
     * Runtime 7 ms Beats 85.27%
     * Memory 42.7 MB Beats 56.91%
     */
    // [0, 1, 2, 3]
    // [0, 2, 4, 8]

    // [0, 1, 2, 3]   2 + 3
    // [0, 1, 2, 3]   2 + 3 => 5
    int modulo = 1_000_000_007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high+1];

        dp[0] = 1;

        for(int i = 1; i <= high; i++) {
            if(i-zero >= 0) dp[i]+= dp[i-zero];
            if(i-one >= 0) dp[i]+= dp[i-one];
            dp[i]%=modulo;
        }

        int sum = 0;
        for(int i = low; i <= high; i++) {sum+= dp[i]; sum%=modulo;}
        return sum;
    }
}
