package com.playground.graph.medium.union_find;

import java.util.Arrays;

/**
 * 684. Redundant Connection
 * ================================
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 * You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added.
 * The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed.
 * The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates
 * that there is an edge between nodes ai and bi in the graph.
 * Return an edge that can be removed so that the resulting graph is a tree of n nodes.
 * If there are multiple answers, return the answer that occurs last in the input.
 * ===================================
 * Input: edges = [[1,2],[1,3],[2,3]]
 * Output: [2,3]
 */
public class RedundantConnection {
    public void run() {
        int[][] edges = new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}};
        int[] ans = findRedundantConnection(edges);
        System.out.println(Arrays.toString(ans));
    }

    int[] parents;
    int[] ranks;

    /**
     * Beats 100.00%,
     * Beats 88.35%, 42.5, best 41.7
     * @param edges input edges
     * @return edge that cycle occurs at.
     */
    public int[] findRedundantConnection(int[][] edges) {
        parents = new int[edges.length + 1];
        ranks = new int[edges.length + 1];

        for(int i = 1; i <= edges.length; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }

        for(int i = 0; i < edges.length; i++) {
            if(!union(edges[i][0], edges[i][1])) return edges[i];
        }

        // Never reached.
        return null;
    }

    public int find(int n) {
        int p = parents[n];
        while(p != parents[p]) {
            parents[p] = parents[parents[p]];
            p = parents[p];
        }
        return p;
    }

    public boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        // Same parent, therefore are already connected and cycle is detected.
        if(p1 == p2) return false;

        if(ranks[p1] >= ranks[p2]) {
            parents[p2] = p1;
            ranks[p1]+= ranks[p2];
        }
        else {
            parents[p1] = p2;
            ranks[p2]+=ranks[p1];
        }
        return true;
    }
}
