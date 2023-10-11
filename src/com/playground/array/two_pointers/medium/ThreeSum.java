package com.playground.array.two_pointers.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 */
public class ThreeSum {

    public void run() {
        System.out.println(threeSum(new int[] {-1,0,1,2,-1,-4}));
    }

    /**
     * 31ms Beats 99.09%
     * 51.84mb Beats 19.61%, best 48mb
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0) {
                    result.add(getList(nums[i], nums[l], nums[r]));
                    l++;
                    while(l<r && nums[l] == nums[l-1]) l++;
                }
                else if(sum < 0) l++;
                else r--;
            }
        }
        return result;
    }

    private List<Integer> getList(int a, int b, int c) {
        List<Integer> triplet = new ArrayList<>();
        triplet.add(a);
        triplet.add(b);
        triplet.add(c);
        return triplet;
    }

}
