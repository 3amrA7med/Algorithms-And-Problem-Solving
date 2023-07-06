package com.exercise.array_101;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 * <br> Recall that arr is a mountain array if and only if:
 * <br> arr.length >= 3
 * <br> There exists some i with 0 < i < arr.length - 1 such that:
 * <br> arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * <br> arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * <br> Input: arr = [0,3,2,1] Output: true
 * <br> 9,8,7,6,5,4,3,2,1,0    Output: false
 * <br> 0,2,3,4,8,5,4,3,2
 * <br> 1,3,2                  Output: true
 * <br> 4,4,3,2,1              Output: false
 */
public class ValidMountainArray {
    private static final Logger LOGGER = Logger.getLogger(ValidMountainArray.class.getName());

    public void run() {
        int[] arr = new int[] {4,4,3,2,1};
        LOGGER.log(Level.INFO, String.valueOf(validMountainArray2(arr)));
    }

    boolean validMountainArray1(int[] arr) {
        if(arr.length < 3) return false;
        boolean firstPass = false;
        boolean peakFoundFlipFlag = false;
        for(int i = 1; i< arr.length; i++) {
            if(!peakFoundFlipFlag) {
                if(arr[i] < arr[i-1])
                    peakFoundFlipFlag = true;
                else if(arr[i] == arr[i-1])
                    return false;
                else
                    firstPass = true;
            } else {
                if(arr[i] >= arr[i-1])
                    return false;
            }
        }
        return firstPass & peakFoundFlipFlag;
    }

    /**
     * faster 2ms while validMountainArray1 is 3ms.
     * @param arr
     * @return
     */
    public boolean validMountainArray2(int[] arr) {
        int index = 0;

        // up hill.
        while(index < arr.length - 1 && arr[index] < arr[index + 1])
            index++;

        // if it is the first item then no uphill.
        // if reached last index therefore no downhill.
        if(index == 0 || index == arr.length - 1)
            return false;

        // down hill.
        while(index < arr.length - 1 && arr[index] > arr[index + 1])
            index++;

        return index == arr.length-1;
    }
}
