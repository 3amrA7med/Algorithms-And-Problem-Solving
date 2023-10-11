package com.playground.graph.medium.dijkstra;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 743. Network Delay Time
 * ========================
 * You are given a network of n nodes, labeled from 1 to n. You are also given times,
 * a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node,
 * vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 * We will send a signal from a given node k. Return the minimum time it takes for all the n nodes
 * to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 * =================
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 * Example 2:
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 * Example 3:
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
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

    /**
     * Runtime 9ms Beats 94.85%
     * Memory 46.48MB Beats 71.42%
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n + 1];
        distances[k] = 0;

        dijkstra(times, distances, visited);

        return getResult(distances);
    }

    public void dijkstra(int[][] times, int[] distances, boolean[] visited) {
        int minIndex = getMinDistanceNode(distances, visited);
        while(minIndex != -1) {
            for(int[] time: times){
                int src = time[0];
                int dst = time[1];
                int delay = time[2];
                if(src != minIndex) continue;

                if(distances[dst] > distances[src] + delay) distances[dst] = distances[src] + delay;
            }

            visited[minIndex] = true;
            minIndex = getMinDistanceNode(distances, visited);
        }
    }



    public int getMinDistanceNode(int[] distances, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 1; i < distances.length; i++) {
            if(!visited[i] && distances[i] < minDistance) {
                minDistance = distances[i];
                index = i;
            }
        }
        return index;
    }

    public int getResult(int[] distances) {
        int maxDistance = 0;
        for(int i = 1; i < distances.length; i++) {
            if(distances[i] == Integer.MAX_VALUE) return -1;
            if(distances[i] > maxDistance) {
                maxDistance = distances[i];
            }
        }
        return maxDistance;
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

    /**
     * Runtime 7 ms Beats 96.33%
     * Memory 48.2 MB Beats 11.17%
     */
    public int networkDelayTime2(int[][] times, int n, int k) {
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
