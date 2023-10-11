package com.playground.backtrack.medium;

import java.util.*;

/**
 * 473. Matchsticks to Square
 * ========================
 * You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick.
 * You want to use all the matchsticks to make one square. You should not break any stick,
 * but you can link them up, and each matchstick must be used exactly one time.
 * Return true if you can make this square and false otherwise.
 * ================
 * Input: matchsticks = [1,1,2,2,2]
 * Output: true
 * Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
 */
public class MatchsticksToSquare {

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int i: matchsticks) sum +=i;
        if(sum%4 != 0) return false;
        Arrays.sort(matchsticks);
        return makesquareRec(matchsticks, new int[4], matchsticks.length - 1, sum/4);
    }

    public boolean makesquareRec(int[] matchsticks, int[] squareSides, int index, int target) {
        if(index == -1) {
            return squareSides[0] == squareSides[1] && squareSides[1] == squareSides[2] & squareSides[2] == squareSides[3];
        }
        else if(squareSides[0] > target || squareSides[1] > target || squareSides[2] > target || squareSides[3] > target) return false;

        int val = matchsticks[index];

        squareSides[0] += val;
        if(makesquareRec(matchsticks, squareSides, index - 1, target)) return true;
        squareSides[0] -= val;

        squareSides[1] += val;
        if(makesquareRec(matchsticks, squareSides, index - 1, target)) return true;
        squareSides[1] -= val;

        squareSides[2] += val;
        if(makesquareRec(matchsticks, squareSides, index - 1, target)) return true;
        squareSides[2] -= val;

        squareSides[3] += val;
        if(makesquareRec(matchsticks, squareSides, index - 1, target)) return true;
        squareSides[3] -= val;

        return false;
    }
}
