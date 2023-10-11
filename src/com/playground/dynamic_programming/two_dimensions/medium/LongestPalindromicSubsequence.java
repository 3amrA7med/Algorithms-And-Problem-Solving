package com.playground.dynamic_programming.two_dimensions.medium;

/**
 * 516. Longest Palindromic Subsequence
 */
public class LongestPalindromicSubsequence {
    Integer[][] dp;
    int lps = 0;

    /**
     * 73ms Beats 44.58%
     * 69.46mb Beats 5.04%
     */
    public int longestPalindromeSubseq(String s) {
        int maxLength = 0;
        char[] sArr = s.toCharArray();
        dp = new Integer[sArr.length][sArr.length];
        for(int i = 0; i < sArr.length; i++){
            lps = Math.max(longestPalindromeSubseqRec(sArr, i, i), lps);
            lps = Math.max(longestPalindromeSubseqRec(sArr, i, i+1), lps);
        }
        return lps;
    }

    public int longestPalindromeSubseqRec(char[] sArr, int l, int r) {
        if(l < 0 || r >= sArr.length) return 0;
        if(dp[l][r] != null) return dp[l][r];

        dp[l][r] = 0;
        if(sArr[l] == sArr[r]) {
            if(l == r) dp[l][r] = 1;
            else dp[l][r] = 2;
            dp[l][r] += longestPalindromeSubseqRec(sArr, l-1, r+1);
        }
        else
            dp[l][r] += Math.max(longestPalindromeSubseqRec(sArr, l-1, r), longestPalindromeSubseqRec(sArr, l, r+1));

        return dp[l][r];
    }
}
