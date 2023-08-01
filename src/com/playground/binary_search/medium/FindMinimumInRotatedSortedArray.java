package com.playground.binary_search.medium;

/**
 * 153. Find Minimum in Rotated Sorted Array
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums[0] < nums[nums.length - 1]) return nums[0];

        int l = 0;
        int h = nums.length - 1;

        while( h >= l ) {
            int mid = l + (h - l) / 2;

            if(nums[mid] >= nums[0]) l = mid + 1;
            else h = mid - 1;
        }

        return nums[l];
    }
}
