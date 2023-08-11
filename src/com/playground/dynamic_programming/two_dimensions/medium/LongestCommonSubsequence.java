package com.playground.dynamic_programming.two_dimensions.medium;

import java.util.Arrays;

/**
 * 1143. Longest Common Subsequence
 */
public class LongestCommonSubsequence {
     // 50%
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i = 0; i < text1.length(); i++ ) Arrays.fill(dp[i], -1);
        return longestCommonSubsequenceRec(text1.toCharArray(),text2.toCharArray(), 0, 0, dp);
    }

    public int longestCommonSubsequenceRec(char[] text1, char[] text2, int i1, int i2, int[][] dp) {
        if(i1 >= text1.length || i2 >= text2.length) return 0;
        if(dp[i1][i2] != -1) return dp[i1][i2];

        if(text1[i1] == text2[i2]) dp[i1][i2] = longestCommonSubsequenceRec(text1,text2, i1+1, i2+1, dp) + 1;
        else {
            int dir1 = longestCommonSubsequenceRec(text1,text2, i1+1, i2, dp);
            int dir2 = longestCommonSubsequenceRec(text1,text2, i1, i2+1, dp);
            dp[i1][i2] = Math.max(dir1, dir2);
        }
        return dp[i1][i2];
    }



    // 73.88%
    public int longestCommonSubsequenceBottomUp(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for(int r = text1.length() - 1; r >= 0; r--)
            for(int c = text2.length() - 1; c >= 0; c--)
                if(text1.charAt(r) == text2.charAt(c)) dp[r][c] = 1 + dp[r+1][c+1];
                else dp[r][c] = Math.max(dp[r+1][c], dp[r][c+1]);

        return dp[0][0];
    }
}
