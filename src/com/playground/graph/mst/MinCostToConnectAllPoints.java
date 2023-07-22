package com.playground.graph.mst;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 1584. Min Cost to Connect All Points
 *
 * Better solution would be adding all possible edges to one priority queue no need for multiple ones.
 */
public class MinCostToConnectAllPoints {

    class Edge {
        public int connectedPoint;
        public int weight;

        public Edge(int cP, int w) {
            connectedPoint = cP;
            weight = w;
        }
    }

    /**
     * Beats 18.65% 758 ms !!!, best 20~100ms !!
     * Beats 19.12% 82.2mb, best 50
     * @param points
     * @return
     */
    public int minCostConnectPoints(int[][] points) {
        if(points.length == 1) return 0;
        PriorityQueue<Edge>[] graph = new PriorityQueue[points.length];

        int minDistance = Integer.MAX_VALUE;
        int minDistancePoint = 0;

        // O(n^2 logn)
        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points.length; j++) {
                if(i==j) continue;
                if(graph[i] == null) graph[i] = new PriorityQueue<Edge>((a, b) -> Integer.compare(a.weight, b.weight));
                graph[i].offer(new Edge(j, getManhattanDistance(points[i], points[j])));
                if(graph[i].peek().weight < minDistance) {
                    minDistance = graph[i].peek().weight;
                    minDistancePoint = i;
                }
            }
        }

        Set<Integer> setOfVisitedPoints = new HashSet<>();
        Edge startEdge = graph[minDistancePoint].poll();
        setOfVisitedPoints.add(minDistancePoint);
        setOfVisitedPoints.add(startEdge.connectedPoint);
        int cost = startEdge.weight;

        // Prims Algorithm, O(n^2 logn)
        for(int i = 1; i < points.length - 1; i++) {

            minDistance = Integer.MAX_VALUE;
            minDistancePoint = 0;
            for(Integer point: setOfVisitedPoints) {
                // Get rif of edges that is not safe anyway.
                while(graph[point]!=null && setOfVisitedPoints.contains(graph[point].peek().connectedPoint))
                    graph[point].poll();
                if(graph[point]!=null && graph[point].peek().weight < minDistance) {
                    minDistance = graph[point].peek().weight;
                    minDistancePoint = point;
                }
            }
            Edge minDistanceEdge = graph[minDistancePoint].poll();
            setOfVisitedPoints.add(minDistanceEdge.connectedPoint);
            cost+= minDistanceEdge.weight;
        }

        return cost;
    }

    /**
     * Using the fact that prims algorithm can work with taking any node as our starting point then picking minimum edge we can reduce time ti
     * Beats 24.34% 673ms
     * @param points
     * @return
     */
    public int minCostConnectPoints2(int[][] points) {
        if(points.length == 1) return 0;
        PriorityQueue<Edge>[] graph = new PriorityQueue[points.length];

        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points.length; j++) {
                if(i==j) continue;
                if(graph[i] == null) graph[i] = new PriorityQueue<Edge>((a, b) -> Integer.compare(a.weight, b.weight));
                graph[i].offer(new Edge(j, getManhattanDistance(points[i], points[j])));

            }
        }

        Set<Integer> setOfVisitedPoints = new HashSet<>();
        Edge firstEdge = graph[0].poll();
        setOfVisitedPoints.add(0);
        setOfVisitedPoints.add(firstEdge.connectedPoint);
        int cost = firstEdge.weight;

        int minDistance = Integer.MAX_VALUE;
        int minDistancePoint = 0;

        // Prims Algorithm
        for(int i = 1; i < points.length - 1; i++) {

            minDistance = Integer.MAX_VALUE;
            minDistancePoint = 0;
            for(Integer point: setOfVisitedPoints) {
                // Get rif of edges that is not safe anyway.
                while(graph[point]!=null && setOfVisitedPoints.contains(graph[point].peek().connectedPoint))
                    graph[point].poll();
                if(graph[point]!=null && graph[point].peek().weight < minDistance) {
                    minDistance = graph[point].peek().weight;
                    minDistancePoint = point;
                }
            }
            Edge minDistanceEdge = graph[minDistancePoint].poll();
            setOfVisitedPoints.add(minDistanceEdge.connectedPoint);
            cost+= minDistanceEdge.weight;
        }

        return cost;
    }


    private int getManhattanDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }




    // ================================ Second solution, building graph upon need

    /**
     * Beats 42.25%, 419ms
     * memory Beats 55.37%, 60.40mb
     * @param points
     * @return
     */
    public int minCostConnectPoints3(int[][] points) {
        if(points.length == 1) return 0;
        PriorityQueue<Edge>[] graph = new PriorityQueue[points.length];
        Set<Integer> setOfVisitedPoints = new HashSet<>();
        addGraphEdgesToPoint(0, points, setOfVisitedPoints, graph);

        Edge firstEdge = graph[0].poll();
        setOfVisitedPoints.add(0);
        setOfVisitedPoints.add(firstEdge.connectedPoint);
        int cost = firstEdge.weight;

        int minDistance = Integer.MAX_VALUE;
        int minDistancePoint = 0;

        // Prims Algorithm
        for(int i = 1; i < points.length - 1; i++) {
            minDistance = Integer.MAX_VALUE;
            minDistancePoint = 0;
            for(Integer point: setOfVisitedPoints) {
                addGraphEdgesToPoint(point, points, setOfVisitedPoints, graph);
                // Get rif of edges that is not safe anyway.
                while(graph[point]!=null && setOfVisitedPoints.contains(graph[point].peek().connectedPoint))
                    graph[point].poll();
                if(graph[point]!=null && graph[point].peek().weight < minDistance) {
                    minDistance = graph[point].peek().weight;
                    minDistancePoint = point;
                }
            }
            Edge minDistanceEdge = graph[minDistancePoint].poll();
            setOfVisitedPoints.add(minDistanceEdge.connectedPoint);
            cost+= minDistanceEdge.weight;
        }

        return cost;
    }

    private void addGraphEdgesToPoint(int point, int[][]points, Set<Integer> setOfVisitedPoints, PriorityQueue<Edge>[] graph) {
        if(graph[point] != null) return;
        graph[point] = new PriorityQueue<Edge>((a, b) -> Integer.compare(a.weight, b.weight));
        for(int i = 0; i < points.length; i++) {
            if(i == point || setOfVisitedPoints.contains(i)) continue;
            graph[point].offer(new Edge(i, getManhattanDistance(points[point], points[i])));
        }
    }
}
