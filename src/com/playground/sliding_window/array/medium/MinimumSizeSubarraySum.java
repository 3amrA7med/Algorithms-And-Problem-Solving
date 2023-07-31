package com.playground.sliding_window.array.medium;

/**
 * 209. Minimum Size Subarray Sum
 */
public class MinimumSizeSubarraySum {

 public int minSubArrayLen(int target, int[] nums) {
     if (nums.length == 0) return 0;

     int accumulatingSum = 0;
     int minimumSubArrayLengthFound = nums.length + 1;
     int leftIndex = 0;
     for (int rightIndex = 0; rightIndex < nums.length; rightIndex++) {
         accumulatingSum += nums[rightIndex];
         while (accumulatingSum >= target) {
             minimumSubArrayLengthFound = Math.min(minimumSubArrayLengthFound, rightIndex - leftIndex + 1);
             accumulatingSum -= nums[leftIndex];
             leftIndex++;
         }
     }

     if (minimumSubArrayLengthFound == nums.length + 1)
         return 0;
     return minimumSubArrayLengthFound;
 }
}
