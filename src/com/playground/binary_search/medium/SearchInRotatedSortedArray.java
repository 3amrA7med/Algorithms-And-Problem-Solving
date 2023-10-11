package com.playground.binary_search.medium;

/**
 * 33. Search in Rotated Sorted Array
 */
public class SearchInRotatedSortedArray {


    public int search(int[] nums, int target) {

        if(target == nums[0]) return 0;
        if(target == nums[nums.length - 1]) return nums.length - 1;

        int l = 0;
        int h = nums.length - 1;

        while(h >= l) {
            int mid = l + (h-l) / 2;

            if(nums[mid] == target) return mid;
            if(nums[mid] >= nums[l])
                if(target > nums[mid] || target < nums[l]) l = mid + 1;
                else h = mid - 1;

            else
                if(target < nums[mid] || target > nums[h]) h = mid - 1;
                else l = mid + 1;
        }
        return -1;
    }
}
