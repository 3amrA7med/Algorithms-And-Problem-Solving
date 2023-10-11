package com.playground.graph.medium.bfs_dfs;

import com.playground.utils.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. Rotting Oranges
 * ====================================
 * You are given an m x n grid where each cell can have one of three values:
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 * ==========================================
 * Example 1:
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 * Input: grid = [[0,2]]
 * Output: 0
 * Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 * ==================================
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] is 0, 1, or 2.
 */
public class RottingOranges {

    static class Pair {
        public int x;
        public int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting3(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int numOfFreshOranges = 0;

        // Add all rotten oranges in the queue.
        for(int r = 0; r < grid.length; r++)
            for(int c = 0; c < grid[r].length; c++)
                if(grid[r][c] == 2) queue.add(new Pair(r,c));
                else if(grid[r][c] == 1) numOfFreshOranges++;

        // BFS
        int minutes = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Pair index = queue.poll();
                numOfFreshOranges+=checkDirection3(grid, index.x - 1, index.y, queue);
                numOfFreshOranges+=checkDirection3(grid, index.x + 1, index.y, queue);
                numOfFreshOranges+=checkDirection3(grid, index.x, index.y - 1, queue);
                numOfFreshOranges+=checkDirection3(grid, index.x, index.y + 1, queue);
            }
            if(!queue.isEmpty()) minutes++;
        }

        return (numOfFreshOranges > 0)? -1:minutes;
    }

    private int checkDirection3(int[][] grid, int r, int c, Queue<Pair> queue) {
        if(r >= 0 && c >= 0 && r < grid.length && c < grid[r].length && grid[r][c] == 1) {
            grid[r][c] = 2;
            queue.add(new Pair(r,c));
            return -1;
        }
        return 0;
    }

    //=======================================

    /**
     * Beats 21.58%, 3ms, a small adjustment can be made to enhance this solution, found in solution 2
     * Beats 96.92%, 40.87 mb
     */
//    public int orangesRotting(int[][] grid) {
//        Deque<Pair<Integer>> queue = new ArrayDeque<>();
//
//        // Add all rotten oranges in the queue.
//        for(int r = 0; r < grid.length; r++)
//            for(int c = 0; c < grid[r].length; c++)
//                if(grid[r][c] == 2) queue.addLast(new Pair<>(r,c));
//
//        // BFS
//        int minutes = 0;
//        while(!queue.isEmpty()) {
//            int size = queue.size();
//            for(int i = 0; i < size; i++) {
//                Pair<Integer> index = queue.removeFirst();
//                checkDirection(grid, index.x - 1, index.y, queue);
//                checkDirection(grid, index.x + 1, index.y, queue);
//                checkDirection(grid, index.x, index.y - 1, queue);
//                checkDirection(grid, index.x, index.y + 1, queue);
//            }
//            if(!queue.isEmpty()) minutes++;
//        }
//
//
//        // Add all rotten oranges in the queue.
//        for(int r = 0; r < grid.length; r++)
//            for(int c = 0; c < grid[r].length; c++)
//                if(grid[r][c] == 1) return -1;
//
//        return minutes;
//    }
//
//    private void checkDirection(int[][] grid, int r, int c, Deque<Pair<Integer>> queue) {
//        if(r >= 0 && c >= 0 && r < grid.length && c < grid[r].length && grid[r][c] == 1) {
//            grid[r][c] = 2;
//            queue.addLast(new Pair<>(r,c));
//        }
//    }
//
//    // ====================================
//
//    /**
//     * Beats 88.88%, 2ms
//     * Memory Beats 62.25%, 41.35
//     * @param grid
//     * @return
//     */
//    public int orangesRotting2(int[][] grid) {
//        Deque<Pair<Integer>> queue = new ArrayDeque<>();
//        int numOfFreshOranges = 0;
//
//        // Add all rotten oranges in the queue.
//        for(int r = 0; r < grid.length; r++)
//            for(int c = 0; c < grid[r].length; c++)
//                if(grid[r][c] == 2) queue.addLast(new Pair<>(r,c));
//                else if(grid[r][c] == 1) numOfFreshOranges++;
//
//        // BFS
//        int minutes = 0;
//        while(!queue.isEmpty()) {
//            int size = queue.size();
//            for(int i = 0; i < size; i++) {
//                Pair<Integer> index = queue.removeFirst();
//                numOfFreshOranges+=checkDirection2(grid, index.x - 1, index.y, queue);
//                numOfFreshOranges+=checkDirection2(grid, index.x + 1, index.y, queue);
//                numOfFreshOranges+=checkDirection2(grid, index.x, index.y - 1, queue);
//                numOfFreshOranges+=checkDirection2(grid, index.x, index.y + 1, queue);
//            }
//            if(!queue.isEmpty()) minutes++;
//        }
//
//        return (numOfFreshOranges > 0)? -1:minutes;
//    }
//
//    private int checkDirection2(int[][] grid, int r, int c, Deque<Pair<Integer>> queue) {
//        if(r >= 0 && c >= 0 && r < grid.length && c < grid[r].length && grid[r][c] == 1) {
//            grid[r][c] = 2;
//            queue.addLast(new Pair<>(r,c));
//            return -1;
//        }
//        return 0;
//    }
}
