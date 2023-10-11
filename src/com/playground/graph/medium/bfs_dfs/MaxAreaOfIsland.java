package com.playground.graph.medium.bfs_dfs;

/**
 * 695. Max Area of Island
 * ===================================
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally
 * (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * The area of an island is the number of cells with a value 1 on the island.
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * ===================================
 * Example 1:
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 *
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 * Beats 100% 2ms
 * Bests 95% 43.08mb
 */
public class MaxAreaOfIsland {

    /**
     * If we don't want to modify the grid values we can do 2 solutions
     *      - Make all "2" => "1" again
     *      - Save set of visited nodes (i, j)
     * Beats 100% 2ms
     * Bests 95% 43.08mb
     */
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int maxArea = Integer.MIN_VALUE;
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(grid[r][c] != 1) continue;
                int islandArea = dfsArea(grid, r, c);
                if(islandArea > maxArea) maxArea = islandArea;
            }
        }
        return (maxArea == Integer.MIN_VALUE)? 0: maxArea;
    }

    private int dfsArea(int[][] grid, int r, int c) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 1) return 0;
        grid[r][c] = 2;

        return dfsArea(grid, r - 1, c) + dfsArea(grid, r + 1, c) + dfsArea(grid, r, c - 1) + dfsArea(grid, r, c + 1) + 1;
    }
}
