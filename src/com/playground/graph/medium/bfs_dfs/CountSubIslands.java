package com.playground.graph.medium.bfs_dfs;

/**
 * 1905. Count Sub Islands
 * ========================
 * You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water)
 * and 1's (representing land). An island is a group of 1's connected 4-directionally (horizontal or vertical).
 * Any cells outside the grid are considered water cells.
 * An island in grid2 is considered a sub-island if there is an island in grid1 that contains
 * all the cells that make up this island in grid2.
 * Return the number of islands in grid2 that are considered sub-islands.
 * =========================
 * Input: grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]],
 *        grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
 * Output: 3
 * Explanation: In the picture above, the grid on the left is grid1 and the grid on the right is grid2.
 * The 1s colored red in grid2 are those considered to be part of a sub-island. There are three sub-islands.
 */
public class CountSubIslands {

    public void run() {
        System.out.println(
                this.countSubIslands(new int[][]{{1,0,1,0,1},{1,1,1,1,1},{0,0,0,0,0},{1,1,1,1,1},{1,0,1,0,1}},
                                     new int[][]{{0,0,0,0,0},{1,1,1,1,1},{0,1,0,1,0},{0,1,0,1,0},{1,0,0,0,1}}));
    }

    /**
     * Runtime  20ms Beats 63.35%
     * Memory 79.53MB Beats 55.16%
     */
    public int countSubIslands(int[][] grid1, int[][] grid2) {

        int numOfSubIslands = 0;
        for(int row = 0; row < grid2.length; row++) {
            for(int col = 0; col < grid2[0].length; col++) {
                if(grid2[row][col] != 1) continue;
                if(dfs(grid1, grid2, row, col)) numOfSubIslands++;
            }
        }
        return numOfSubIslands;
    }

    public boolean dfs(int[][] grid1, int[][] grid2, int r, int c) {
        if(r < 0 || c < 0 || r >= grid1.length || c >= grid1[0].length || grid2[r][c] != 1) return true;

        grid2[r][c] = 2;
        boolean res = grid1[r][c] == 1;

        res = dfs(grid1, grid2, r + 1, c) && res;
        res = dfs(grid1, grid2, r - 1, c) && res;
        res = dfs(grid1, grid2, r, c + 1) && res;
        res = dfs(grid1, grid2, r, c - 1) && res;

        return res;
    }
}
