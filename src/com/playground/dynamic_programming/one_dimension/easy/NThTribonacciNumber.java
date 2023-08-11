package com.playground.dynamic_programming.one_dimension.easy;

/**
 * 1137. N-th Tribonacci Number
 */
public class NThTribonacciNumber {

    /**
     *  -ms Beats 100.00%
     *  38.94mb Beats 91.17%
     */
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        int dp0 = 0;
        int dp1 = 1;
        int dp2 = 1;
        int dp3 = 0;

        for(int i = 3; i <= n; i++) {
            dp3 = dp0 + dp1 + dp2;
            dp0 = dp1;
            dp1 = dp2;
            dp2 = dp3;
        }

        return dp3;
    }
}
