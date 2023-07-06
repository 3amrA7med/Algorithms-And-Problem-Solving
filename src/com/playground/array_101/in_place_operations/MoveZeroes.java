package com.exercise.array_101.in_place_operations;

import com.exercise.utils.ArraysUtils;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <br> Input: nums = [0,1,0,3,12]
 * <br> Output: [1,3,12,0,0]
 * <br> Example 2:
 * <br> Input: nums = [0]
 * <br> Output: [0]
 * <br> -20,8,-6,-14,0,-19,14,4
 */
public class MoveZeroes {
    private static final Logger LOGGER = Logger.getLogger(MoveZeroes.class.getName());
    private ArraysUtils arraysUtils = new ArraysUtils();

    public void run() {
        int[] arr = new int[] {-20,8,-6,-14,0,-19,14,4};
        LOGGER.log(Level.INFO, Arrays.toString(arr));
        this.moveZeroes3(arr);
        LOGGER.log(Level.INFO, Arrays.toString(arr));
    }
    public void moveZeroes(int[] nums) {
        int indexToFirstZero = -1;
        int indexToFirstNonZero = -1;

        for(int i = 0; i< nums.length; i++) {
            if(indexToFirstNonZero == -1 || indexToFirstZero  == -1) {
                if(indexToFirstZero == -1 && nums[i] == 0)
                    indexToFirstZero = i;
                else if(indexToFirstZero != -1 && nums[i] != 0)
                    indexToFirstNonZero = i;
            }
            if(indexToFirstNonZero != -1 && indexToFirstZero  != -1) {
                arraysUtils.swapElementsInPlace(nums, indexToFirstNonZero, indexToFirstZero);
                indexToFirstZero = this.getIndexOfFirstZeroLeft(nums, indexToFirstNonZero);
                indexToFirstNonZero = -1;
            }
        }
    }

    private int getIndexOfFirstZeroLeft(int[] arr, int indexToZero) {
        while(indexToZero-1>=0 && arr[indexToZero-1] == 0) {
            indexToZero--;
        }
        return indexToZero;
    }


    public void moveZeroes2(int[] nums) {
        int indexToNonZeroElement;
        int indexToFirstZeroElement;
        int temp;
        boolean firstZeroNotFound = true;
        for(int i = 0; i< nums.length; i++) {
            if(nums[i] == 0) {
                firstZeroNotFound = false;
                continue;
            }
            if(firstZeroNotFound)
                continue;

            indexToNonZeroElement = i;
            indexToFirstZeroElement = indexToNonZeroElement - 1;
            while(indexToFirstZeroElement - 1 >= 0 && nums[indexToFirstZeroElement - 1] == 0)
                indexToFirstZeroElement--;

            temp = nums[indexToFirstZeroElement];
            nums[indexToFirstZeroElement] = nums[indexToNonZeroElement];
            nums[indexToNonZeroElement] = temp;
        }
    }

    /**
     * excellent solution.
     * @param nums
     */
    public void moveZeroes3(int[] nums){ // 0 1 0 3 12  ->
        int indexToFirstZero = 0;

        for(int curr = 0; curr < nums.length; curr++) {
            if(nums[curr] != 0 ) {
                nums[indexToFirstZero++] = nums[curr];
            }
        }

        for(int curr = indexToFirstZero; curr < nums.length; curr++) {
            if(nums[curr] != 0 ) {
                nums[curr] = 0;
            }
        }
    }

    
}
