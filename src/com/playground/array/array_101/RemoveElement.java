package com.playground.array.array_101;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RemoveElement {
    private static final Logger LOGGER = Logger.getLogger(RemoveElement.class.getName());
    public void run() {
        int[] nums = new int[]{3,2,2,3};
        int k = removeElement3(nums, 3);
        LOGGER.log(Level.INFO, Arrays.toString(nums));
        LOGGER.log(Level.INFO, String.valueOf(k));
    }

    /**
     * This method maintain the order but the actual length calculated is wrong.
     */
    public int removeElementWithSameOrder(int[] nums, int val) {
        int actualLength = nums.length;
        int j;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == val) {
                j = i + 1;
                while(j < nums.length && nums[j] == val) {
                    j++;
                }
                if(j>=nums.length)
                    break;
                // Replace element at i with index at j.
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                actualLength--;
            }
        }

        return actualLength;
    }

    public int removeElementNoOrder(int[] nums, int val) {
        int actualLength = nums.length;
        int secondPointer = actualLength - 1;
        for(int i = 0; i < nums.length && secondPointer >= i; i++) {
            if(nums[i] == val) {
                while(secondPointer > i && nums[secondPointer] == val) {
                    secondPointer--;
                    actualLength--;
                }
                // Replace element at i with index at j.
                nums[i] = nums[secondPointer];
                actualLength--;
                secondPointer--;
            }
        }
        return actualLength;
    }

    /**
     * 0 ms Beats 100%
     * 42.7 MB Beats 6.25%
     */
    public int removeElement3(int[] nums, int val) {
        int k = 0;

        for(int curr = 0; curr < nums.length; curr++) {
            if(nums[curr] != val){
                nums[k++] = nums[curr];
            }
        }

        return k;
    }
}
