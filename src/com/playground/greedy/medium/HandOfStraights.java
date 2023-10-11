package com.playground.greedy.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 846. Hand of Straights
 * =======================================
 * Alice has some number of cards, and she wants to rearrange the cards into groups so that each group is of size
 * groupSize, and consists of groupSize consecutive cards.
 * Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize,
 * return true if she can rearrange the cards, or false otherwise.
 * ========================================
 * Example 1:
 * Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
 * Example 2:
 * Input: hand = [1,2,3,4,5], groupSize = 4
 * Output: false
 * Explanation: Alice's hand can not be rearranged into groups of 4.
 * ======================================
 * Constraints:
 * 1 <= hand.length <= 104
 * 0 <= hand[i] <= 109
 * 1 <= groupSize <= hand.length
 */
public class HandOfStraights {

    public void run() {
        System.out.println(isNStraightHand(new int[]{8,8,9,7,7,7,6,7,10,6}, 2));
    }

    /**
     * 26ms Beats 94.17%
     * 45.18mb Beats 10.43%
     * Can be optimized if using min heap instead of normal array sorting?
     */
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        Arrays.sort(hand);

        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < hand.length; i++) freqMap.put(hand[i], freqMap.getOrDefault(hand[i],0)+1);

        for(int i = 0; i < hand.length; i++) {
            if(freqMap.get(hand[i]-1) != null || freqMap.get(hand[i]) == null) continue; // Not the beginning of the group
            int currGroupSize = 0;
            int nextHand = hand[i];
            while(currGroupSize < groupSize && freqMap.get(nextHand) != null) {
                freqMap.put(nextHand, freqMap.get(nextHand) - 1);
                if(freqMap.get(nextHand) == 0) freqMap.remove(nextHand);
                nextHand++;
                currGroupSize++;
            }
            if(currGroupSize != groupSize) return false;
        }

        return freqMap.size() == 0;
    }
}
