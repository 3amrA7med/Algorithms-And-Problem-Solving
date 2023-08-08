package com.playground.array.array_neetcode.medium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public void run() {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }

    /**
     * 1ms Beats 100.00%
     * 51.25mb Beats 93.95%
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        // Compute prefix of the array.
        int prefix = 1;
        for(int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix*=nums[i];
        }

        // Compute postfix of the array.
        int postfix = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }

        return result;
    }
}
