package com.playground.dynamic_programming.two_dimensions.medium;

/**
 * 1140. Stone Game II
 * ======================
 * Alice and Bob continue their games with piles of stones.  There are a number of piles arranged in a row,
 * and each pile has a positive integer number of stones piles[i].  The objective of the game is to end with the most stones.
 * Alice and Bob take turns, with Alice starting first.  Initially, M = 1.
 * On each player's turn, that player can take all the stones in the first X remaining piles,
 * where 1 <= X <= 2M.  Then, we set M = max(M, X).
 * The game continues until all the stones have been taken.
 * Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.
 * =================================
 * Example 1:
 * Input: piles = [2,7,9,4,4]      ---- Output: 10
 * Explanation:  If Alice takes one pile at the beginning, Bob takes two piles, then Alice takes 2 piles again.
 * Alice can get 2 + 4 + 4 = 10 piles in total. If Alice takes two piles at the beginning, then Bob can take
 * all three piles left. In this case, Alice get 2 + 7 = 9 piles in total. So we return 10 since it's larger.
 * Example 2:
 * Input: piles = [1,2,3,4,5,100]  ---- Output: 104
 */
public class StoneGameII {

    public void run() {
        System.out.println(this.stoneGameII(new int[] {2,7,9,4,4}));
    }

    /**
     * Using 3-dimensional array lead to 17ms and more memory
     * Runtime  10ms Beats 49.76%
     * Memory 43.09MB  Beats 47.41%
     */
    Integer[][] aliceDp;
    Integer[][] bobDp;
    public int stoneGameII(int[] piles) {
        if(piles.length == 1) return piles[0];
        aliceDp = new Integer[piles.length][piles.length];
        bobDp = new Integer[piles.length][piles.length];
        return stoneGameIITopDown(piles, true, 1, 0);
    }

    public int stoneGameIITopDown(int[] piles, boolean isAliceTurn, int M, int index) {
        if(index == piles.length) return 0;
        if(isAliceTurn && aliceDp[index][M] != null) return aliceDp[index][M];
        if(!isAliceTurn && bobDp[index][M] != null) return bobDp[index][M];

        int aliceScore;
        if(isAliceTurn) aliceScore = 0;
        else aliceScore = Integer.MAX_VALUE;

        int pilesSelected = 0;
        for(int i = 0; i < 2*M; i++) {
            if(index + i >= piles.length) break;
            pilesSelected += piles[index + i];
            if(isAliceTurn) aliceScore = Math.max(aliceScore, stoneGameIITopDown(piles, !isAliceTurn, Math.max(M, i + 1), index + i + 1) + pilesSelected);
            else aliceScore = Math.min(aliceScore, stoneGameIITopDown(piles, !isAliceTurn, Math.max(M, i + 1), index + i + 1));
        }

        if(isAliceTurn) aliceDp[index][M] = aliceScore;
        else bobDp[index][M] = aliceScore;

        return aliceScore;
    }
}
