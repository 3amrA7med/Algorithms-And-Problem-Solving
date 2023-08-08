package com.playground.array.array_101.conclusion;

import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThirdMaximumNumber {
    private static final Logger LOGGER = Logger.getLogger(ThirdMaximumNumber.class.getName());
    public void run() {
        int[] nums = new int[]{1,1,3,1,2,1};
        int numberOfMismatch = thirdMax2(nums);
        LOGGER.log(Level.INFO, Arrays.toString(nums));
        LOGGER.log(Level.INFO, String.valueOf(numberOfMismatch));
    }

    public int thirdMax(int[] nums) {
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        if(nums.length == 1) return nums[0];

        Integer globalMax = null;
        // Get the largest number.
        for(int number: nums)
        {
            globalMax = (Objects.nonNull(globalMax))?Math.max(globalMax, number):number;
        }

        Integer secondLargest = null;
        // Get second-largest number.
        for(int number: nums) {
            if(number < globalMax) {
                if (Objects.isNull(secondLargest)) {
                    secondLargest = number;
                }
                else
                    secondLargest = Math.max(secondLargest, number);
            }
        }
        if(Objects.isNull(secondLargest)) return globalMax;

        Integer thirdLargest = null;
        // Get third-largest number;
        for(int number: nums)
            if(number < secondLargest) {
                if (Objects.isNull(thirdLargest)) {
                    thirdLargest = number;
                }
                else
                    thirdLargest = Math.max(thirdLargest, number);
            }

        return (Objects.isNull(thirdLargest)) ? globalMax : thirdLargest;
    }

    public int thirdMax2(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;

        for(Integer number: nums) {
            if(number.equals(max1) || number.equals(max2) || number.equals(max3)) continue;
            if(Objects.isNull(max1) || number > max1) {
                max3 = max2;
                max2 = max1;
                max1 = number;
            }
            else if(Objects.isNull(max2) || number > max2){
                max3 = max2;
                max2 = number;
            }
            else if(Objects.isNull(max3) || number > max3){
                max3 = number;
            }
        }

        return Objects.isNull(max3)? max1: max3;
    }
}
