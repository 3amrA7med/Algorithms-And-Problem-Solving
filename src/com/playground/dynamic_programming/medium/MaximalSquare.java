package com.playground.dynamic_programming.medium;

/**
 * 221. Maximal Square
 * ===================
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * ==========
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 4
 * =================
 * matrix =
 * [["1","1","1","1","1","1","1","1"],
 * ["1","1","1","1","1","1","1","0"],
 * ["1","1","1","1","1","1","1","0"],
 * ["1","1","1","1","1","0","0","0"],
 * ["0","1","1","1","1","0","0","0"]]

 * Expected
 * 16
 */
public class MaximalSquare {

    public void run() {
        System.out.println(this.maximalSquare(new char[][] {{'1','1','1','1','1','1','1','1'}, {'1','1','1','1','1','1','1','0'},
                            {'1','1','1','1','1','1','1','0'}, {'1','1','1','1','1','0','0','0'}, {'0','1','1','1','1','0','0','0'}}));
    }

    //===============================
    /**
     * More efficient
     * Runtime 7ms Beats 79.07%
     * Memory 53.87MB Beats 76.92%
     */
    public int maximalSquare1(char[][] matrix) {
        int rowsCount = matrix.length;
        int colsCount = matrix[0].length;
        int[][] dp = new int[rowsCount + 1][colsCount + 1];
        int maxLength = 0;

        for(int r = rowsCount - 1; r >= 0; r--) {
            for(int c = colsCount - 1; c >= 0; c--) {
                if(matrix[r][c] == '0') continue;
                dp[r][c] = Math.min(dp[r+1][c+1], Math.min(dp[r+1][c], dp[r][c+1])) + 1;
                maxLength = Math.max(maxLength, dp[r][c]);
            }
        }

        return maxLength * maxLength;
    }

    /**
     * Runtime 56ms Beats 10.10%
     * Memory 53.72MB Beats 83.67%
     */
    public int maximalSquare(char[][] matrix) {
        int rowsCount = matrix.length;
        int colsCount = matrix[0].length;
        int[][] dp = new int[rowsCount + 1][colsCount + 1];
        int maxSize = 0;

        for(int r = rowsCount - 1; r >= 0; r--) {
            for(int c = colsCount - 1; c >= 0; c--) {
                if(matrix[r][c] == '0') continue;

                int squareLength = 1;
                int maxSquareSize = dp[r+1][c+1];
                for(int i = 1; i <= Math.sqrt(maxSquareSize); i++) {
                    if(r+i >= rowsCount || c+i >= colsCount || matrix[r][c+i] == '0' || matrix[r+i][c] == '0') break;
                    squareLength++;
                }

                dp[r][c] = squareLength * squareLength;
                maxSize = Math.max(maxSize, dp[r][c]);
            }
        }

        return maxSize;
    }


}
