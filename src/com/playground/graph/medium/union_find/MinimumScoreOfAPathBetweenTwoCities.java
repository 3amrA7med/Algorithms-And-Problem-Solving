package com.playground.graph.medium.union_find;

import java.util.*;

/**
 * 2492. Minimum Score of a Path Between Two Cities
 * ========================================
 * You are given a positive integer n representing n cities numbered from 1 to n. You are also given
 * a 2D array roads where roads[i] = [ai, bi, distancei] indicates that there is a bidirectional road between
 * cities ai and bi with a distance equal to distancei. The cities graph is not necessarily connected.
 * The score of a path between two cities is defined as the minimum distance of a road in this path.
 * Return the minimum possible score of a path between cities 1 and n.
 * Note:
 * A path is a sequence of roads between two cities.
 * It is allowed for a path to contain the same road multiple times, and you can visit cities 1 and n multiple times along the path.
 * The test cases are generated such that there is at least one path between 1 and n.
 * ===========================================
 * Example 1:
 * Input: n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]]
 * Output: 5
 * Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 -> 4. The score of this path is min(9,5) = 5.
 * It can be shown that no other path has less score.
 * Example 2:
 * Input: n = 4, roads = [[1,2,2],[1,3,4],[3,4,7]]
 * Output: 2
 * Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 -> 1 -> 3 -> 4. The score of this path is min(2,2,4,7) = 2.
 * ============================================
 * Constraints:
 * 2 <= n <= 105
 * 1 <= roads.length <= 105
 * roads[i].length == 3
 * 1 <= ai, bi <= n
 * ai != bi
 * 1 <= distancei <= 104
 * There are no repeated edges.
 * There is at least one path between 1 and n.
 */
public class MinimumScoreOfAPathBetweenTwoCities {

    public void run(){
        System.out.println(this.minScoreUnionFind(6, new int[][]{{4,5,7468},{6,2,7173},{6,3,8365},{2,3,7674},{5,6,7852},{1,2,8547},{2,4,1885},{2,5,5192},{1,3,4065},{1,4,7357}}));
    }

    /**
     * Runtime 7 ms Beats 97.81%
     * Memory 119.6 MB Beats 44.42%
     */
    public int minScoreUnionFind(int n, int[][] roads) {
        int[] par = new int[n+1];
        int[] rank = new int[n+1];

        for(int[] road: roads) {
            // initializations
            int src = road[0];
            int dst = road[1];

            if(par[src] == 0) {par[src] = src; rank[src] = 1;}
            if(par[dst] == 0) {par[dst] = dst; rank[dst] = 1;}

            union(src, dst, par, rank);
        }

        int res = Integer.MAX_VALUE;
        int parentOne = find(1, par);
        for(int[] road: roads) {
            int parent = find(road[0], par);
            if(parentOne == parent) res = Math.min(res, road[2]);
        }

        return res;
    }

    public int find(int node, int[] par) {
        int p = node;
        while(p != par[p]) {
            par[p] = par[par[p]];
            p = par[p];
        }
        return p;
    }

    public void union(int src, int dst, int[] par, int[] rank) {
        int parSrc = find(src, par);
        int parDst = find(dst, par);

        if(parSrc != parDst) {
            if(rank[parSrc] > rank[parDst]) {
                rank[parSrc] += rank[parDst];
                par[parDst] = parSrc;

            }
            else {
                rank[parDst] += rank[parSrc];
                par[parSrc] = parDst;
            }
        }
    }

    //================DFS=============================

    /**
     * Runtime 23 ms Beats 79.21%
     * Memory 100.3 MB Beats 96.72%
     */
    static class Node {
        int distance;
        int dst;
        Node next = null;

        Node(int d, int dst, Node n) {
            this.distance = d;
            this.dst = dst;
            this.next = n;
        }
    }

    int res = Integer.MAX_VALUE;
    Set<Integer> visitedSet;
    public int minScore(int n, int[][] roads) {
        Node[] graph = new Node[n+1];
        visitedSet = new HashSet<>();
        for(int[] road: roads) {
            Node newNode = new Node(road[2], road[1], graph[road[0]]);
            graph[road[0]] = newNode;

            newNode = new Node(road[2], road[0], graph[road[1]]);
            graph[road[1]] = newNode;
        }

        dfs(graph, 1);

        return res;
    }

    public void dfs(Node[] graph, int node) {
        if(visitedSet.contains(node)) return;

        visitedSet.add(node);

        Node curr = graph[node];
        while(curr != null) {
            if(curr.distance < res) res = curr.distance;
            dfs(graph, curr.dst);
            curr = curr.next;
        }
    }
}
