package com.playground.graph.medium.bfs_dfs;

import java.util.*;

/**
 * 547. Number of Provinces
 * ==========================================
 * There are n cities. Some of them are connected, while some are not. If city 'a' is connected directly
 * with city b, and city b is connected directly with city c, then city 'a' is connected indirectly with city c.
 * A province is a group of directly or indirectly connected cities and no other cities outside the group.
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are
 * directly connected, and isConnected[i][j] = 0 otherwise.
 * Return the total number of provinces.
 */
public class NumberOfProvinces {
    public void run() {
        System.out.println(findCircleNumUnionFind(new int[][] {{1,1,0},{1,1,0},{0,0,1}}));
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

    //==============================

    /**
     * Wrong test case
     * [[1,1,0,0,0,0,0,1,0,0,0,0,0,0,0],
     * [1,1,0,0,0,0,0,0,0,0,0,0,0,0,0],
     * [0,0,1,0,0,0,0,0,0,0,0,0,0,0,0],
     * [0,0,0,1,0,1,1,0,0,0,0,0,0,0,0],
     * [0,0,0,0,1,0,0,0,0,1,1,0,0,0,0],
     * [0,0,0,1,0,1,0,0,0,0,1,0,0,0,0],
     * [0,0,0,1,0,0,1,0,1,0,0,0,0,1,0],
     * [1,0,0,0,0,0,0,1,1,0,0,0,0,0,0],
     * [0,0,0,0,0,0,1,1,1,0,0,0,0,1,0],
     * [0,0,0,0,1,0,0,0,0,1,0,1,0,0,1],
     * [0,0,0,0,1,1,0,0,0,0,1,1,0,0,0],
     * [0,0,0,0,0,0,0,0,0,1,1,1,0,0,0],
     * [0,0,0,0,0,0,0,0,0,0,0,0,1,0,0],
     * [0,0,0,0,0,0,1,0,1,0,0,0,0,1,0],
     * [0,0,0,0,0,0,0,0,0,1,0,0,0,0,1]]
     */

    public int findCircleNumUnionFind(int[][] isConnected) {
        int n = isConnected.length;
        int[] par = new int[n];
        int[] rank = new int[n];
        for(int r = 0; r < n; r++) {
            if(par[r] == 0) {par[r] = r; rank[r] = 1;}
            for(int c = 0; c < n; c++) {
                if(par[c] == 0) {par[c] = c; rank[c] = 1;}
                if(isConnected[r][c] == 1 && r != c) union(r, c, par, rank);
            }
        }

        Set<Integer> setOfParents = new HashSet<>();
        for(int parent: par) setOfParents.add(parent);

        return setOfParents.size();
    }

    public int find(int n, int[] par) {
        int p = par[n];

        while(p != par[p]) {
            par[p] = par[par[p]];
            p = par[p];
        }
        return p;
    }

    public void union(int src, int dst, int[] par, int[] rank) {
        int par1 = find(src, par);
        int par2 = find(dst, par);

        if(par1 == par2) return;

        if(rank[par1] >= rank[par2]) {
            rank[par1] += rank[par2];
            par[par2] = par1;
        }
        else {
            rank[par2] += rank[par1];
            par[par1] = par2;
        }
    }
}
