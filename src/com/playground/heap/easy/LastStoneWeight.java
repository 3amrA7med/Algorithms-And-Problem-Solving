package com.playground.heap.easy;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 1046. Last Stone Weight
 * ==========================
 * You are given an array of integer stones where stones[i] is the weight of the ith stone.
 * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together.
 * Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
 * If x == y, both stones are destroyed, and
 * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 * At the end of the game, there is at most one stone left.
 * Return the weight of the last remaining stone. If there are no stones left, return 0.
 * =================================
 * Example 1:
 * Input: stones = [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
 * Example 2:
 * Input: stones = [1]
 * Output: 1
 * ===============================
 * Constraints:
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 * ==============================================
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
