package com.playground.backtrack.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. Combination Sum III
 */
public class CombinationSum3 {
    List<List<Integer>> result;
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 9;

    /**
     * -ms Beats 100.00%
     * 40.16mb Beats 66.63%
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        combinationSum3BackTrack(MIN_NUMBER, k, n, new ArrayList<>(), 0, 0);
        return result;
    }

    public void combinationSum3BackTrack(int start, int k, int n, List<Integer> combination, int sum, int numOfElements) {
        if(sum == n && numOfElements == k) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if(start > MAX_NUMBER || sum > n || numOfElements > k) return;

        for(int i = start; i <= MAX_NUMBER; i++) {
            combination.add(i);
            combinationSum3BackTrack(i+1, k, n, combination, sum+i, numOfElements+1);
            combination.remove(combination.size() - 1);
        }
    }
}
