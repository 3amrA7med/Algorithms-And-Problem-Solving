package com.playground.bit_manipulation.easy;

/**
 * 268. Missing Number
 */
public class MissingNumber {


    /**
     * -ms Beats 100.00%
     * 43.96mb Beats 87.14%
     */
    public int missingNumber1(int[] nums) {
        int res = 0;
        for(int num: nums) res = res ^ num;
        for(int i = 0; i <= nums.length; i++) res = res ^ i;
        return res;
    }

    /**
     * -ms Beats 100.00%
     * 44.78mb Beats 6.82%
     */
    public int missingNumber2(int[] nums) {
        int s1 = 0, s2 = 0;
        for(int num: nums) s1+=num;
        for(int i = 0; i <= nums.length; i++) s2+=i;
        return s2-s1;
    }
}
