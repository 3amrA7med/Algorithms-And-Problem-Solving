package com.playground.graph.medium.mst;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 1584. Min Cost to Connect All Points
 * Better solution would be adding all possible edges to one priority queue no need for multiple ones.
 * ====================================
 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between
 * them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
 * Return the minimum cost to make all points connected. All points are connected if there is exactly
 * one simple path between any two points.
 * ========================================
 * Prims Algorithm Implementation
 * =======================================
 * Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * Output: 20
 * We can connect the points as shown above to get the minimum cost of 20.
 * Notice that there is a unique path between every pair of points.
 */
public class MinCostToConnectAllPoints {

    static class Sol1Edge {
        int src;
        int dst;
        int weight;

        Sol1Edge(int s, int d, int[][] points){
            this.src = s;
            this.dst = d;
            this.weight = manhattanDistance(s,d,points);
        }

        int manhattanDistance(int s, int d, int[][] points) {
            return Math.abs(points[s][0] - points[d][0]) + Math.abs(points[s][1] - points[d][1]);
        }

    }

    /**
     * Runtime 100 ms Beats 47.49%
     * Memory 60.6 MB Beats 32.37%
     */
    public int minCostConnectPointsSol1(int[][] points) {
        PriorityQueue<Sol1Edge> edgesQueue = new PriorityQueue<>((a, b)-> Integer.compare(a.weight, b.weight));

        Set<Integer> mstSet = new HashSet<>();
        int pointToVisit = 0;
        int minCost = 0;
        while(mstSet.size() != points.length) {
            mstSet.add(pointToVisit);

            for(int j = 0; j < points.length; j++) {
                if(mstSet.contains(j)) continue;
                edgesQueue.offer(new Sol1Edge(pointToVisit, j, points));
            }

            while(edgesQueue.peek() != null && mstSet.contains(edgesQueue.peek().dst)) edgesQueue.poll();

            if(edgesQueue.peek() == null) break;
            Sol1Edge expandedEdge = edgesQueue.poll();
            pointToVisit = expandedEdge.dst;
            mstSet.add(expandedEdge.dst);
            minCost+= expandedEdge.weight;
        }

        return minCost;
    }

    // ==========================================================

    static class Edge {
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

        // O(n^2 log n)
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
                // Get rid of edges that is not safe anyway.
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
