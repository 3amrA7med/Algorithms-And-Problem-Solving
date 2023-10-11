package com.playground.dynamic_programming.one_dimension.medium;

/**
 * 673. Number of Longest Increasing Subsequence
 */
public class NumberOfLongestIncreasingSubsequence {
    public void run() {
        System.out.println(findNumberOfLIS(new int[]{1,2,4,3,5,4,7,2}));
    }

    /**
     * 17ms Beats 96.78%
     * 42.90mb Beats 94.72%
     */
    public int findNumberOfLIS(int[] nums) {
        if(nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];

        int resCount = count[0];
        int maxLis = 0;

        for(int i = nums.length - 1; i >=0; i--) {
            dp[i] = 1;
            count[i] = 1;
            for(int j = i; j < nums.length; j++) {
                if(nums[j] > nums[i]) {
                    if(dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                    else if(dp[j] + 1 == dp[i]) count[i]+=count[j];
                }
            }

            if(dp[i] > maxLis) {
                maxLis = dp[i];
                resCount = count[i];
            }
            else if(dp[i] == maxLis) resCount += count[i];
        }

        return resCount;
    }

    /*
    Backtracking answer, Time Limit Exceeds
    int max = 0;
    int count = 0;
    public int findNumberOfLIS(int[] nums) {
        if(nums.length == 1) return 1;
        findNumberOfLISRec(nums, 0, Integer.MIN_VALUE, 0);
        return count;
    }

    public void findNumberOfLISRec(int[] nums, int index, int lastNum, int numOfElements) {
        if(index >= nums.length)
            if(numOfElements < max) return;
            else if(numOfElements == max) {count++; return;}
            else {max = numOfElements; count = 1; return;}

        findNumberOfLISRec(nums, index+1, lastNum, numOfElements);
        if(nums[index] > lastNum) findNumberOfLISRec(nums, index+1, nums[index], numOfElements + 1);
    }
    */
}
