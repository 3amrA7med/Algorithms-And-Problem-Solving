package com.playground.array_101.array_neetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 */
public class TwoSum {
    /**
     * 2 ms Beats 80.78%
     * Hash map with 1 pass.
     * 43.5 MB Beats 90.43%
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            Integer secondIndex = map.get(target - nums[i]);
            if(secondIndex != null && secondIndex != i) return new int[] {i, secondIndex};
            map.put(nums[i], i);
        }
        return null;
    }
}
