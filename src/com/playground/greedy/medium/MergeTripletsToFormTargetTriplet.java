package com.playground.greedy.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 1899. Merge Triplets to Form Target Triplet
 */
public class MergeTripletsToFormTargetTriplet {

    /**
     * 1ms Beats 98.96%
     * 119.31mb Beats 53.50%
     */
    public boolean mergeTripletsBest(int[][] triplets, int[] target) {
        // Check if we can somehow can get 3 elements of the target.
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
