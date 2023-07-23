package com.playground.graph.medium;
import java.util.Arrays;

/**
 * 130. Surrounded Regions
 */
public class SurroundedRegions {

    public void run() {
//        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
//        char[][] board = new char[][]{{'O','O','O','O','X','X'},{'O','O','O','O','O','O'},{'O','X','O','X','O','O'},
//                {'O','X','O','O','X','O'},{'O','X','O','X','O','O'},{'O','X','O','O','O','O'}};
        char[][] board = new char[][]{{'X'}};
        this.solve(board);

        System.out.println(Arrays.deepToString(board));
    }

    /**
     * Beats 98.66%, 1ms
     * Memory Beats 44.99%, 44.3, best 43
     * This answer depends on reversing the way we think,
     * We need to capture all regions ? what about finding all regions that won't be captured.
     * @param board
     */
    public void solve(char[][] board) {
        if(board.length == 1 || board[0].length == 1) return;
        // Loop on first and last row
        for(int r = 0; r < board.length; r+= board.length-1)
            for(int c = 0; c < board[r].length; c++)
                if(board[r][c] == 'O') dfs(board, r, c);

        // Loop on first and last row
        for(int r = 0; r < board.length; r++)
            for(int c = 0; c < board[r].length; c+=board[r].length-1)
                if(board[r][c] == 'O') dfs(board, r, c);

        for(int r = 0; r < board.length; r++)
            for(int c = 0; c < board[r].length; c++) {
                if(board[r][c] == 'T') board[r][c] = 'O';
                else board[r][c] = 'X';
            }

    }

    public void dfs(char[][] board, int r, int c) {
        if(r < 0 || c < 0 || r >= board.length || c >= board[r].length) return;
        if(board[r][c] != 'O') return;
        board[r][c] = 'T';

        dfs(board, r - 1, c);
        dfs(board, r + 1, c);
        dfs(board, r, c - 1);
        dfs(board, r, c + 1);
    }

    /*
    Doesn't pass all test cases.
    public void run() {
        Set<Pair<Integer>> test = new HashSet<>();
        Pair<Integer> index = new Pair<>(0,0);
        test.add(index);
        System.out.println(test.contains(new Pair<>(0, 0)));

//        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        char[][] board = new char[][]{{'O','O','O','O','X','X'},{'O','O','O','O','O','O'},{'O','X','O','X','O','O'},
                                        {'O','X','O','O','X','O'},{'O','X','O','X','O','O'},{'O','X','O','O','O','O'}};
        this.solve(board);

        System.out.println(Arrays.deepToString(board));
    }
    Set<Pair<Integer>> visited = new HashSet<>();
    Set<Pair<Integer>> visitedOverall = new HashSet<>();

    public void solve(char[][] board) {
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[r].length; c++) {
                Pair<Integer> index = new Pair<>(r,c);
                if(board[r][c] == 'X' || visitedOverall.contains(index)) continue;
                dfsCaptureRegion(board, r, c);
                visitedOverall.addAll(visited);
                visited.clear();
            }
        }
    }

    public boolean dfsCaptureRegion(char[][] board, int r, int c) {
        if(r < 0 || c < 0 || r >= board.length || c >= board[r].length) return false;
        if(board[r][c] == 'X') return true;
        Pair<Integer> index = new Pair<>(r,c);
        if(visited.contains(index)) return true;
        visited.add(index);

        boolean capturedFlag = dfsCaptureRegion(board, r - 1, c) &&
                dfsCaptureRegion(board, r + 1, c) &&
                dfsCaptureRegion(board, r, c - 1) &&
                dfsCaptureRegion(board, r, c + 1);

        if(!capturedFlag) return false;
        board[r][c] = 'X';
        return true;
    }

     */

}
