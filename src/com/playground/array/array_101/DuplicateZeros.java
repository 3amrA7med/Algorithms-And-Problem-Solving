package com.playground.array.array_101;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DuplicateZeros {

    private static final Logger LOGGER = Logger.getLogger(DuplicateZeros.class.getName());

    public void run() {
        int[] arr = new int[]{1,0,2,3,0,4,5,0};
        LOGGER.log(Level.INFO, Arrays.toString(arr));
        this.duplicateZerosMethod2(arr);
        LOGGER.log(Level.INFO, Arrays.toString(arr));
    }

    /**
     * Way <b>faster</b> than method one.
     * <br>Two pass method which we will go over array 2 times, firs time to calculate the number of
     * spaces that will be needed to the duplicates(aka the number of elements that we will be dropping).
     * @param arr input array that we will change it in place.
     * @see <a href="https://leetcode.com/problems/duplicate-zeros/solution/">link</a>.
     */
    public void duplicateZerosMethod2(int[] arr) {
        int possibleDuplicates = 0;
        int last = arr.length - 1;
        for(int i = 0; i <= last - possibleDuplicates; i++) {
            if(arr[i] == 0) {
                if(i == last - possibleDuplicates) {
                    arr[last] = 0;
                    last --;
                    break;
                }
                possibleDuplicates++;
            }
        }

        for(int i = last - possibleDuplicates; i>=0 && possibleDuplicates!=0; i--) {
            if(arr[i] == 0) {
                arr[i + possibleDuplicates] = 0;
                possibleDuplicates--;
                arr[i + possibleDuplicates] = 0;
            }
            else {
                arr[i + possibleDuplicates] = arr[i];
            }
        }
    }

    public void duplicateZerosMethod1(int[] arr) {
        for(int i = 0; i < arr.length-1; i++) {
            if(arr[i] == 0) {
                this.shiftRightFromIndex(arr, i);
                arr[i+1] = 0;
                i++;
            }
        }
    }

    private void shiftRightFromIndex(int[] arr, int index) {
        for(int i = arr.length - 1; i>index&&i>=0; i--) {
            arr[i] = arr[i-1];
        }
    }
}
