package com.playground.array_101.medium;

/**
 * 287. Find the Duplicate Number
 *
 * Floyd's algorithm from linked lists
 */
public class FindTheDuplicateNumber {

    /**
     * Floyds algorithm, constant space with no modifying to array itself.
     * space Beats 61.93%
     * memory Beats 76.48%
     * @param nums
     * @return
     */
    public int findDuplicateFloyd(int[] nums) {
        int s = 0;
        int f = 0;
        while(true) {
            s = nums[s];
            f = nums[nums[f]];
            if(nums[s] == nums[f]) break;
        }
        int s2 = 0;

        while(nums[s] != nums[s2]){
            s = nums[s];
            s2 = nums[s2];
        }
        return nums[s];
    }

    /**
     * right answer but it will modify the array value
     * Another answer will be using binary search and check if value found is in the array. (didn't implement )
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        for(int i =0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if(nums[index] < 0) return index;
            nums[index] = -nums[index];
        }
        return 0;
    }

}
