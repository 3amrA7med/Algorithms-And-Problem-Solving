package com.playground.dynamic_programming.medium;

/**
 * 72. Edit Distance
 */
public class EditDistance {
    public void run() {
        System.out.println(minDistance("zoologicoarchaeologist", "zoogeologist"));
    }

    /**
     * 4ms Beats 93.42%
     * 43.62mb Beats 69.09%
     * Bottom Up
     */
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int[][] dp = new int[w1.length + 1][w2.length + 1];

        for(int i = 0; i < w2.length; i++) dp[w1.length][i] = w2.length - i;
        for(int i = 0; i < w1.length; i++) dp[i][w2.length] = w1.length - i;
        dp[w1.length][w2.length] = 0;

        for(int i = w1.length - 1; i >= 0; i--) {
            for(int j = w2.length - 1; j >= 0; j--) {
                if(w1[i] != w2[j]) {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i+1][j+1]);
                    dp[i][j]+=1;
                }
                else dp[i][j] = dp[i+1][j+1];
            }
        }

        return dp[0][0];
    }
}
