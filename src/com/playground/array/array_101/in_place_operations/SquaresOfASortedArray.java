package com.playground.array.array_101.in_place_operations;

import com.playground.array.array_101.conclusion.FindAllNumbersDisappearedInAnArray;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * -5,-3,-2,-1 => 1, 4, 9, 25
 * -7,-3,2,3,11  => 4, 9, 9, 49, 121
 */
public class SquaresOfASortedArray {
    private static final Logger LOGGER = Logger.getLogger(FindAllNumbersDisappearedInAnArray.class.getName());
    public void run() {
        int[] nums = new int[]{-5,-3,-2,-1};
        LOGGER.log(Level.INFO, Arrays.toString(nums));
        LOGGER.log(Level.INFO, Arrays.toString(sortedSquares(nums)));
    }

    /**
     * Extra Space, but .
     * @param nums
     * @return
     */
    public int[] sortedSquares2(int[] nums) {
        // -4,-1,0,3,10
        int firstIterator = 0;
        int secondIterator = nums.length - 1;
        int indexOfNewArray = secondIterator;
        int[] tempNums = new int[nums.length];
        while(indexOfNewArray>=0) {
            if(Math.abs(nums[firstIterator])<=Math.abs(nums[secondIterator])){
//                tempNums[indexOfNewArray] = (int)Math.pow(nums[secondIterator], 2);
                tempNums[indexOfNewArray--] = nums[secondIterator] * nums[secondIterator];
                secondIterator--;
            }
            else{
//                tempNums[indexOfNewArray] = (int)Math.pow(nums[firstIterator], 2);
                tempNums[indexOfNewArray--] = nums[firstIterator] * nums[firstIterator];
                firstIterator++;
            }
        }
        return tempNums;
    }

    /**
     * Failed attempts to not use extra space.
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
//        int temp;
//        int frontIterator = 0;
//        int backIterator = nums.length - 1;
//        while(frontIterator < backIterator) {
//            if(nums[frontIterator]*nums[frontIterator] < nums[backIterator]*nums[backIterator]){
//                nums[backIterator--] = nums[backIterator]*nums[backIterator];
//            }
//            else {
//                // Swap
//                temp = nums[backIterator];
//                nums[backIterator] = nums[frontIterator];
//                nums[frontIterator] = temp;
//                nums[backIterator--] = nums[backIterator]*nums[backIterator];
//                frontIterator++;
//            }
//        }
//
//        return nums;

        int temp;
        int i;
        for( i = nums.length-1; i >= 0; i--) {
            if(nums[0] < 0 && nums[i] < 0) break; // all the remaining numbers are negatives.
            if(nums[i]*nums[i] < nums[0]*nums[0]){
                // Swap
                temp = nums[0];
                nums[0] = nums[i];
                nums[i] = temp;
            }
            nums[i] = nums[i]*nums[i];
        }

        int j = 0;
        while(j < i) {
            temp = nums[j];
            nums[j++] = nums[i] * nums[i];
            nums[i--] = temp * temp;
        }
        return nums;
    }
}
