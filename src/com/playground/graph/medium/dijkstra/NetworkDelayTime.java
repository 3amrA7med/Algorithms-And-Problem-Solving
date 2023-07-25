package com.playground.graph.medium.dijkstra;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 743. Network Delay Time
 */
public class NetworkDelayTime {


 public void run() {
        //[[2,1,1],[2,3,1],[3,4,1]]
        int[][] times = new int[][] {{2,1,1}, {2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;

        int result = this.networkDelayTime(times, n, k);

        System.out.println(result);
    }
     class Node {
        int val;
        Node next = null;
        int weight;

        Node(int v, int w, Node n) {
            this.val = v;
            this.weight = w;
            this.next = n;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Node [] graph = new Node[n+1];
        int[] distances = new int[n+1];
        Arrays.fill(distances, Integer.MAX_VALUE);

        for(int i = 0; i < times.length; i++) {
            Node newNode = new Node(times[i][1], times[i][2], graph[times[i][0]]);
            graph[times[i][0]] = newNode;
        }

        distances[k] = 0;
        dijkstra(graph, k, distances);

        int maxDistance = 0;
        for(int i = 1; i <= n; i++) {
            maxDistance = Math.max(distances[i], maxDistance);
        }

        if(maxDistance == Integer.MAX_VALUE) return -1;
        return maxDistance;
    }

    private void dijkstra(Node[] graph, int k, int[] distances) {
        Set<Integer> visited = new HashSet<>();
        for(int i = 1; i < graph.length; i++) {
            int minDistanceNode = getMinIndexNotVisited(distances, visited);
            // Relax its edges
            Node curr = graph[minDistanceNode];
            while(curr != null) {
                if(distances[curr.val] > distances[minDistanceNode] + curr.weight)
                   distances[curr.val] = distances[minDistanceNode] + curr.weight;
                curr = curr.next;
            }
            visited.add(minDistanceNode);
        }
    }

    private int getMinIndexNotVisited(int[] distances, Set<Integer> visited) {
        int minIndex = 0;
        int minValue = Integer.MAX_VALUE;

        for(int i = 1; i < distances.length; i++) {
            if(visited.contains(i)) continue;
            if(distances[i] < minValue) {
                minValue = distances[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
}
