package com.playground.dynamic_programming.two_dimensions.medium;

/**
 * 926. Flip String to Monotone Increasing
 * ===================================
 * A binary string is monotone increasing if it consists of some number of 0's (possibly none),
 * followed by some number of 1's (also possibly none).
 * You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.
 * Return the minimum number of flips to make s monotone increasing.
 * =========================================
 * Example 1:
 * Input: s = "00110"
 * Output: 1
 * Explanation: We flip the last digit to get 00111.
 * Example 2:
 * Input: s = "010110"
 * Output: 2
 * Explanation: We flip to get 011111, or alternatively 000111.
 */
public class FlipStringToMonotoneIncreasing {

    /**
     * Runtime 7ms Beats 98.72%
     * Memory 44.09MB Beats 82.52%
     */
    public int minFlipsMonoIncr2(String s) {
        if(s.length() == 1) return 0;
        int zeroFlips = 0;
        int oneFlips = 1;

        for(char c: s.toCharArray()) {
            if(c == '0') oneFlips = Math.min(zeroFlips, oneFlips) + 1;
            else {
                oneFlips = Math.min(zeroFlips, oneFlips);
                zeroFlips++;
            }
        }

        return Math.min(zeroFlips, oneFlips);
    }

    /**
     * Runtime 80ms Beats 11.30%
     * Memory 81.70MB Beats 5.12%
     */
    public int minFlipsMonoIncr(String s) {
        if(s.length() == 1) return 0;
        char[] sArr = s.toCharArray();
        Integer[][] dp = new Integer[sArr.length][2];
        return minFlipsMonoIncrDp(dp, sArr, 0, true, 0);
    }

    public int minFlipsMonoIncrDp(Integer[][] dp, char[] s, int index, boolean isZero, int typeIndex) {
        if(index == s.length) return 0;
        if(dp[index][typeIndex] != null) return dp[index][typeIndex];

        if(isZero && s[index] == '0')
            dp[index][typeIndex] = Math.min(minFlipsMonoIncrDp(dp, s, index + 1, true, 0), 1 + minFlipsMonoIncrDp(dp, s, index + 1, false, 1));
        else if(isZero && s[index] == '1')
            dp[index][typeIndex] = Math.min(minFlipsMonoIncrDp(dp, s, index + 1, true, 0) + 1, minFlipsMonoIncrDp(dp, s, index + 1, false, 1));
        else if(!isZero && s[index] == '0')
            dp[index][typeIndex] = minFlipsMonoIncrDp(dp, s, index + 1, false, 1) + 1;
        else
            dp[index][typeIndex] = minFlipsMonoIncrDp(dp, s, index + 1, false, 1);

        return dp[index][typeIndex];
    }
}
