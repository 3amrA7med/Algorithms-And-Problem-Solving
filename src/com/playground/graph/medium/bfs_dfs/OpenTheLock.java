package com.playground.graph.medium.bfs_dfs;

import java.util.*;

/**
 * 752. Open the Lock
 * ========================
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots:
 * '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around:
 * for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the
 * lock will stop turning, and you will be unable to open it.
 * Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of
 * turns required to open the lock, or -1 if it is impossible.
 *
 */
public class OpenTheLock {

    public void run() {
        System.out.println(this.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
    }

    /**
     * Runtime 74 ms Beats 82.7%
     * Memory 46.8 MB Beats 66.1%
     */
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        if(set.contains("0000")) return -1;

        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        int turns = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String node = queue.poll();
                if(node.equals(target)) return turns;
                for(String child: getChildren(node)) {
                    if(!set.contains(child)) {
                        set.add(child);
                        queue.add(child);
                    }
                }
            }
            turns++;
        }

        return -1;
    }

    public List<String> getChildren(String node) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            char[] nodeArr = node.toCharArray();
            int c = nodeArr[i] - '0';
            nodeArr[i] = (char) ((c+1)%10 + '0');
            res.add(new String(nodeArr));
            nodeArr[i] = (char)((c-1+10)%10 + '0');
            res.add(new String(nodeArr));
        }
        return res;
    }
}
