package com.playground.greedy.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 1899. Merge Triplets to Form Target Triplet
 * ================================================
 * A triplet is an array of three integers. You are given a 2D integer array triplets,
 * where triplets[i] = [ai, bi, ci] describes the ith triplet. You are also given an integer array
 * target = [x, y, z] that describes the triplet you want to obtain.
 * To obtain target, you may apply the following operation on triplets any number of times (possibly zero):
 * Choose two indices (0-indexed) i and j (i != j) and update triplets[j] to become [max(ai, aj), max(bi, bj), max(ci, cj)].
 * For example, if triplets[i] = [2, 5, 3] and triplets[j] = [1, 7, 5], triplets[j] will be updated to
 * [max(2, 1), max(5, 7), max(3, 5)] = [2, 7, 5].
 * Return true if it is possible to obtain the target triplet [x, y, z] as an element of triplets, or false otherwise.
 * ================================================
 * Example 1:
 * Input: triplets = [[2,5,3],[1,8,4],[1,7,5]], target = [2,7,5]
 * Output: true
 * Explanation: Perform the following operations:
 * - Choose the first and last triplets [[2,5,3],[1,8,4],[1,7,5]]. Update the last triplet to be [max(2,1), max(5,7), max(3,5)] = [2,7,5]. triplets = [[2,5,3],[1,8,4],[2,7,5]]
 * The target triplet [2,7,5] is now an element of triplets.
 * Example 2:
 * Input: triplets = [[3,4,5],[4,5,6]], target = [3,2,5]
 * Output: false
 * Explanation: It is impossible to have [3,2,5] as an element because there is no 2 in any of the triplets.
 * Example 3:
 * Input: triplets = [[2,5,3],[2,3,4],[1,2,5],[5,2,3]], target = [5,5,5]
 * Output: true
 * Explanation: Perform the following operations:
 * - Choose the first and third triplets [[2,5,3],[2,3,4],[1,2,5],[5,2,3]]. Update the third triplet to be
 * [max(2,1), max(5,2), max(3,5)] = [2,5,5]. triplets = [[2,5,3],[2,3,4],[2,5,5],[5,2,3]].
 * - Choose the third and fourth triplets [[2,5,3],[2,3,4],[2,5,5],[5,2,3]].
 * Update the fourth triplet to be [max(2,5), max(5,2), max(5,3)] = [5,5,5]. triplets = [[2,5,3],[2,3,4],[2,5,5],[5,5,5]].
 * The target triplet [5,5,5] is now an element of triplets.
 * ============================================
 * Constraints:
 * 1 <= triplets.length <= 105
 * triplets[i].length == target.length == 3
 * 1 <= ai, bi, ci, x, y, z <= 1000
 */
public class MergeTripletsToFormTargetTriplet {

    /**
     * 1ms Beats 98.96%
     * 119.31mb Beats 53.50%
     */
    public boolean mergeTripletsBest(int[][] triplets, int[] target) {
        // Check if we can somehow get three elements of the target.
        boolean[] canMerge = new boolean[3];

        for(int i = 0; i < triplets.length; i++) {
            if(!(triplets[i][0] <= target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2])) continue;
            if(triplets[i][0] == target[0]) canMerge[0] = true;

            if(triplets[i][1] == target[1]) canMerge[1] = true;

            if(triplets[i][2] == target[2]) canMerge[2] = true;

            if(canMerge[0]&&canMerge[1]&&canMerge[2]) return true;
        }
        return false;
    }

    /**
     * 6ms Beats 53.65%
     * 112.45mb Beats 66.32%
     */
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        List<int[]> tripletsValid = new ArrayList<>();

        // Get all valid triplets that can contribute to the answer.
        for(int i = 0; i < triplets.length; i++)
            if(triplets[i][0] <= target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2])
                tripletsValid.add(triplets[i]);

        // Check if we can somehow can get 3 elements of the target.
        boolean[] canMerge = new boolean[3];

        for(int i = 0; i < tripletsValid.size(); i++) {
            if(tripletsValid.get(i)[0] == target[0]) canMerge[0] = true;

            if(tripletsValid.get(i)[1] == target[1]) canMerge[1] = true;

            if(tripletsValid.get(i)[2] == target[2]) canMerge[2] = true;

            if(canMerge[0]&&canMerge[1]&&canMerge[2]) return true;
        }

        return false;
    }

    /**
     * 5ms Beats 76.15%
     * 123.12mb Beats 36.22%
     */
    public boolean mergeTriplets2(int[][] triplets, int[] target) {
        // Get all valid triplets that can contribute to the answer.
        for(int i = 0; i < triplets.length; i++)
            if(!(triplets[i][0] <= target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2])) {
                triplets[i][0] = -1;
                triplets[i][1] = -1;
                triplets[i][2] = -1;
            }

        // Check if we can somehow can get 3 elements of the target.
        boolean[] canMerge = new boolean[3];

        for(int i = 0; i < triplets.length; i++) {
            if(triplets[i][0] == target[0]) canMerge[0] = true;

            if(triplets[i][1] == target[1]) canMerge[1] = true;

            if(triplets[i][2] == target[2]) canMerge[2] = true;

            if(canMerge[0]&&canMerge[1]&&canMerge[2]) return true;
        }

        return false;
    }
}
