package com.playground.binary_search.easy;

/**
 * 35. Search Insert Position
 *
 */
public class SearchInsertPosition {

    /**
     * Runtime 0ms Beats 100.00
     * Memory 42.96MB Beats 87.24%
     */
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        int m = 0;

        while(l <= h) {
            m = l + (h - l) / 2;

            if(nums[m] == target) return m;
            if(nums[m] > target) h = m - 1;
            else l = m + 1;
        }
        return l;
    }
}
