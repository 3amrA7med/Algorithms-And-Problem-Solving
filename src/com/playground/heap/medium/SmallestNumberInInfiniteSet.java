package com.playground.heap.medium;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 2336. Smallest Number in Infinite Set
 * 9ms Beats 98.52%
 * 44.4 MB Beats 73.46%
 */
public class SmallestNumberInInfiniteSet {
    Set<Integer> set;
    PriorityQueue<Integer> pQueue;
    int nextVal;

    public SmallestNumberInInfiniteSet() {
        set = new HashSet<>();
        pQueue = new PriorityQueue<>();
        nextVal = 1;
    }

    public int popSmallest() {
        if(pQueue.size() == 0 || nextVal < pQueue.peek()) return nextVal++;
        set.remove(pQueue.peek());
        return pQueue.poll();
    }

    public void addBack(int num) {
        if(num >= nextVal || set.contains(num)) return;
        set.add(num);
        pQueue.offer(num);
    }
}
