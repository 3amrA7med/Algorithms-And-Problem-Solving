package com.playground.heap.medium;

import java.util.PriorityQueue;

/**
 * 15. Kth Largest Element in an Array
 * ================================
 * Beats 54.07% 49ms, best 2ms
 * Beats 89.87% memory
 * ==========================
 * There another solution which is quick select
 */
public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for(int i =0; i < k; i ++)
            pQueue.offer(nums[i]);

        for(int i = k; i < nums.length; i++)
            if(nums[i]>pQueue.peek()) {
                pQueue.poll();
                pQueue.offer(nums[i]);
            }

        return pQueue.peek();
    }
}
