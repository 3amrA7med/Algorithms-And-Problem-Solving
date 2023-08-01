package com.playground.array_101;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MergeSortedArray {

    private static final Logger LOGGER = Logger.getLogger(MergeSortedArray.class.getName());

    public void run(){
        int[] numArray1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] numArray2 = {2,5,6};
        int n = 3;
        LOGGER.log(Level.INFO, Arrays.toString(numArray1), Arrays.toString(numArray2));
        this.merge(numArray1, m, numArray2, n);
        LOGGER.log(Level.INFO, Arrays.toString(numArray1));
    }


    /**
     * 0 ms Beats 100%
     * 42.9 MB Beats 6.74%
     */
    public void merge(int[] numArray1, int m, int[] numArray2, int n) {
        int firstIndex = m-1;
        int secondIndex = n-1;
        int currentIndex = m + n - 1;
        while(currentIndex >= 0 && firstIndex >= 0 && secondIndex >= 0) {
            if(numArray1[firstIndex] >= numArray2[secondIndex]) {
                numArray1[currentIndex] = numArray1[firstIndex];
                currentIndex --;
                firstIndex--;
            }
            else {
                numArray1[currentIndex] = numArray2[secondIndex];
                currentIndex--;
                secondIndex--;
            }
        }

        while(currentIndex>=0 && ((firstIndex >= 0)||(secondIndex>=0))) {
            if(firstIndex>=0) {
                numArray1[currentIndex] = numArray1[firstIndex];
                currentIndex--;
                firstIndex--;
            }
            else {
                numArray1[currentIndex] = numArray2[secondIndex];
                currentIndex--;
                secondIndex--;
            }
        }
    }
}
