package com.playground.backtrack.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. Permutations [IMPORTANT]
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * =======
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Permutations {

    public void run() {
        System.out.println(Arrays.toString(permute(new int[]{1, 2, 3}).toArray()));
    }
    List<List<Integer>> result = new ArrayList<>();

    /**
     * 1ms Beats 98.84%
     * 43.78mb Beats 84.99%
     */
    public List<List<Integer>> permute(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            boolean[] indices = new boolean[nums.length];
            permuteRec(nums, indices, i, new ArrayList<>());
        }
        return result;
    }

    public void permuteRec(int[] nums, boolean[] indices, int curr, List<Integer> path) {
        path.add(nums[curr]);
        indices[curr] = true;
        for(int i = 0; i < indices.length; i++) {
            if(indices[i]) continue;
            indices[i] = true;
            permuteRec(nums, indices, i, path);
            indices[i] = false;
        }
        if(path.size() == nums.length) result.add(new ArrayList<>(path));
        path.remove(Integer.valueOf(nums[curr]));
    }
}
