package com.playground.dynamic_programming.medium;

/**
 * 877. Stone Game
 * Actually can be solved in O(1) - > return true (-ms Beats 100.00%)
 */
public class StoneGame {
    Integer[][] dp;

    /**
     * 1ms Beats 47.92%
     * 46.12mb Beats 11.58%
     */
    public boolean stoneGame(int[] piles) {
        if(piles.length == 2) return true;
        dp = new Integer[piles.length][piles.length];
        return stoneGameRec(piles, 0, 0, 0) > 0;
    }

    public int stoneGameRec(int[] piles, int start, int end, int turn) {
        if(end < start) return 0;
        if(dp[start][end] != null) return dp[start][end];

        // Alice turn
        if(turn == 0) {
            dp[start][end] = Math.max(stoneGameRec(piles, start + 1, end, 1-turn) + piles[start],
                    stoneGameRec(piles, start, end - 1, 1-turn) + piles[end]
            );
        }
        // Bob turn
        else {
            dp[start][end] = Math.min(stoneGameRec(piles, start + 1, end, 1-turn) - piles[start],
                    stoneGameRec(piles, start, end - 1, 1-turn) - piles[end]
            );
        }

        return dp[start][end];
    }
}
