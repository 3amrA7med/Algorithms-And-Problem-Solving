package com.playground.backtrack.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 * Beats 39.81% 3ms, best 1ms
 * Beats 37.19% 44.1,best 42
 * ==============================
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency of at least one of the chosen numbers is different.
 * The test cases are generated such that the number of unique combinations that sum up to target is less than
 * 150 combinations for the given input.
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
