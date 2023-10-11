package com.playground.backtrack.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 * =====================
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sum to target.
 * Each number in candidates may only be used once in the combination.
 * Note: The solution set must not contain duplicate combinations.
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 */
public class CombinationSum2 {

    public void run() {
        System.out.println(combinationSum2(new int[]{2,1,2,5,2}, 5));
    }

    List<List<Integer>> result;

    /**
     * 4ms Beats 51.27%, best 2ms
     * 42.71mb Beats 30.05%, best 41
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Sorting is a must with the solution
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
        // skip all similar numbers to skip duplicates.
        while(index < candidates.length && candidates[index] == num) index++;
        combinationSum2Rec(candidates, index, target, sum, combination);
    }
}
