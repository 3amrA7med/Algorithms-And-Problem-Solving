package com.playground.graph.medium.union_find;

import java.util.Arrays;

/**
 * 684. Redundant Connection
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
