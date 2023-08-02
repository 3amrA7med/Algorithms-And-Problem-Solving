package com.playground.graph.medium.bfs_dfs;

import java.util.*;

/**
 * 547. Number of Provinces
 */
public class NumberOfProvinces {
    public void run() {
        System.out.println(findCircleNum(new int[][] {{1,1,0},{1,1,0},{0,0,1}}));
    }
    Set<Integer> visitedNodes;
    int numOfProvinces = 0;

    /**
     * 1ms Beats 99.46%
     * 46.13mb Beats 20.32%
     */
    public int findCircleNum(int[][] isConnected) {
        if(isConnected.length == 1) return 1;
        visitedNodes = new HashSet<>();

        for(int i = 0; i < isConnected.length; i++) {
            if(visitedNodes.contains(i)) continue;
            findCircleNumDfs(isConnected, i);
            numOfProvinces++;
        }

        return numOfProvinces;
    }

    public void findCircleNumDfs(int[][] isConnected, int node) {
        if(visitedNodes.contains(node)) return;

        visitedNodes.add(node);
        for(int i = 0; i < isConnected[node].length; i++)
            if(isConnected[node][i] == 1 && node != i) findCircleNumDfs(isConnected, i);
    }
}
