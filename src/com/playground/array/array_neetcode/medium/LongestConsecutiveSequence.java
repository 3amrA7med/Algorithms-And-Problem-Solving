package com.playground.array.array_neetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 */
public class LongestConsecutiveSequence {
    /**
     * 24ms Beats 78.50%
     * 59.84mb Beats 43.34%
     * @param nums
     * @return
     */
    public int longestConsecutiveSet1(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++)
            set.add(nums[i]);

        int lcs = 0;

        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])) continue;

            set.remove(nums[i]);
            int nextVal = nums[i] + 1;
            int prevVal = nums[i] - 1;
            int currLcs = 1;
            while(set.contains(prevVal)) {
                set.remove(prevVal);
                prevVal--;
                currLcs++;
            }
            while(set.contains(nextVal)) {
                set.remove(nextVal);
                nextVal++;
                currLcs++;
            }
            if(lcs < currLcs) lcs = currLcs;
        }

        return lcs;
    }

    /**
     * 29ms Beats 77.74%
     * 57.24mb Beats 54.35%
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        int lcs = 0;

        for(int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == null || map.get(nums[i] - 1) != null ) continue;

            int num = nums[i];
            map.remove(num);
            int currLcs = 1;
            while(map.get(num + 1) != null) {
                map.remove(num + 1);
                num++;
                currLcs++;
            }
            if(lcs < currLcs) lcs = currLcs;
        }

        return lcs;
    }

    /**
     * Better set solution
     * 29ms Beats 77.74%
     * 54.53mb Beats 99.04%
     */
    public int longestConsecutiveSet2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> visitedSequences = new HashSet<>();

        for(int i = 0; i < nums.length; i++)
            set.add(nums[i]);

        int lcs = 0;

        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i]) || set.contains(nums[i] - 1) || visitedSequences.contains(nums[i])) continue;
            visitedSequences.add(nums[i]);

            int num = nums[i] + 1;
            int currLcs = 1;
            while(set.contains(num)) {
                num++;
                currLcs++;
            }
            if(lcs < currLcs) lcs = currLcs;
        }

        return lcs;
    }

    /**
     * 303ms Beats 38.85%
     * 55.46mb Beats 96.18%
     * @param nums
     * @return
     */
    public int longestConsecutiveSet3(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++)
            set.add(nums[i]);

        int lcs = 0;

        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i]) || set.contains(nums[i] - 1)) continue;

            int num = nums[i] + 1;
            int currLcs = 1;
            while(set.contains(num)) {
                num++;
                currLcs++;
            }
            if(lcs < currLcs) lcs = currLcs;
        }

        return lcs;
    }
}
