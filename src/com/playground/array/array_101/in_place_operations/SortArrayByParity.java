package com.playground.array.array_101.in_place_operations;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
 *
 * </br> Return any array that satisfies this condition.
 * </br>Input: nums = [3,1,2,4]
 * </br>Output: [2,4,3,1]
 * </br>Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * </br> [0, 2]
 */
public class SortArrayByParity {

    private static final Logger LOGGER = Logger.getLogger(SortArrayByParity.class.getName());

    public void run() {
        int[] arr = new int[] {0,2};
        LOGGER.log(Level.INFO, Arrays.toString(arr));
        this.sortArrayByParity(arr);
        LOGGER.log(Level.INFO, Arrays.toString(arr));
    }

    /**
     * 1 ms Beats 97.48%
     * 42.9 MB Beats 99.56%
     */
    public int[] sortArrayByParity(int[] nums) {
        int backIterator = nums.length - 1;
        int frontIterator = 0;
        int temp;

        while(frontIterator < backIterator) {
            while(frontIterator < nums.length && nums[frontIterator] % 2 == 0)
                frontIterator++;

            while(backIterator >= 0 && nums[backIterator] % 2 != 0)
                backIterator--;

            if(frontIterator >= backIterator)
                break;

            // Swap
            temp = nums[frontIterator];
            nums[frontIterator] = nums[backIterator];
            nums[backIterator] = temp;
        }

        return nums;
    }
}
