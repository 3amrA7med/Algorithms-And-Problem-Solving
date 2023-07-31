package com.playground.array_101.array_neetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 36. Valid Sudoku
 */
public class ValidSudoku {

    /**
     * 2ms Beats 86.20%, best 1ms
     * 43.60mb Beats 54.95%, best 41
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Set<Character>[] rows = new HashSet[m];
        Set<Character>[] cols = new HashSet[n];
        Set<Character>[][] boxes = new HashSet[m/3][n/3];

        // Check rows, cols, and boxes
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++) {
                if(board[r][c] == '.') continue;
                // Rows
                if(rows[r] == null) rows[r] = new HashSet<>();
                if(rows[r].contains(board[r][c])) return false;
                rows[r].add(board[r][c]);
                // Cols
                if(cols[c] == null) cols[c] = new HashSet<>();
                if(cols[c].contains(board[r][c])) return false;
                cols[c].add(board[r][c]);
                // Box
                if(boxes[r/3][c/3] == null) boxes[r/3][c/3] = new HashSet<>();
                if(boxes[r/3][c/3].contains(board[r][c])) return false;
                boxes[r/3][c/3].add(board[r][c]);
            }
        }

        return true;
    }
}
