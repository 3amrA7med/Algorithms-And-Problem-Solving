package com.playground.dynamic_programming.one_dimension.medium;


import java.util.Arrays;

/**
 * 1626. Best Team With No Conflicts
 * ==================================----------
 * Similar with LIS
 * ==================================
 * You are the manager of a basketball team. For the upcoming tournament, you want to choose
 * the team with the highest overall score. The score of the team is the sum of scores of all the players in the team.
 * However, the basketball team is not allowed to have conflicts. A conflict exists if a younger player
 * has a strictly higher score than an older player. A conflict does not occur between players of the same age.
 * Given two lists, scores and ages, where each scores[i] and ages[i] represents the score and age of the ith player,
 * respectively, return the highest overall score of all possible basketball teams.
 * ======================================
 * Example 1:
 * Input: scores = [1,3,5,10,15], ages = [1,2,3,4,5]
 * Output: 34
 * Explanation: You can choose all the players.
 * Example 2:
 * Input: scores = [4,5,6,5], ages = [2,1,2,1]
 * Output: 16
 * Explanation: It is best to choose the last 3 players. Notice that you are allowed to choose multiple people of the same age.
 * Example 3:
 * Input: scores = [1,2,3,5], ages = [8,9,10,1]
 * Output: 6
 * Explanation: It is best to choose the first 3 players.
 */
public class BestTeamWithNoConflicts {

    public void run() {
        System.out.println(this.bestTeamScore(new int[]{1,1,1,1,1,1,1,1,1,1}, new int[] {811,364,124,873,790,656,581,446,885,134}));
    }

    /**
     * Runtime 29ms Beats 87.02%
     * Memory 43.66MB Beats 74.04%
     */
    static class Pair {
        public int score;
        public int age;

        Pair(int a, int s){
            this.score = s;
            this.age = a;
        }
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int[] dp = new int[scores.length];
        int maxScore = 0;

        Pair[] players = new Pair[scores.length];
        for(int i = 0; i < scores.length; i ++) players[i] = new Pair(ages[i], scores[i]);
        Arrays.sort(players, (a, b) -> {if(a.age != b.age) return Integer.compare(a.age,b.age); else return Integer.compare(a.score,b.score);});


        for(int i = 0; i < scores.length; i++) {
            dp[i] = players[i].score;
            for(int j = 0; j < i; j++) {
                if(players[j].score <= players[i].score)
                    dp[i] = Math.max(dp[i], dp[j] + players[i].score);
            }
            maxScore = Math.max(dp[i], maxScore);
        }

        return maxScore;
    }
}
