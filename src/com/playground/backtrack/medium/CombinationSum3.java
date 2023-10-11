package com.playground.backtrack.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. Combination Sum III
 * =============================
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice,
 * and the combinations may be returned in any order.
 * ==========================
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Explanation:
 * 1 + 2 + 4 = 7
 * There are no other valid combinations.
 * ==========================
 * is [1,2] similar to [2,1] ??
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
