package com.playground.dynamic_programming.two_dimensions.medium;

/**
 * 64. Minimum Path Sum
 */
public class MinimumPathSum {

    Integer[][] dp;

    /**
     * 1ms Beats 98.82%
     * 43.88mb Beats 72.17%
     */
    public int minPathSum(int[][] grid) {
        dp = new Integer[grid.length][grid[0].length];
        return minPathSumTopDown(grid, 0, 0);
    }

    public int minPathSumTopDown(int[][] grid, int row, int col) {
        if(row == grid.length - 1 && col == grid[0].length - 1) return grid[row][col];
        if(row >= grid.length || col >= grid[0].length) return Integer.MAX_VALUE;
        if(dp[row][col] != null) return dp[row][col];

        dp[row][col] = Math.min(minPathSumTopDown(grid, row + 1, col), minPathSumTopDown(grid, row, col + 1));
        if(dp[row][col] != Integer.MAX_VALUE) dp[row][col]+= grid[row][col];
        return dp[row][col];
    }
}
