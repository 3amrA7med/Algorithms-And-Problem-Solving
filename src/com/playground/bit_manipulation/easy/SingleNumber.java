package com.playground.bit_manipulation.easy;

/**
 * 136. Single Number
 */
public class SingleNumber {

    /**
     * 1ms Beats 100.00%
     * 44.55mb Beats 64.30%
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i =0; i < nums.length; i++) result ^= nums[i];

        return result;
    }
}
