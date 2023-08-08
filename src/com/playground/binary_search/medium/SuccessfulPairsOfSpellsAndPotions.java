package com.playground.binary_search.medium;

import java.util.Arrays;

/**
 * 2300. Successful Pairs of Spells and Potions
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
