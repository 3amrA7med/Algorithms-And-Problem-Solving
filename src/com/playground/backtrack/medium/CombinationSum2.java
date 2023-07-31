package com.playground.backtrack.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public void run() {
        System.out.println(combinationSum2(new int[]{2,1,2,5,2}, 5));
    }

    List<List<Integer>> result;

    /**
     * 4ms Beats 51.27%, best 2ms
     * 42.71mb Beats 30.05%, best 41
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        result = new ArrayList<>();
        combinationSum2Rec(candidates, 0, target, 0, new ArrayList<>());
        return result;
    }


    public void combinationSum2Rec(int[] candidates, int index, int target, int sum, List<Integer> combination) {
        if(sum == target) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if(index >= candidates.length || sum > target) return;


        combination.add(candidates[index]);
        combinationSum2Rec(candidates, index + 1, target, candidates[index]+sum, combination);
        combination.remove(combination.size() - 1);
        int num = candidates[index];
        while(index < candidates.length && candidates[index] == num) index++;
        combinationSum2Rec(candidates, index, target, sum, combination);
    }
}
