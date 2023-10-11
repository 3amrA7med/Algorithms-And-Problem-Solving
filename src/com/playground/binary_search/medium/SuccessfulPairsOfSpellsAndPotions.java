package com.playground.binary_search.medium;

import java.util.Arrays;

/**
 * 2300. Successful Pairs of Spells and Potions
 * ============================================
 * You are given two positive integer arrays spells and potions, of length n and m respectively, where
 * spells[i] represents the strength of the ith spell and potions[j] represents the strength of the jth potion.
 * You are also given an integer success. A spell and potion pair is considered successful
 * if the product of their strengths is at least success.
 * Return an integer array pairs of length n where pairs[i] is the number of potions
 * that will form a successful pair with the ith spell.
 * ==========================================
 * Input: spells = [5,1,3], potions = [1,2,3,4,5], success = 7
 * Output: [4,0,3]
 * Explanation:
 * - 0th spell: 5 * [1,2,3,4,5] = [5,10,15,20,25]. 4 pairs are successful.
 * - 1st spell: 1 * [1,2,3,4,5] = [1,2,3,4,5]. 0 pairs are successful.
 * - 2nd spell: 3 * [1,2,3,4,5] = [3,6,9,12,15]. 3 pairs are successful.
 * Thus, [4,0,3] is returned.
 */
public class SuccessfulPairsOfSpellsAndPotions {

    public void run() {
        System.out.println(Arrays.toString(successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7)));
    }

    /**
     * 37ms Beats 94.25%, best ~20ms reaching 5ms
     * 57.48mb Beats 64.22%, best 55.6
     */
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        Arrays.sort(potions);

        for(int i = 0; i < spells.length; i++) {
            int index = binarySearch(spells[i], success, potions);
            if(index == -1) res[i] = 0;
            else res[i] = potions.length - index;
        }
        return res;
    }

    public int binarySearch(long spell, long success, int[] potions) {
        if(potions[potions.length - 1]*spell < success) return -1;
        int l = 0;
        int r = potions.length - 1;
        int minIndex = potions.length;
        while(l <= r) {
            int m = l + (r - l) / 2;
            long product = spell * potions[m];
            if(product >= success) {minIndex = m; r = m - 1;}
            else l = m + 1;
        }

        return minIndex;
    }
}
