package com.playground.bit_manipulation.easy;

/**
 * 338. Counting Bits
 */
public class CountingBits {


    /**
     * 2ms Beats 59.11%
     * 46.29mb Beats 90.12%
     */
    public int[] countBitsBest(int n) {
        if(n == 0) return new int[]{0};
        if(n == 1) return new int[]{0,1};
        int[] result = new int[n+1];
        result[0] = 0;
        result[1] = 1;
        int offset = 2;

        for(int i = 2; i <= n; i++) {
            if(offset == i - offset) offset *= 2;
            result[i] = result[i-offset] + 1;
        }
        return result;
    }

    /**
     * 3ms Beats 36.51%
     * 46.54mb Beats 49.66%
     */

    public int[] countBits(int n) {
        int[] result = new int[n+1];
        result[0] = 0;
        for(int i = 0; i <= n; i++)
            result[i] = hammingWeight(i);
        return result;
    }

    public int hammingWeight(int n) {
        int result = 0;
        int val = n;
        while( val != 0) {
            val = val & (val-1);
            result++;
        }
        return result;
    }
}
