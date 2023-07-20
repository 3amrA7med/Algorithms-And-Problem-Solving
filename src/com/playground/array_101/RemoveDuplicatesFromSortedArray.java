package com.playground.array_101;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RemoveDuplicatesFromSortedArray {
    private static final Logger LOGGER = Logger.getLogger(RemoveDuplicatesFromSortedArray.class.getName());
    public void run() {
        int[] nums = new int[]{1,1,2,3,3,4,4,4};
        int k = removeDuplicates(nums);
        LOGGER.log(Level.INFO, Arrays.toString(nums));
        LOGGER.log(Level.INFO, String.valueOf(k));
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int writerPointer = 0;
        for(int readerPointer = 1; readerPointer < nums.length; readerPointer++) {
            if(nums[readerPointer] != nums[writerPointer]) {
                writerPointer++;
                nums[writerPointer] = nums[readerPointer];
            }
        }
        return writerPointer + 1;
    }
}
