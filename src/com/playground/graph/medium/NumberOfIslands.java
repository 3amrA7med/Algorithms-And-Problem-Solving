package com.playground.graph.medium;

/**
 *  200. Number of Islands
 */
public class NumberOfIslands {

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
