package com.playground.greedy.medium;

/**
 * 45. Jump Game II
 */
public class JumpGameTwo {
    public int jump(int[] nums) {
        if(nums.length < 2) return 0;

        int l = 0, r =0;
        int minNumOfJumps = 0;

        while(r < nums.length - 1) {
            int biggestJump = 0;
            for(int i = l ; i <= r; i++) {
                if(i + nums[i] > biggestJump)
                    biggestJump = i + nums[i];

            }
            l = r + 1;
            r = biggestJump;
            minNumOfJumps++;
        }

        return minNumOfJumps;
    }
}
