package com.playground.graph.medium.bellman_ford;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 787. Cheapest Flights Within K Stops
 * Solve again
 * important
 * =====================
 * There are n cities connected by some number of flights. You are given an array flights
 * where flights[i] = [from i, to i, price i] indicates that there is a flight from city from i to city to i with cost price i.
 * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops.
 * If there is no such route, return -1.
 * =============================
 * Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
 * Output: 700
 * Explanation:
 * The graph is shown above.
 * The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
 * Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
 */
public class CheapestFlightsWithinKStops {
    public void run () {
        int[][] f = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        int n = 5;
        int src = 0;
        int dst = 2;
        int k = 2;
        System.out.println(this.findCheapestPrice(n, f, src, dst, k));
    }

    /**
     * Runtime 7ms Beats 47.89%
     * Memory 43.18MB Beats 73.79%
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Integer[] prices = new Integer[n];
        prices[src]= 0;
        for(int i = 0; i <= k; i++) {
            Integer[] tempPrices = prices.clone();
            for(int j = 0; j < flights.length; j++) {
                int from = flights[j][0];
                int to = flights[j][1];
                int price = flights[j][2];

                if(prices[from] == null) continue;
                if(tempPrices[to] == null || tempPrices[to] > prices[from] + price) tempPrices[to] = prices[from] + price;
            }
            prices = tempPrices;
        }
        return (prices[dst] == null)? -1: prices[dst];
    }


    /**
     * 97.45% 4ms
     * 57.23% 43.5, best 41
     * @param n nodes
     * @param flights edges
     * @param src src node
     * @param dst dst node
     * @param k at most
     * @return min cost
     */
    public int findCheapestPriceBellmanFord(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for(int i = 0; i <= k; i++) {
            int[] tempPrices = prices.clone();
            for(int j = 0; j < flights.length; j++) {
                int s = flights[j][0];
                int d = flights[j][1];
                int c = flights[j][2];
                if(prices[s] == Integer.MAX_VALUE) continue;
                if(prices[s] + c < tempPrices[d]) tempPrices[d] = prices[s] + c;
            }
            prices = tempPrices;
        }

        return (prices[dst] == Integer.MAX_VALUE)? -1: prices[dst];
    }
    /*

    Failed attempt because of the example given
    public void run () {
        int[][] f = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        int n = 5;
        int src = 0;
        int dst = 2;
        int k = 2;
        System.out.println(this.findCheapestPrice(n, f, src, dst, k));
    }
    static class Node {
        int node;
        int cost;
        Node next;

        Node(int n, int c, Node nex) {
            node = n;
            cost = c;
            next = nex;
        }
    }

    Node[] graph;
    int[] minCost;
    boolean[] visited;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        graph = new Node[n];
        minCost = new int[n];
        visited = new boolean[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);

        for(int i = 0; i < flights.length; i++) {
            Node newNode = new Node(flights[i][1], flights[i][2], graph[flights[i][0]]);
            graph[flights[i][0]] = newNode;
        }

        bfs(k, src);

        return (minCost[dst] == Integer.MAX_VALUE)? -1: minCost[dst];
    }

    private void bfs(int k, int src) {
        minCost[src] = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(src);
        while(!queue.isEmpty() && k >= 0) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int node = queue.removeFirst();
                Node curr = graph[node];
                while(curr!=null) {
                    relaxEdge(minCost[node], curr);
                    if(!visited[curr.node]) queue.addLast(curr.node);
                    curr = curr.next;
                }
                visited[node] = true;
            }
            k--;
        }

    }

    private void relaxEdge(int cost, Node edge) {
        if(minCost[edge.node] > cost + edge.cost)
            minCost[edge.node] = cost + edge.cost;
    }

    private int getMinCost() { // O(n)
        int minIndex = -1;
        int minCostVal = Integer.MAX_VALUE;
        for(int i = 0; i < minCost.length; i++) {
            if(!visited[i] && minCost[i] < minCostVal) {
                minIndex = i;
                minCostVal = minCost[i];
            }
        }
        return minIndex;
    }


     */
}
