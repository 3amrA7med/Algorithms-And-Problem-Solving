package com.playground.bit_manipulation.easy;

public class ReverseBits {

    public void run() {
        System.out.println(reverseBits(43261596));
    }

    /**
     * -ms Beats 100.00%
     * 41.05mb Beats 42.06%
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int val = n;
        int result = 0;
        for(int i = 0; i < 31; i++) {
            int bit = val & 1;
            val = val >> 1;
            result |= bit;
            result = result << 1;
        }
        int bit = val & 1;
        result |= bit;
        return result;
    }
}
