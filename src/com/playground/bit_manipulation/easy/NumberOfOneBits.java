package com.playground.bit_manipulation.easy;

/**
 * 191. Number of 1 Bits
 */
public class NumberOfOneBits {

    /**
     * #1 10001 & 10000 = 10000
     * #2 10000 & 01111 = 00000  -> we are done there were 2 ones.
     * much better as we needed only 2 loops in this approach compared to 32.
     */
    public int hammingWeightBest(int n) {
        int result = 0;
        int val = n;
        while( val != 0) {
            val = val & (val-1);
            result++;
        }
        return result;
    }

    /**
     * -ms Beats 100.00%
     * 39.30mb  Beats 91.37%
     * you need to treat n as an unsigned value
     */
    public int hammingWeight(int n) {
        int result = 0;
        int val = n;
        for(int i = 0; i < 32; i++) {
            result += val & 1;
            val = val >> 1;
        }
        return result;
    }
}
