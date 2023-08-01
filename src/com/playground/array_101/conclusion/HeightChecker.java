package com.playground.array_101.conclusion;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 1051. Height Checker
 */
public class HeightChecker {

    private static final Logger LOGGER = Logger.getLogger(HeightChecker.class.getName());
    public void run() {
        int[] nums = new int[]{1,1,4,2,1,3};
        int numberOfMismatch = heightChecker(nums);
        LOGGER.log(Level.INFO, Arrays.toString(nums));
        LOGGER.log(Level.INFO, String.valueOf(numberOfMismatch));
    }

    /**
     * 1 ms Beats 91.21%
     * Excellent runtime, but 34% memory
     */
    public int heightChecker(int[] heights) {
        int[] freq = new int[101];
        int numberOfMismatch = 0;
        // Fill hashmap with frequencies needed.
        for(int height: heights){
            freq[height]++;
        }

        // Compare freq.s to heights.
        int currFreq = 0;
        for(int curr = 0; curr < heights.length; curr++) {
            while(freq[currFreq] == 0)
                currFreq++;

            if(heights[curr] != currFreq)
                numberOfMismatch++;

            freq[currFreq]--;
        }
        return numberOfMismatch;
    }

}
