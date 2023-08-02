package com.playground.graph.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 841. Keys and Rooms
 */
public class KeysAndRooms {

    /**
     * 1ms Beats 85.44%
     * 43.33mb Beats 55.14%
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] canVisit = new boolean[rooms.size()];
        Deque<Integer> queue = new ArrayDeque<>();

        canVisit[0] = true;
        queue.addLast(0);
        while(!queue.isEmpty()) {
            int room = queue.removeFirst();
            List<Integer> keys = rooms.get(room);
            for(int i = 0; i < keys.size(); i++) {
                int key = keys.get(i);
                if(!canVisit[key]) { // Didn't visit before, then add it's key.
                    canVisit[key] = true;
                    queue.addLast(key);
                }
            }
        }

        for(int i = 0; i < canVisit.length; i++)
            if(!canVisit[i]) return false;

        return true;
    }
}
