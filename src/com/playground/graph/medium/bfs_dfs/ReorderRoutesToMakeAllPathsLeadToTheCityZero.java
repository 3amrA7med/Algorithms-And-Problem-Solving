package com.playground.graph.medium.bfs_dfs;

import java.util.*;

/**
 * 1466. Reorder Routes to Make All Paths Lead to the City Zero
 */
public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {

    Map<Integer, List<Integer>> graph;
    Set<Integer> visited;
    int minReorder = 0;

    /**
     * 118ms Beats 39.99%, best ~40ms
     * 74.66mb Beats 42.06%, 63mb
     */
    public int minReorder(int n, int[][] connections) {
        graph = new HashMap<>();
        visited = new HashSet<>();
        List<Integer> neighbors;

        for(int i = 0; i < connections.length; i++) {
            neighbors = graph.getOrDefault(connections[i][0], new ArrayList<>());
            neighbors.add(connections[i][1]);
            graph.put(connections[i][0], neighbors);
            // Inverted Edge
            neighbors = graph.getOrDefault(connections[i][1], new ArrayList<>());
            neighbors.add(-1*connections[i][0]);
            graph.put(connections[i][1], neighbors);
        }

        minReorderDfs(connections, 0);
        return minReorder;
    }

    public void minReorderDfs(int[][] connections, int node) {
        if(visited.contains(node)) return;

        visited.add(node);
        List<Integer> neighbors = graph.get(node);
        for(int neighbor: neighbors) {
            if(visited.contains(neighbor) || visited.contains(-1*neighbor)) continue;
            if(neighbor < 0)  // No reorder needed.
                neighbor*=-1;
            else minReorder++;
            minReorderDfs(connections, neighbor);
        }
    }
}
