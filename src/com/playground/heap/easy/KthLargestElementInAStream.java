package com.playground.heap.easy;

import java.util.PriorityQueue;

/**
 * 703. Kth Largest Element in a Stream
 * Beats 68.06% 17ms, best 16ms
 * Beats 85.88% 46.7mb, best 45.9
 */
public class KthLargestElementInAStream {

    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int k;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        for(int i = 0; i < nums.length; i++) this.add(nums[i]);
    }

    public int add(int val) {
        this.heap.offer(val);
        if(heap.size() > k) this.heap.poll();
        return this.heap.peek();
    }
}
