package com.playground.sliding_window.string.medium;

import java.util.Arrays;

/**
 * 1838.Frequency of the Most Frequent Element
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
