package com.playground.dynamic_programming.medium;

/**
 * 152. Maximum Product Subarray
 */
public class MaximumProductSubArray {

    public void run() {
        System.out.println(maxProduct(new int[]{-2, 3, -4}));
    }

    /**
     * 2ms Beats 49.56%
     * 43.02mb Beats 95.21%
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];
        int maxProduct = Integer.MIN_VALUE;

        int currMax = 1;
        int currMin = 1;
        for(int i = 0; i < nums.length; i++) {
            int temp1 = currMax * nums[i];
            currMax = Math.max(nums[i], Math.max(temp1, currMin*nums[i]));
            currMin = Math.min(nums[i], Math.min(temp1, currMin*nums[i]));

            maxProduct = Math.max(maxProduct, currMax);
        }
        return maxProduct;
    }
}
