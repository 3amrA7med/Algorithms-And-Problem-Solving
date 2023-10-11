package com.playground.graph.medium.bfs_dfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 909. Snakes and Ladders
 * =======================
 * You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style
 * starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.
 * You start on square 1 of the board. In each move, starting from square curr, do the following:
 * Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
 * This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations,
 * regardless of the size of the board. If next has a snake or ladder, you must move to the destination of that
 * snake or ladder. Otherwise, you move to next. The game ends when you reach the square n2.
 * A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of
 * that snake or ladder is board[r][c]. Squares 1 and n2 do not have a snake or ladder.
 * Note that you only take a snake or ladder at most once per move. If the destination to a snake or
 * ladder is the start of another snake or ladder, you do not follow the subsequent snake or ladder.
 * For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2.
 * You follow the ladder to square 3, but do not follow the subsequent ladder to 4.
 * Return the least number of moves required to reach the square n2. If it is not possible to reach the square, return -1.
 * =================================
 * Example 1:
 * Input: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
 * {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},
 *                         {-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}}
 * Output: 4
 * Explanation:
 * In the beginning, you start at square 1 (at row 5, column 0).
 * You decide to move to square 2 and must take the ladder to square 15.
 * You then decide to move to square 17 and must take the snake to square 13.
 * You then decide to move to square 14 and must take the ladder to square 35.
 * You then decide to move to square 36, ending the game.
 * This is the lowest possible number of moves to reach the last square, so return 4.
 * Example 2:
 * Input: board = [[-1,-1],[-1,3]]
 * Output: 1
 * =======================================
 * Constraints:
 * n == board.length == board[i].length
 * 2 <= n <= 20
 * board[i][j] is either -1 or in the range [1, n2].
 * The squares labeled 1 and n2 do not have any ladders or snakes.
 */
public class SnakesAndLadders {

    public void run() {
        System.out.println(this.snakesAndLadders(new int [][]{{-1,-1,19,10,-1},{2,-1,-1,6,-1},
                {-1,17,-1,19,-1},{25,-1,20,-1,-1},{-1,-1,-1,-1,15}}));
    }

    /**
     * Runtime 7 ms Beats 54.78%
     * Memory 43.4 MB Beats 60.58%
     */

    static class Cell {
        int number;
        int moves;

        Cell(int n, int m) {
            this.number = n;
            this.moves = m;
        }
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        Set<Integer> visitedCells = new HashSet<>();

        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(1, 0));

        while(!queue.isEmpty()) {
            Cell cell = queue.poll();
            boolean noLadderOrSnakes = true;
            for(int i = cell.number + 1; i <= Math.min(cell.number + 6, n*m); i++) {
                int nextNum = i;
                int[] index = getIndex(nextNum, n, m);

                if(board[index[0]][index[1]] != -1)
                {nextNum = board[index[0]][index[1]];}
                if(nextNum == n*m) return cell.moves + 1;
                if(!visitedCells.contains(nextNum)) {
                    visitedCells.add(nextNum);
                    queue.add(new Cell(nextNum, cell.moves + 1));
                }
            }
        }

        return -1;
    }


    public int[] getIndex(int number, int n, int m) {
        int row = (number - 1) / n;
        int col = (number-1) % m;
        if(row % 2 == 1) col = m - col - 1;
        row = n - 1 - row;
        return new int[] {row, col};
    }

    /**
     * Wrong answer as I interpreted the question wrong.
     */
    public int snakesAndLaddersXX(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        Set<Integer> visitedCells = new HashSet<>();

        int number = 1;
        int moves = 0;
        while(number != n*m && !visitedCells.contains(number)) {
            moves++;
            visitedCells.add(number);
            number = getNextNumber(board, number, n, m);
            if(number == n*m) return moves;
        }

        return -1;
    }

    public int getNextNumber(int[][] board, int currNumber, int n, int m) {
        if(currNumber + 6 >= n*m) return n*m;
        int maxNumber = currNumber + 6;
        int num;
        int ladderOrSnake = -1;
        for(num = currNumber + 1; num < maxNumber; num++) {
            int[] index = getIndex(num, n, m);
            if(board[index[0]][index[1]] != -1) {
                if(ladderOrSnake == -1 || board[index[0]][index[1]] == n*m)
                    ladderOrSnake = board[index[0]][index[1]];
            }
        }
        return (ladderOrSnake == -1)? num: ladderOrSnake;
    }
}
