package com.exercise.array_101.in_place_operations;

/**
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right,
 * and replace the last element with -1. After doing so, return the array.
 *
 * <br> Input: arr = [17,18,5,4,6,1]
 * <br> Output: [18,6,6,6,1,-1]
 * <br> Explanation:
 * <br> - index 0 --> the greatest element to the right of index 0 is index 1 (18).
 * <br> - index 1 --> the greatest element to the right of index 1 is index 4 (6).
 * <br> - index 2 --> the greatest element to the right of index 2 is index 4 (6).
 * <br> - index 3 --> the greatest element to the right of index 3 is index 4 (6).
 * <br> - index 4 --> the greatest element to the right of index 4 is index 5 (1).
 * <br> - index 5 --> there are no elements to the right of index 5, so we put -1.
 * <br>
 *
 * <br> Input: arr = [400]
 * <br> Output: [-1]
 * <br> Explanation: There are no elements to the right of index 0.
 */
public class ReplaceElementsWithGreatestElementOnRightSide {

    public int[] replaceElements(int[] arr) {
        int currentMax = -1;
        int temporaryElement;

        for(int i = arr.length-1; i>=0; i--) {
            temporaryElement = arr[i];
            arr[i] = currentMax;
            currentMax = Math.max(temporaryElement, currentMax);
        }

        return arr;
    }


}
