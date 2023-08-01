package com.playground.array_101;

import com.playground.utils.ArraysUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
 * More formally check if there exists two indices i and j such that :
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 *
 * @see <a href="https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3250/">link</a>
 */
public class CheckIfNAndItsDoubleExist {

    private static final Logger LOGGER = Logger.getLogger(CheckIfNAndItsDoubleExist.class.getName());
    private final ArraysUtils arraysUtils = new ArraysUtils();

    public void run() {
        int[] arr = new int[] {-20,8,-6,-14,0,-19,14,4};
        LOGGER.log(Level.INFO, String.valueOf(checkIfExistNestedLoops(arr)));
    }

    /**
     * Using hash map.
     */
    public boolean checkIfExistHashTable(int[] arr) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        // To handle special case of zero values found twice
        boolean zeroFoundBefore = false;
        for(int number: arr) {
            if(number == 0 & zeroFoundBefore) return true;
            else if(number == 0) zeroFoundBefore = true;
            numsMap.put(number, number);
        }

        for(int number: arr) {
            if(number%2==0 && number !=0 && numsMap.containsValue(number/2)) return true;
        }

        return false;
    }

    public boolean checkIfExistBinarySearch(int[] arr) {
        Arrays.sort(arr);

        boolean zeroFound = false;
        for(int number: arr) {
            if(number%2 == 0 && number !=0 && arraysUtils.binarySearch(arr, number/2)) return true;
            else if(number == 0 && zeroFound) return true;
            else if(number == 0) zeroFound = true;
        }
        return false;
    }

    /**
     * Fastest solution and best memory management.
     */
    public boolean checkIfExistNestedLoops(int[] arr) {
        for(int i = 0; i< arr.length; i++) {
            if(arr[i]%2!=0) continue;
            for(int j = 0; j< arr.length; j++) {
                if( i!=j && arr[i] == 0 && arr[j] == 0) return true;
                else if( i!=j && arr[j] == arr[i]/2 ) return true;
            }
        }
        return false;
    }

}
