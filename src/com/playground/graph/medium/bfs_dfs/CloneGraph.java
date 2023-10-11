package com.playground.graph.medium.bfs_dfs;

import java.util.*;

/**
 * 133. Clone Graph
 * ===========================
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 */
public class CloneGraph {

    /**
     * Runtime 25 ms Beats 95.76%
     * Memory 42.1 MB Beats 26.69%
     */
    public void run() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        List<Node> nb1 = new ArrayList<>();
        nb1.add(n2);
        nb1.add(n3);
        List<Node> nb2 = new ArrayList<>();
        nb2.add(n1);
        nb2.add(n3);
        List<Node> nb3 = new ArrayList<>();
        nb3.add(n2);
        nb3.add(n4);
        List<Node> nb4 = new ArrayList<>();
        nb4.add(n1);
        nb4.add(n3);
        n1.neighbors = nb1;
        n2.neighbors = nb2;
        n3.neighbors = nb3;
        n4.neighbors = nb4;

        Node cloned = this.cloneGraph(n1);
    }


    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        bfs(map, node);
        return map.get(node);
    }

    private void bfs(Map<Node, Node> map, Node head) {
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visitedNodes = new HashSet<>();

        queue.offer(head);
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            if(visitedNodes.contains(curr.val)) continue;

            visitedNodes.add(curr.val);
            Node clonedCurr = map.getOrDefault(curr, new Node(curr.val));
            map.put(curr, clonedCurr);

            for(Node neighbor: curr.neighbors) {
                Node clonedNeighbor = map.getOrDefault(neighbor , new Node(neighbor.val));
                clonedCurr.neighbors.add(clonedNeighbor);
                map.put(neighbor, clonedNeighbor);
                queue.offer(neighbor);
            }
        }
    }

}
