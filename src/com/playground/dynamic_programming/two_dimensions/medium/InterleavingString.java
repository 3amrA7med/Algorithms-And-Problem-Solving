package com.playground.dynamic_programming.two_dimensions.medium;

/**
 * 97. Interleaving String
 */
public class InterleavingString {
    // Time limit exceeds :'(
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) return false;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1]; // -1 -> no match, 0 -> not visited, 1-> match.
        boolean[] arr = new boolean[s1.length()];
        return isInterleaveTopDownRec(s1.toCharArray(), s2.toCharArray(), 0, 0, s3.toCharArray(), dp) == 1;
    }

    public int isInterleaveTopDownRec(char[] s1, char[] s2, int s1I, int s2I, char[] s3, int[][] dp) {
        if(s1I >= s1.length && s2I >= s2.length) return 1;
        if(dp[s1I][s2I] != 0) return dp[s1I][s2I];

        if(s1I < s1.length && s2I < s2.length && s1[s1I] == s3[s1I+s2I] && s2[s2I] == s3[s1I+s2I]) dp[s1I][s2I] = Math.max(isInterleaveTopDownRec(s1, s2, s1I+1, s2I, s3, dp),isInterleaveTopDownRec(s1, s2, s1I, s2I+1, s3, dp) );
        else if(s1I < s1.length && s1[s1I] == s3[s1I+s2I]) dp[s1I][s2I] =  isInterleaveTopDownRec(s1, s2, s1I+1, s2I, s3, dp);
        else if(s2I < s2.length && s2[s2I] == s3[s1I+s2I]) dp[s1I][s2I] =  isInterleaveTopDownRec(s1, s2, s1I, s2I+1, s3, dp);

        return dp[s1I][s2I];
    }

    // 95% RUNTIME 40% MEMORY.
    public boolean isInterleave1(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) return false;
        // -1 -> no match, 0 -> not visited, 1-> match.
        return isInterleaveTopDownRec1(s1.toCharArray(), s2.toCharArray(), 0, 0, s3.toCharArray(),  new int[s1.length() + 1][s2.length() + 1]) == 1;
    }

    public int isInterleaveTopDownRec1(char[] s1, char[] s2, int s1I, int s2I, char[] s3, int[][] dp) {
        if(s1I >= s1.length && s2I >= s2.length) return 1;
        if(dp[s1I][s2I] != 0) return dp[s1I][s2I];


        dp[s1I][s2I] = Math.max(
                (s1I < s1.length && s1[s1I] == s3[s1I+s2I])? isInterleaveTopDownRec1(s1, s2, s1I+1, s2I, s3, dp): -1,
                (s2I < s2.length && s2[s2I] == s3[s1I+s2I])? isInterleaveTopDownRec1(s1, s2, s1I, s2I+1, s3, dp): -1
        );

        return dp[s1I][s2I];
    }

    // 95% runtime 98.5% memory.
    public boolean isInterleave2(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) return false;
        return isInterleaveTopDownRec2(s1.toCharArray(), s2.toCharArray(), 0, 0, s3.toCharArray(), new boolean[s1.length() + 1][s2.length() + 1]);
    }

    public boolean isInterleaveTopDownRec2(char[] s1, char[] s2, int s1I, int s2I, char[] s3, boolean[][] invalidDp) {
        if(s1I >= s1.length && s2I >= s2.length) return true;
        if(invalidDp[s1I][s2I]) return false;

        boolean valid =
                (s1I < s1.length && s1[s1I] == s3[s1I+s2I] && isInterleaveTopDownRec2(s1, s2, s1I+1, s2I, s3, invalidDp))
                        ||
                        (s2I < s2.length && s2[s2I] == s3[s1I+s2I] && isInterleaveTopDownRec2(s1, s2, s1I, s2I+1, s3, invalidDp));

        invalidDp[s1I][s2I] = !valid;

        return valid;
    }
}
