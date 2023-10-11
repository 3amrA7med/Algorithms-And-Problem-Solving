package com.playground.binary_search.medium;

/**
 * 162. Find Peak Element
 * LeetCode 75
 * ==================================
 * A peak element is an element that is strictly greater than its neighbors.
 * Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains
 * multiple peaks, return the index to any of the peaks. You may imagine that nums[-1] = nums[n] = -∞.
 * In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
 * You must write an algorithm that runs in O(log n) time.
 * =====================================
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 * Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 * ========================================
 * Constraints:
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * nums[i] != nums[i + 1] for all valid i.
 */
public class FindPeakElement {

    /**
     * Runtime 0 ms Beats 100%
     * Memory 40.9 MB Beats 79.66%
     */
    public int findPeakElement(int[] nums) {

        int l = 0;
        int h = nums.length - 1;
        int m = -1;

        while(l <= h) {
            m = l + (h - l) / 2;
            boolean leftOutOfBound = m-1 < 0;
            boolean rightOutOfBound = m + 1 >= nums.length;
            if((leftOutOfBound || nums[m-1] < nums[m]) && (rightOutOfBound || nums[m] > nums[m+1]))
                return m;
            else if((leftOutOfBound || (!rightOutOfBound && nums[m-1] < nums[m+1])))
                l = m + 1;
            else h = m - 1;
        }

        return m;
    }
}
