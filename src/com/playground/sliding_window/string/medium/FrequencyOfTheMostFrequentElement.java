package com.playground.sliding_window.string.medium;

import java.util.Arrays;

/**
 * 1838.Frequency of the Most Frequent Element
 * =========================================
 * The frequency of an element is the number of times it occurs in an array.
 * You are given an integer array nums and an integer k. In one operation,
 * you can choose an index of nums and increment the element at that index by 1.
 * Return the maximum possible frequency of an element after performing at most k operations.
 * ==========================
 * Example 1:
 * Input: nums = [1,2,4], k = 5
 * Output: 3
 * Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
 * 4 has a frequency of 3.
 * Example 2:
 * Input: nums = [1,4,8,13], k = 5
 * Output: 2
 * Explanation: There are multiple optimal solutions:
 * - Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
 * - Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
 * - Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.
 */
public class FrequencyOfTheMostFrequentElement {

        public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int maxFreq = 0;
        int totalSum = 0;

        for(int r = 0;r < nums.length; r++) {
            totalSum+= nums[r];

            while((r-l+1)*nums[r] > totalSum + k) {
                totalSum-=nums[l];
                l++;
            }

            maxFreq = Math.max(maxFreq, (r-l+1));

        }
        return maxFreq;
    }
}
