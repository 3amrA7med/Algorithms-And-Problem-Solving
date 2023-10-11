package com.playground.array.easy;

/**
 * 1128. Number of Equivalent Domino Pairs
 * =========================================
 * Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d]
 * if and only if either (a == c and b == d), or (a == d and b == c) - that is,
 * one domino can be rotated to be equal to another domino.
 * Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].
 * ==========================================
 * Example 1:
 * Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * Output: 1
 * Example 2:
 * Input: dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
 * Output: 3
 */
public class NumberOfEquivalentDominoPairs {

    /**
     * Runtime 3ms Beats 94.93%
     * Memory 50.84MB Beats 86.67%
     */
    final static int MAX_VAL = 9;
    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] pair = new int[MAX_VAL+1][MAX_VAL+1];
        int numOfEqualPairs = 0;

        for(int[] dom: dominoes) {
            numOfEqualPairs+= pair[dom[0]][dom[1]];
            if(dom[0] != dom[1]) numOfEqualPairs+= pair[dom[1]][dom[0]];
            pair[dom[0]][dom[1]]++;
        }

        return numOfEqualPairs;
    }
}
