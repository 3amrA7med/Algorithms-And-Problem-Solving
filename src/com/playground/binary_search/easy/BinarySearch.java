package com.playground.binary_search.easy;

/**
 * 704. Binary Search
 */
public class BinarySearch {

    // 100% runtime
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        int index;
        while(e >= s) {
            index = (e + s) / 2;
            // index = s + (e - s) / 2;
            if(target == nums[index]) return index;
            if(target > nums[index]) s = index + 1;
            else e = index - 1;
        }
        return -1;
    }
}
