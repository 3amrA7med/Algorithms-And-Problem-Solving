package com.playground.backtrack.medium;

/**
 * 79. Word Search
 * ===========================
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are
 * horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * ==============================
 * Test Cases:
 *         char[][] board = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
 *         String word = "abcced";
 *         char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
 *         String word = "SEE";
 *         char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
 *         String word = "ABCB";
 *         char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
 *         String word = "AAB";
 *  NOTES:
 *  1- No Dynamic programming for this problem, implementing a class called pair slowed up the execution lead to time
 *     limit exceeds.
 *  2- Using word.substring() took a lot of memory in addition to added latency in the code. so adding a word index solved this.
 *  3- Checking if direction1 returned true, then dir2, etc... => leads to faster runtime.
 */
public class WordSearch {

    public void run(){
        // write your code here
//        char[][] board = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
//        String word = "abcced";
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "SEE";
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCB";

        /*
        C A A
        A A A
        B C D
         */
//        char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
//        String word = "AAB";

        System.out.println(this.existDepthFirstSearch(board, word));
    }

    /**
     * 99ms Beats 97.56%
     * 40.61mb Beats 61.56%
     * @param board board of chars
     * @param word word to find
     * @return if found return true.
     */
    public boolean exist(char[][] board, String word) {
        if(board.length * board[0].length < word.length()) return false;
        char[] wordArr = word.toCharArray();
        for(int r = 0; r < board.length; r++)
            for(int c = 0; c < board[0].length; c++)
                if(existBackTrackRec(board, wordArr, r, c, 0)) return true;
        return false;
    }

    public boolean existBackTrackRec(char[][] board, char[] word, int r, int c, int wordIndex) {
        if(wordIndex >= word.length) return true;
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length) return false;
        if(board[r][c] != word[wordIndex]) return false;

        char temp = board[r][c];
        board[r][c] = '#';
        if(existBackTrackRec(board, word, r + 1, c, wordIndex + 1)) return true;
        if(existBackTrackRec(board, word, r - 1, c, wordIndex + 1)) return true;
        if(existBackTrackRec(board, word, r, c + 1, wordIndex + 1)) return true;
        if(existBackTrackRec(board, word, r, c - 1, wordIndex + 1)) return true;
        board[r][c] = temp;
        return false;
    }

    // ==========================================================================


    /**
     * 115 ms Beats 96.89%
     * 40.5 MB Beats 87.56%
     * @param board
     * @param word
     * @return
     */
    public boolean existDepthFirstSearch(char[][] board, String word) {
        boolean flag = false;
        for(int i = 0; i<  board.length; i++) {
            for(int j = 0; j<  board[0].length; j++) {
                flag |= existRecursion(board, i, j, word, 0);
                if(flag)
                    return true;
            }
        }
        return false;
    }

    private boolean existRecursion(char[][]board, int i, int j, String word, int wordIndex) {
        if(wordIndex == word.length()) { // All the word found.
            return true;
        }
        if(i == board.length || j == board[0].length || i == -1 || j == -1 || word.charAt(wordIndex) != board[i][j]) { // Out of range.
            return false;
        }
        char cache = board[i][j];
        board[i][j] = '#';
        boolean direction1 = this.existRecursion(board, i + 1, j, word, wordIndex + 1);
        if(direction1)
            return true;
        boolean direction2 = this.existRecursion(board, i - 1, j, word,  wordIndex + 1);
        if(direction2)
            return true;
        boolean direction3 = this.existRecursion(board, i, j + 1, word, wordIndex + 1);
        if(direction3)
            return true;
        boolean direction4 = this.existRecursion(board, i, j - 1, word, wordIndex + 1);
        board[i][j] = cache;
        return direction4;
    }
//    private Map<String, Boolean> dp;

//    public boolean existDynamicProgramming(char[][] board, String word) {
//        dp = new HashMap<>();
//        boolean flag = false;
//        for(int i = 0; i<  board.length; i++) {
//            for(int j = 0; j<  board[0].length; j++) {
//                List<Pair<Integer>> path = new ArrayList<>();
//                flag |= existRecursionDp(board, i, j, word, path);
//                if(flag)
//                    return true;
//            }
//        }
//        return false;
//    }
//
//
//    private boolean existRecursionDp(char[][]board, int i, int j, String word, List<Pair<Integer>> path) {
//        if(word.length() == 0) { // All the word found.
//            return true;
//        }
//        if(i == board.length || j == board[0].length || i == -1 || j == -1 || path.contains(new Pair<Integer>(i,j)) || word.charAt(0) != board[i][j]) { // Out of range.
//            return false;
//        }
//        Pair<Integer> p = new Pair<Integer>(i,j);
//        if(dp.get(p.toString()) != null) {
//            return dp.get(p.toString());
//        }
//        path.add(p);
//        boolean direction1 = this.existRecursionDp(board, i + 1, j, word.substring(1, word.length()), path);
//        boolean direction2 = this.existRecursionDp(board, i - 1, j, word.substring(1, word.length()), path);
//        boolean direction3 = this.existRecursionDp(board, i, j + 1, word.substring(1, word.length()), path);
//        boolean direction4 = this.existRecursionDp(board, i, j - 1, word.substring(1, word.length()), path);
//        path.remove(p);
//        boolean result = direction1 || direction2 || direction3 || direction4;
//        dp.put(p.toString(), result);
//        return result;
//    }
}
