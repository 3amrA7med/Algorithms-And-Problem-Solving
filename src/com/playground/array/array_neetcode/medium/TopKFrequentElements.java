package com.playground.array.array_neetcode.medium;

import java.util.*;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 */
public class TopKFrequentElements {

    public void run() {
        System.out.println(Arrays.toString(topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2)));
    }

    /**
     * 10ms Beats 96.50%
     * 47.77mb Beats 50.02%, 44.5
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        List<Integer>[] buckets = new List[nums.length + 1];
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(buckets[entry.getValue()] != null) buckets[entry.getValue()].add(entry.getKey());
            else {
                buckets[entry.getValue()] = new ArrayList<>();
                buckets[entry.getValue()].add(entry.getKey());
            }
        }

        int[] result = new int[k];
        int resultIndex = 0;
        for(int i = buckets.length - 1; i >= 0 && k > 0; i--) {
            if(buckets[i] == null) continue;
            while(buckets[i].size() > 0) {
                result[resultIndex++] = buckets[i].get(buckets[i].size() - 1);
                buckets[i].remove(buckets[i].size() - 1);
                k--;
            }
        }

        return result;
    }
}
