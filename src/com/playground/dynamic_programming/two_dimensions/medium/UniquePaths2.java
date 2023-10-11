package com.playground.dynamic_programming.two_dimensions.medium;

/**
 * 63. Unique Paths II
 */
public class UniquePaths2 {
    Integer[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dp = new Integer[obstacleGrid.length][obstacleGrid[0].length];
        return uniquePathsWithObstaclesTopDown(obstacleGrid, 0, 0);
    }

    /**
     * -ms Beats 100.00%
     * 40.52mb Beats 73.18%
     */
    public int uniquePathsWithObstaclesTopDown(int[][] obstacleGrid, int r, int c) {
        if(r >= obstacleGrid.length || c >= obstacleGrid[r].length) return 0;
        if(dp[r][c] != null) return dp[r][c];

        if(obstacleGrid[r][c] == 1) dp[r][c] = 0;
        else if(r == obstacleGrid.length - 1 && c == obstacleGrid[r].length - 1) return 1;
        else dp[r][c] = uniquePathsWithObstaclesTopDown(obstacleGrid, r + 1, c) + uniquePathsWithObstaclesTopDown(obstacleGrid, r, c + 1);

        return dp[r][c];
    }
}
