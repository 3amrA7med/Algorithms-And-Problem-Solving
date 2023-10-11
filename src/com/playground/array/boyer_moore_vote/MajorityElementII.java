package com.playground.array.boyer_moore_vote;

import java.util.*;

/**
 * 229. Majority Element II
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * ================================
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: [3]
 * Example 2:
 * Input: nums = [1]
 * Output: [1]
 * Example 3:
 * Input: nums = [1,2]
 * Output: [1,2]
 * Constraints:
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 */
public class MajorityElementII {

    /**
     * Runtime 2ms Beats 98.52%
     * Memory 46.53MB Beats 55.69%
     */
    public List<Integer> majorityElement(int[] nums) {
        int maj1 = 0, maj2 = 0, count1 = 0, count2 = 0;

        for(int num: nums) {
            if(maj1 == num) count1++;
            else if(maj2 == num) count2++;
            else if(count1 == 0) {maj1 = num; count1 = 1;}
            else if(count2 == 0) {maj2 = num; count2 = 1;}
            else {count1--; count2--;}
        }

        count1 = 0; count2 = 0;

        for(int num: nums) {
            if(num == maj1) count1++;
            if(num == maj2) count2++;
        }

        List<Integer> res = new ArrayList<>();
        if(count1 > nums.length / 3) res.add(maj1);
        if(count2 > nums.length / 3 && maj1 != maj2) res.add(maj2);

        return res;
    }
}
