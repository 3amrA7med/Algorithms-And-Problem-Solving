package com.playground.graph.medium.bfs_dfs;

/**
 * 200. Number of Islands
 * =======================================
 *  Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * ===========================
 * Example 1:
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 * =================================
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands {

    /**
     * Runtime 3 ms Beats 71.19%
     * Memory 47.4 MB Beats 66.16%
     */
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;

        for(int i =0; i < grid.length; i++) {
            for(int j = 0; j  < grid[i].length; j++) {
                char currentChar = grid[i][j];
                if(currentChar != '1') continue;
                numOfIslands++;
                markAllIslandValues(grid, i , j);
            }
        }

        return numOfIslands;
    }

    private void markAllIslandValues(char[][] grid, int i, int j){
        if(i< 0 || i >= grid.length || j < 0 || j >= grid[i].length) return;
        if(grid[i][j] != '1') return;

        grid[i][j] = '2';
        markAllIslandValues(grid, i - 1 , j);
        markAllIslandValues(grid, i + 1 , j);
        markAllIslandValues(grid, i , j - 1);
        markAllIslandValues(grid, i , j + 1);
    }
}
