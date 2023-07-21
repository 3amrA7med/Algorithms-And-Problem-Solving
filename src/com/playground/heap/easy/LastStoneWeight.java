package com.playground.heap.easy;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 1046. Last Stone Weight
 *
 * Beats 98.87% 1ms
 * Beats 99.40% 38.4mb
 */
public class LastStoneWeight {

    PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());

    public int lastStoneWeight(int[] stones) {
        // Creating empty priority queue, Max heap
        for(int i =0; i < stones.length; i++)
            pQueue.offer(stones[i]);

        return lastStoneWeightRec();
    }

    public int lastStoneWeightRec() {
        if(pQueue.size() == 1) return pQueue.peek();
        if(pQueue.size() == 0) return 0;

        int biggestStone = pQueue.poll();
        int secondBiggestStone = pQueue.poll();

        if(biggestStone != secondBiggestStone) pQueue.offer(biggestStone - secondBiggestStone);
        return lastStoneWeightRec();
    }
}
