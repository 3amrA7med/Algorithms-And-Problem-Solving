package com.playground.backtrack.medium;

import java.util.*;

/**
 * 90. Subsets II
 * ========================
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * ========================
 * Example 1:
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 */
public class Subsets2 {


    List<List<Integer>> result;

    /**
     * 1ms Beats 100.00%
     * 43.73mb Beats 73.51%
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDupBest(int[] nums) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        subsetsWithDupRec(nums, 0, new ArrayList<>());
        return result;
    }

    public void subsetsWithDupRec(int[] nums, int index, List<Integer> subset) {
        if(index >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        Integer num = nums[index];
        subset.add(num);
        subsetsWithDupRec(nums, index + 1, subset);
        subset.remove(subset.size() - 1);

        while(index < nums.length && nums[index] == num) index++;
        subsetsWithDupRec(nums, index, subset);
    }


    /**
     * So bad solution
     * 33ms Beats 5.31%, best 1ms
     * 44.18mb Beats 10.87%, best 42
     */
//    List<List<Integer>> result;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        subsetsWithDupRec(nums, 0);
        return result;
    }

    public void subsetsWithDupRec(int[] nums, int index) {
        if(index >= nums.length) {
            result.add(new ArrayList<>());
            return;
        }

        subsetsWithDupRec(nums, index+1);

        int size = result.size();
        for(int i = 0; i < size; i++) {
            List<Integer> newSubset = new ArrayList<>(result.get(i));
            newSubset.add(nums[index]);
            if(canAddSubset(newSubset))
                result.add(newSubset);
        }
    }

    private boolean canAddSubset(List<Integer> subset) {
        Map<Integer, Integer> freqMapForSubset = new HashMap<>();
        for(Integer num: subset)
            freqMapForSubset.put(num, freqMapForSubset.getOrDefault(num,0)+1);

        for(List<Integer> s: result) {
            if(s.size() != subset.size()) continue;
            Map<Integer, Integer> map = new HashMap<>();
            for(Integer num: s)
                map.put(num, map.getOrDefault(num, 0)+1);
            if(map.equals(freqMapForSubset)) return false;
        }
        return true;
    }
}
