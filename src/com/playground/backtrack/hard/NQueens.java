package com.playground.backtrack.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N-Queens
 * ============
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space, respectively.
 * =============
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 */
public class NQueens {

    /**
     * Runtime 6ms
     * Beats 25.84%
     * Memory 44.17MB Beats 31.93%
     */
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        placeQueenRec(n, board, 0);
        return res;
    }

    public void placeQueenRec(int n, char[][] board, int row) {
        if(row == n) {
            res.add(new ArrayList<>(getResultBoard(board)));
            return;
        }

        for(int c = 0; c < n; c++) {
            if(board[row][c] == 'x') continue;
            char[][] newBoard = getMarkedBoard(board, row, c, n);
            newBoard[row][c] = 'Q';
            placeQueenRec(n, newBoard, row+1);
        }
    }

    public List<String> getResultBoard(char[][] board) {
        List<String> res = new ArrayList<>();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'x') board[i][j] = '.';
            }
        }

        for(int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }

    public char[][] getMarkedBoard(char[][] board, int r, int c, int n) {
        char[][] markedBoard = new char[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                markedBoard[i][j] = board[i][j];
            }
        }

        for(int i = 0; i < n; i++) {
            markedBoard[r][i] = 'x';
            markedBoard[i][c] = 'x';
        }

        int diagonalDistance = 1;
        for(int col = c + 1; col < n; col++) {
            if(r - diagonalDistance >=0) markedBoard[r - diagonalDistance][col] = 'x';
            if(r + diagonalDistance < n) markedBoard[r + diagonalDistance][col] = 'x';
            diagonalDistance++;
        }

        diagonalDistance = 1;
        for(int col = c - 1; col >= 0; col--) {
            if(r - diagonalDistance >=0) markedBoard[r - diagonalDistance][col] = 'x';
            if(r + diagonalDistance < n) markedBoard[r + diagonalDistance][col] = 'x';
            diagonalDistance++;
        }

        return markedBoard;
    }
}
