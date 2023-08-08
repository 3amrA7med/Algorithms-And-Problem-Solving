package com.playground.array.array_neetcode.easy;

import java.util.*;
public class ContainsDuplicate {

    /**
     * 10ms Beats 91.26%
     * 54.90mb Beats 79.63%
     */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) return true;
            map.put(nums[i], true);
        }

        return false;
    }

    /**
     * 10ms Beats 91.26%
     * 55.20mb Beats 60.43%
     * @param nums
     * @return
     */
    public boolean containsDuplicateSet(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
}
