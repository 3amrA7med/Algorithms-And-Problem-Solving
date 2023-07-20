package com.playground.array_101.conclusion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FindAllNumbersDisappearedInAnArray {

    private static final Logger LOGGER = Logger.getLogger(FindAllNumbersDisappearedInAnArray.class.getName());
    public void run() {
        int[] nums = new int[]{1,1,3,1,2,1};
        LOGGER.log(Level.INFO, Arrays.toString(nums));
        LOGGER.log(Level.INFO, String.valueOf(findDisappearedNumbers2(nums)));
    }

    /**
     * Excellent solution, maybe math.abs in the other solution slow the code down a bit.
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int temp;
        // We know the correct location for each element, so we need to sort using this information.
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] != nums[nums[i] - 1]) {
                // Swap elements until first element is placed correctly.
                temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                result.add(i + 1);
        }
        return result;
    }


    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int tempIndex;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i< nums.length; i++) {
            tempIndex = Math.abs(nums[i]) - 1;
            nums[tempIndex] = - Math.abs(nums[tempIndex]);
        }
        for(int i = 0; i< nums.length; i++) {
            if(nums[i] > 0)
                result.add(i + 1);
        }
        return result;
    }
}
