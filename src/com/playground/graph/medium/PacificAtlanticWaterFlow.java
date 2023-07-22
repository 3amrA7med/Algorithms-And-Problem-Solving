package com.playground.graph.medium;

import java.util.*;

/**
 * 417. Pacific Atlantic Water Flow
 */
public class PacificAtlanticWaterFlow {
       public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        for(int i = 0; i < cols; i++) {
            dfs(0, i, pac, heights[0][i], heights);
            dfs(rows-1, i, atl, heights[rows-1][i], heights);
        }

        for(int i = 0; i < rows; i++) {
            dfs(i, 0, pac, heights[i][0], heights);
            dfs(i, cols-1, atl, heights[i][cols-1], heights);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++)
                if(pac[r][c]&&atl[r][c])
                    result.add(Arrays.asList(r,c));

        }

        return result;
    }

    private void dfs(int row, int col, boolean[][] visited, int prevHeight, int[][]heights) {
        if(row < 0 || col < 0 || row >= heights.length || col >= heights[0].length
        || heights[row][col] < prevHeight
        || visited[row][col])
            return;

        visited[row][col] = true;

        dfs(row, col + 1, visited, heights[row][col], heights);
        dfs(row, col - 1, visited, heights[row][col], heights);
        dfs(row + 1, col, visited, heights[row][col], heights);
        dfs(row - 1, col, visited, heights[row][col], heights);
    }

}
