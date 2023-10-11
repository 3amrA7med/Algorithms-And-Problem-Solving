package com.playground.graph.medium.topological_sort;

import java.util.*;

/**
 * 1462. Course Schedule IV
 * ==========================
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must
 * take course ai first if you want to take course bi.
 * For example, the pair [0, 1] indicates that you have to take course 0 before you can take course 1.
 * Prerequisites can also be indirect. If course a is a prerequisite of course b, and course
 * b is a prerequisite of course c, then course a is a prerequisite of course c.
 * You are also given an array queries where queries[j] = [uj, vj]. For the jth query,
 * you should answer whether course uj is a prerequisite of course vj or not.
 * Return a boolean array answer, where answer[j] is the answer to the jth query.
 * =============================
 * Input: numCourses = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
 * Output: [false,true]
 * Explanation: The pair [1, 0] indicates that you have to take course 1 before you can take course 0.
 * Course 0 is not a prerequisite of course 1, but the opposite is true.
 * Example 2:
 * Input: numCourses = 2, prerequisites = [], queries = [[1,0],[0,1]]
 * Output: [false,false]
 * Explanation: There are no prerequisites, and each course is independent.
 * Example 3:
 * Input: numCourses = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
 * Output: [true,true]
 * ============================
 * Constraints:
 * 2 <= numCourses <= 100
 * 0 <= prerequisites.length <= (numCourses * (numCourses - 1) / 2)
 * prerequisites[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 * All the pairs [ai, bi] are unique.
 * The prerequisites graph has no cycles.
 * 1 <= queries.length <= 104
 * 0 <= ui, vi <= n - 1
 * ui != vi
 */
public class CourseScheduleIV {

    public void run() {
        System.out.println(this.checkIfPrerequisite(2,new int[][]{{1,0}},new int[][]{{0,1}, {1,0}}));
    }

    /**
     * Runtime 43ms Beats 58.70%
     * Memory 45.82MB Beats 83.60%
     */
    public List<Boolean> checkIfPrerequisite2(int numCourses, int[][] prerequisites, int[][] queries) {
        Node[] graph = new Node[numCourses];

        for(int[] pre: prerequisites) {
            int course = pre[0];
            int preRequisite = pre[1];
            Node newNode = new Node(preRequisite, graph[course]);
            graph[course] = newNode;
        }

        int[] status = new int[numCourses]; // 0-> not visited, 1-> visited
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int course = 0; course < numCourses; course++) {
            if(status[course] == 1) continue;
            dfs(map, graph, course, status);
        }

        List<Boolean> res = new ArrayList<>();
        for(int[] query: queries) {
            Set<Integer> set = map.get(query[0]);
            res.add(set.contains(query[1]));
        }

        return res;
    }

    public Set<Integer> dfs(Map<Integer, Set<Integer>> map, Node[] graph, int course, int[] status) {
        if(status[course] == 1) return map.get(course);

        Set<Integer> set = new HashSet<>();
        Node curr = graph[course];
        while(curr != null) {
            set.add(curr.courseNum);
            set.addAll(dfs(map, graph, curr.courseNum, status));
            curr = curr.next;
        }

        status[course] = 1;
        map.put(course, set);
        return set;
    }

    /**
     * Right but with time complexity O( (P+N) * Q)
     * we can utilize extra memory to have better time complexity
     */
    static class Node {
        int courseNum;
        Node next = null;
        Node(int c, Node n) {
            courseNum = c;
            next = n;
        }
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Node[] graph = new Node[numCourses];

        for(int[] pre: prerequisites) {
            int course = pre[0];
            int preRequisite = pre[1];
            Node newNode = new Node(preRequisite, graph[course]);
            graph[course] = newNode;
        }

        List<Boolean> res = new ArrayList<>();
        for(int[] query: queries) {
            int course = query[0];
            int courseToCheck = query[1];
            res.add(dfs(graph, course, courseToCheck));
        }

        return res;
    }

    public boolean dfs(Node[] graph, int course, int courseToCheck) {
        if(course == courseToCheck) return true;

        Node curr = graph[course];
        while(curr != null) {
            if(dfs(graph, curr.courseNum, courseToCheck)) return true;
            curr = curr.next;
        }

        return false;
    }
}
