package com.playground.trees.medium.dfs;

import java.util.List;

/**
 * 1443. Minimum Time to Collect All Apples in a Tree
 * ===============================================
 * Given an undirected tree consisting of n vertices numbered from 0 to n-1, which has some apples in their vertices.
 * You spend 1 second to walk over one edge of the tree. Return the minimum time in seconds you have to spend to
 * collect all apples in the tree, starting at vertex 0 and coming back to this vertex.
 * The edges of the undirected tree are given in the array edges, where edges[i] = [ai, bi] means that exists an
 * edge connecting the vertices ai and bi. Additionally, there is a boolean array hasApple, where hasApple[i] = true
 * means that vertex i has an apple; otherwise, it does not have any apple.
 * ========================================
 * Example 1:
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
 * Output: 8
 * Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect
 * all apples is shown by the green arrows.
 * Example 2:
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,false,true,false]
 * Output: 6
 * Explanation: The figure above represents the given tree where red vertices have an apple. One optimal path to collect
 * all apples is shown by the green arrows.
 * Example 3:
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,false,false,false,false,false]
 * Output: 0
 * =======================================
 * Constraints:
 * 1 <= n <= 105
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai < bi <= n - 1
 * hasApple.length == n
 */
public class MinimumTimeToCollectAllApplesInATree {

    static class Node {
        int val;
        Node next;

        Node(int v, Node n) {
            this.val = v;
            this.next = n;
        }
    }

    /**
     * Runtime 14 ms Beats 100%
     * Memory 74.4 MB Beats 100%
     */
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Node[] graph = new Node[n];

        for(int[] edge: edges){
            Node newNode = new Node(edge[1], graph[edge[0]]);
            graph[edge[0]] = newNode;

            newNode = new Node(edge[0], graph[edge[1]]);
            graph[edge[1]] = newNode;
        }


        return dfs(graph, 0, -1, hasApple);
    }

    public int dfs(Node[] graph, int node, int par, List<Boolean> hasApple) {
        int res = 0;
        Node curr = graph[node];

        while(curr != null) {
            if(par == curr.val) {curr = curr.next; continue;}
            int pathRes = dfs(graph, curr.val, node, hasApple);
            if(hasApple.get(curr.val) || pathRes != 0) res+=2;
            res += pathRes;
            curr = curr.next;
        }

        return res;
    }
}
