package com.playground.graph.medium;

import com.playground.utils.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 994. Rotting Oranges
 */
public class RottingOranges {

    /**
     * Beats 21.58%, 3ms, a small adjustment can be made to enhance this solution, found in solution 2
     * Beats 96.92%, 40.87 mb
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        Deque<Pair<Integer>> queue = new ArrayDeque<>();

        // Add all rotten oranges in the queue.
        for(int r = 0; r < grid.length; r++)
            for(int c = 0; c < grid[r].length; c++)
                if(grid[r][c] == 2) queue.addLast(new Pair<>(r,c));

        // BFS
        int minutes = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Pair<Integer> index = queue.removeFirst();
                checkDirection(grid, index.x - 1, index.y, queue);
                checkDirection(grid, index.x + 1, index.y, queue);
                checkDirection(grid, index.x, index.y - 1, queue);
                checkDirection(grid, index.x, index.y + 1, queue);
            }
            if(!queue.isEmpty()) minutes++;
        }


        // Add all rotten oranges in the queue.
        for(int r = 0; r < grid.length; r++)
            for(int c = 0; c < grid[r].length; c++)
                if(grid[r][c] == 1) return -1;

        return minutes;
    }

    private void checkDirection(int[][] grid, int r, int c, Deque<Pair<Integer>> queue) {
        if(r >= 0 && c >= 0 && r < grid.length && c < grid[r].length && grid[r][c] == 1) {
            grid[r][c] = 2;
            queue.addLast(new Pair<>(r,c));
        }
    }

    // ====================================

    /**
     * Beats 88.88%, 2ms
     * Memory Beats 62.25%, 41.35
     * @param grid
     * @return
     */
    public int orangesRotting2(int[][] grid) {
        Deque<Pair<Integer>> queue = new ArrayDeque<>();
        int numOfFreshOranges = 0;

        // Add all rotten oranges in the queue.
        for(int r = 0; r < grid.length; r++)
            for(int c = 0; c < grid[r].length; c++)
                if(grid[r][c] == 2) queue.addLast(new Pair<>(r,c));
                else if(grid[r][c] == 1) numOfFreshOranges++;

        // BFS
        int minutes = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Pair<Integer> index = queue.removeFirst();
                numOfFreshOranges+=checkDirection2(grid, index.x - 1, index.y, queue);
                numOfFreshOranges+=checkDirection2(grid, index.x + 1, index.y, queue);
                numOfFreshOranges+=checkDirection2(grid, index.x, index.y - 1, queue);
                numOfFreshOranges+=checkDirection2(grid, index.x, index.y + 1, queue);
            }
            if(!queue.isEmpty()) minutes++;
        }

        return (numOfFreshOranges > 0)? -1:minutes;
    }

    private int checkDirection2(int[][] grid, int r, int c, Deque<Pair<Integer>> queue) {
        if(r >= 0 && c >= 0 && r < grid.length && c < grid[r].length && grid[r][c] == 1) {
            grid[r][c] = 2;
            queue.addLast(new Pair<>(r,c));
            return -1;
        }
        return 0;
    }
}
