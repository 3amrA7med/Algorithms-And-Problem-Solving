package com.playground.backtrack.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 * Beats 39.81% 3ms, best 1ms
 * Beats 37.19% 44.1,best 42
 */
public class CombinationSum {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        combinationSumRec(candidates, 0, new ArrayList<>(), 0, target);
        return result;
    }

    public void combinationSumRec(int[] candidates, int index, List<Integer> combinationList, int sum, int target) {
        if(index == candidates.length) return;
        if(sum > target) return;
        if(sum == target) {
            result.add(new ArrayList<>(combinationList));
            return;
        }

        combinationList.add(candidates[index]);
        combinationSumRec(candidates, index, combinationList, sum+candidates[index], target);
        combinationList.remove(combinationList.size() - 1);
        combinationSumRec(candidates, index+1, combinationList, sum, target);
    }
}
