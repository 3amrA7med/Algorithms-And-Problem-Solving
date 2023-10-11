package com.playground.dynamic_programming.one_dimension.medium;

import java.util.Arrays;

/**
 * 740. Delete and Earn
 * Also there exists a bottom up solution.
 */
public class DeleteAndEarn {

    public void run(){
        System.out.println(deleteAndEarn(new int[]{3,2,4}));
    }

    int[] freqMap;
    Integer[] dp;
    // 3ms, beats 85.5%
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++) max = Math.max(nums[i], max);
        dp = new Integer[max + 1];
        freqMap = new int[max + 1];
        for(int i = 0; i < nums.length; i++) freqMap[nums[i]]++;

        return deleteAndEarnRec(1);
    }

    public int deleteAndEarnRec(int num) {
        if(num >= freqMap.length) return 0;
        if(dp[num] != null) return dp[num];

        int skipElementPath = deleteAndEarnRec(num + 1);
        int pickElementPath = (freqMap[num] == 0)? 0: freqMap[num] * num + deleteAndEarnRec(num + 2);

        dp[num] = Math.max(skipElementPath, pickElementPath);
        return dp[num];
    }

    /**
     * 42.87mb Beats 97.12%
     * 5ms Beats 62.24%
     */
    public int deleteAndEarnBottomUp(int[] nums) {
        int[] freqMap;
        Arrays.sort(nums);
        int dp1 = 0;
        int dp2 = 0;
        int dp3 = 0;

        int max = 0;
        for(int i = 0; i < nums.length; i++) max = Math.max(nums[i], max);
        freqMap = new int[max + 1];
        for(int i = 0; i < nums.length; i++) freqMap[nums[i]]++;

        int i = 0;
        while(i < nums.length) {
            if(i > 0 && nums[i] == nums[i-1] + 1)
                dp3 = Math.max(dp1 + nums[i] * freqMap[nums[i]], dp2);
            else
                dp3 = nums[i] * freqMap[nums[i]] + dp2;
            dp1 = dp2;
            dp2 = dp3;
            int num = nums[i];
            while(i < nums.length && num == nums[i]) i++;
        }

        return dp3;
    }

    /* 10ms
    Map<Integer, Integer> freqMap;
    Integer[] dp;

    public int deleteAndEarn(int[] nums) {
        int max = 0;
        freqMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i],0) + 1);
            max = Math.max(nums[i], max);
        }
        dp = new Integer[max + 1];
        return deleteAndEarnRec(1, max);
    }

    public int deleteAndEarnRec(int num, int max) {
        if(num > max) return 0;
        if(dp[num] != null) return dp[num];

        int skipElementPath = deleteAndEarnRec(num + 1, max);
        int numFreq = freqMap.getOrDefault(num, 0);
        int pickElementPath = (numFreq == 0)? 0: numFreq * num + deleteAndEarnRec(num + 2, max);

        dp[num] = Math.max(skipElementPath, pickElementPath);
        return dp[num];
    }

     */
}
