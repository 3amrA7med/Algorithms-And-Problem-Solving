package com.playground.graph.medium.topological_sort;

/**
 * 207. Course Schedule
 * We didn't complete topological sort algorithm as we only interested in detecting a cycle
 * ==================================
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that
 * you must take course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 * ==============================
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 * ===========================
 * Constraints:
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 */
public class CourseSchedule {
    /**
     * Runtime 2 ms Beats 99.90%
     * Memory 44.4 MB Beats 23.85%
     */
    static class Node {
        int courseNumber;
        Node next = null;

        Node(int courseNumber, Node next) {
            this.courseNumber = courseNumber;
            this.next = next;
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Node[] graph = new Node[numCourses];
        int[] status = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            int referenceNode = prerequisites[i][0];
            int prerequisiteNode = prerequisites[i][1];
            Node node = new Node(prerequisiteNode, graph[referenceNode]);
            graph[referenceNode] = node;
        }

        for(int i = 0; i < numCourses; i++) {
            if(status[i] == 2) continue; // can finish no need to check.

            Node curr = graph[i];
            while(curr != null) {
                boolean result = visitNode(graph, status, curr.courseNumber);
                if(!result) return false;
                curr = curr.next;
            }
            status[i] = 2;
        }

        return true;
    }

    private boolean visitNode(Node[] graph, int[] status, int courseNumber){
        if(status[courseNumber] == 1) return false; // cycle detected.
        else if(status[courseNumber] == 2) return true; // can finish.

        status[courseNumber] = 1; // currently visiting.

        Node curr = graph[courseNumber];
        while(curr != null) {
            boolean result = visitNode(graph, status, curr.courseNumber);
            if(!result) return false;
            curr = curr.next;
        }

        status[courseNumber] = 2;
        return true;
    }


}
