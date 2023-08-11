package com.playground.dynamic_programming.one_dimension.medium;

import java.util.List;

/**
 * 120. Triangle
 */
public class Triangle {

    /**
     * 1D
     * 3 ms Beats 65.84%
     * 44 MB Beats 62.50%
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];

        for(int row = triangle.size() - 1; row >= 0; row--)
            for(int i = 0; i < triangle.get(row).size(); i++)
                dp[i] = Math.min(dp[i], dp[i+1]) + triangle.get(row).get(i);

        return dp[0];
    }

    /**
     * 2D
     * 1ms Beats 99.96%
     * 43.62mb Beats 96.32%
     */
    Integer[][] dp;
    public int minimumTotal2D(List<List<Integer>> triangle) {
        dp = new Integer[triangle.size()][triangle.size() + 1];
        return minimumTotalTopDown(triangle, 0, 0);
    }

    public int minimumTotalTopDown(List<List<Integer>> triangle, int level, int index) {
        if(index >= triangle.get(level).size()) return 0;
        if(level == triangle.size() - 1) return triangle.get(level).get(index);
        if(dp[level][index] != null) return dp[level][index];


        int min = Math.min(minimumTotalTopDown(triangle, level + 1, index),minimumTotalTopDown(triangle, level + 1, index + 1));
        dp[level][index] = triangle.get(level).get(index) + min;
        return dp[level][index];
    }
}
