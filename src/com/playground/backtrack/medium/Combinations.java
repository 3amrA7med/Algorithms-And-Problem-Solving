package com.playground.backtrack.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 * Using for loop in recursion will yield in a better solution
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 * You may return the answer in any order.
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 */
public class Combinations {

    List<List<Integer>> result;
    // n inclusive or exclusive ?
    // range of n.
    // k in range ? k > 0 also n > 1 ? or n >= 1
    // missing: is [1, 2] is similar to [2, 1]
    // Runtime 15ms Beats 62.53%
    // Memory 92.47MB Beats 11.47%
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        if(n == 1) {
            result.add(List.of(1));
            return result;
        }
        combineBt(new ArrayList<>(), 1, n, k);
        return result;
    }

    public void combineBt(List<Integer> combination, int number, int n, int k) {
        if(combination.size() == k){
            result.add(new ArrayList<>(combination));
            return;
        }
        if(number > n) return;

        combineBt(combination, number + 1, n, k);
        combination.add(number);
        combineBt(combination, number + 1, n, k);
        combination.remove(combination.size() - 1);
    }


    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombinations(1, n, k, new ArrayList<Integer>(), result);
        return result;
    }

    private void generateCombinations(int start, int n, int k, List<Integer> combination, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            combination.add(i);
            generateCombinations(i + 1, n, k - 1, combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}
