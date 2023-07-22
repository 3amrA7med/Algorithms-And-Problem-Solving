package com.playground.graph.medium;

/**
 * 695. Max Area of Island
 * Beats 100% 2ms
 * Bests 95% 43.08mb
 */
public class MaxAreaOfIsland {

    /**
     * If we don't want to modify the grid values we can do 2 solutions
     *      - Make all "2" => "1" again
     *      - Save set of visited nodes (i, j)
     * @param grid
     * @return
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
