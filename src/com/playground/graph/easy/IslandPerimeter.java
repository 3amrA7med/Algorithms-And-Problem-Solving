package com.playground.graph.easy;

/**
 * 463. Island Perimeter
 * =====================
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
 * and there is exactly one island (i.e., one or more connected land cells).
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island.
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 * ===================
 * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * Output: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image above.
 */
public class IslandPerimeter {
    /**
     * Runtime 4ms Beats 100.00%
     * Memory 43.86MB Beats 76.41%
     */
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int rowsCount = grid.length;
        int colsCount = grid[0].length;
        for(int r = 0; r < rowsCount; r++) {
            for(int c = 0; c < colsCount; c++) {
                if(grid[r][c] == 0) continue;

                if(r-1 < 0 || grid[r-1][c] == 0) perimeter++;
                if(r+1 >= rowsCount || grid[r+1][c] == 0) perimeter++;
                if(c-1 < 0 || grid[r][c-1] == 0) perimeter++;
                if(c+1 >= colsCount || grid[r][c+1] == 0) perimeter++;
            }
        }
        return perimeter;
    }
}
