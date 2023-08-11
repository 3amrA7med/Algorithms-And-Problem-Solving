package com.playground.dynamic_programming.one_dimension.medium;

/**
 * 213. House Robber II
 * Very important follow up, circular dependency.
*/
public class HouseRobber2 {

    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);

        int res1;
        int rob1 = 0;
        int rob2 = 0;
        for(int i = 0; i < nums.length - 1; i ++) {
            int temp = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        res1 = rob2;
        rob1 = 0;
        rob2 = 0;

        for(int i = 1; i < nums.length; i ++) {
            int temp = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return Math.max(res1, rob2);
    }
}
