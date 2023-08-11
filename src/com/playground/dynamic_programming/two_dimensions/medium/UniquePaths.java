package com.playground.dynamic_programming.two_dimensions.medium;

import java.util.Arrays;

/**
 * 62. Unique Paths
 */
public class UniquePaths {
    // 100%
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1);
        return uniquePathsRec(0,0,m,n,dp);
    }

    private int uniquePathsRec(int r, int c, int m, int n, int[][] dp) {
        if(r == m-1 && c == n-1) return 1;
        if(r < 0 || r >= m || c < 0 || c >= n) return 0;
        if(dp[r][c] != -1) return dp[r][c];

        int result = 0;
        result += uniquePathsRec(r + 1, c, m, n, dp);
        result += uniquePathsRec(r, c + 1, m, n, dp);

        dp[r][c] = result;

        return result;
    }


        public int uniquePathsBottomUp(int m, int n) {
        int[][] dp = new int[m][n];

        for(int r = m - 1; r >= 0; r--) {
            for(int c = n - 1; c >= 0; c--) {
                int dir1 = (c+1 >= n)? 0: dp[r][c+1];
                int dir2 = (r+1 >= m)? 0: dp[r+1][c];
                dp[r][c] = dir1 + dir2;
                if(r == m-1 && c == n-1) dp[m-1][n-1] = 1;
            }

        }

        return dp[0][0];
    }
}
