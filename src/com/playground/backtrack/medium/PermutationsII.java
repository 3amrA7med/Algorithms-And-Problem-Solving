package com.playground.backtrack.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. Permutations II
 * ===================
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 * ================
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 */
public class PermutationsII {

    public void run() {
        System.out.println(this.permuteUnique(new int[]{1,2,1}));
    }

    /**
     * Runtime 2ms Beats 82.66%
     * Memory 44.03MB Beats 64.38%
     */
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            if(i != 0 && nums[i] == nums[i-1]) continue;
            boolean[] indices = new boolean[nums.length];
            permuteUniqueRec(nums, i, indices, new ArrayList<>());
        }

        return res;
    }

    public void permuteUniqueRec(int[] nums, int index, boolean[] indices, List<Integer> path) {
        path.add(nums[index]);
        indices[index] = true;
        for(int i = 0; i < nums.length; i++) {
            if(i != 0 && !indices[i-1] && nums[i] == nums[i-1] || indices[i]) continue;
            indices[i] = true;
            permuteUniqueRec(nums, i, indices, path);
            indices[i] = false;
        }
        if(path.size() == nums.length) res.add(new ArrayList<>(path));
        path.remove(path.size()-1);
    }
}
