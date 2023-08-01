package com.playground.backtrack.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 * Beats 71.36% 1ms
 * Beats 16.56% 42.2, best 41
 */
public class Subsets {

    public void run(){
        int[] arr = new int[]{1,2,3};
        System.out.println(this.subsets(arr));
    }

    public List<List<Integer>> subsets(int[] nums) {
        return subsetsRec(nums,0);
    }

    public List<List<Integer>> subsetsRec(int[] nums, int index) {
        if(index == nums.length) {
            List<List<Integer>> subsets = new ArrayList<>();
            subsets.add(new ArrayList<>());
            return subsets;
        }

        List<List<Integer>> subsets = subsetsRec(nums, index+1);
        int size = subsets.size();
        for(int i = 0; i < size; i++){
            List<Integer> newList = new ArrayList<>(subsets.get(i));
            newList.add(nums[index]);
            subsets.add(newList);
        }
        return subsets;
    }

    /**
     * =======================================
     * another solution
     * Beats 100%
     * Beats 8 % memory 42.3
     */

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsetsRec(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void subsetsRec(int[] nums, int index, List<Integer> permList, List<List<Integer>> result) {
        if(index == nums.length) {
            result.add(new ArrayList<>(permList));
            return;
        }

        List<Integer> leftList = new ArrayList<>(permList);
        leftList.add(nums[index]);
        subsetsRec(nums, index + 1, leftList, result);
        subsetsRec(nums, index + 1, permList, result);
    }
}
