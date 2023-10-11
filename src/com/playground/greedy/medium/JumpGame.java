package com.playground.greedy.medium;

/**
 * 55. Jump Game
 */
public class JumpGame {

    /**
     * Runtime 3 ms Beats 43.29%
     * Memory 43.8 MB Beats 82.99%
     */
    public boolean canJump(int[] nums) {
        if(nums.length <= 1) return true;
        int l = 0, r = 0;
        int remainingJumps = 0;
        while(remainingJumps >= 0 && r < nums.length - 1) {
            remainingJumps = nums[l] - (r - l);
            if(nums[r] > remainingJumps) {
                l = r;
                remainingJumps = nums[r];
            }
            if(remainingJumps < 1) return false;
            r++;
        }

        return true;
    }
}
