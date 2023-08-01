package com.playground.array_101.two_pointers.medium;

import java.util.Arrays;

public class TwoSum2InputArrayIsSorted {
    public void run() {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    /**
     * 1ms Beats 99.27%
     * 45.29mb Beats 90.31%
     */
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while(l < r) {
            int sum = numbers[l] + numbers[r];
            if(sum == target) break;
            else if(sum < target) l++;
            else r--;
        }

        return new int[]{l+1, r+1};
    }
}
