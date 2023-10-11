package com.playground.sliding_window.array.medium;

/**
 * 1004. Max Consecutive Ones III
 * =================================
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array
 * if you can flip at most k 0's.
 * ================================
 * Example 1:
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * Example 2:
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * =======================================
 * Constraints:
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 * 0 <= k <= nums.length
 */
public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {
        int maxLength = 0;
        int i = 0, j=0;

        while(j < nums.length) {
            if(nums[j] == 0) k--;

            while(k < 0) {
                if(nums[i] == 0) k++;
                i++;
            }

            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }

        return maxLength;
    }

}
