package com.playground.backtrack.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. Permutations
 */
public class Permutations {

    public void run() {
        System.out.println(Arrays.toString(permute(new int[]{1, 2, 3}).toArray()));
    }
    List<List<Integer>> result = new ArrayList<>();

    /**
     * 1ms Beats 98.84%
     * 43.78mb Beats 84.99%
     * @param nums
     * @return
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
