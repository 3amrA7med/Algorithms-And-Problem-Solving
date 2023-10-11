package com.playground.array.easy;

import java.util.*;
/**
 * 1512. Number of Good Pairs
 * =========================
 * Given an array of integers nums, return the number of good pairs.
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 */
public class NumberOfGoodPairs {

    /**
     * Runtime 0 ms Beats 100%
     * Memory 39.8 MB Beats 47.50%
     */
    public int numIdenticalPairs1(int[] nums) {
        int[] freq = new int[101];

        int numOfGoodPairs = 0;
        for (int num : nums) {
            numOfGoodPairs += freq[num];
            freq[num]++;
        }

        return numOfGoodPairs;
    }


    /**
     * Runtime 1ms Beats 86.54%
     * Memory 39.40MB Beats 92.80%
     */
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int numOfGoodPairs = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                numOfGoodPairs += map.get(num);
                map.put(num, map.get(num) + 1);
            } else map.put(num, 1);
        }

        return numOfGoodPairs;
    }
}
