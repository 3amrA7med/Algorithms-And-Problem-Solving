package com.playground.graph.medium.topological_sort;

/**
 * 10. Course Schedule II, 100% runtime.
 * ==================================
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must
 * take course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers,
 * return any of them. If it is impossible to finish all courses, return an empty array.
 * ====================================
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have
 * finished course 0. So the correct course order is [0,1].
 */
public class CourseSchedule2 {

    /**
     * Runtime 2ms Beats 99.95%
     * Memory 44.36MB Beats 87.27%
     */
    int[] result;
    int coursesNeeded = 0;
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        Node[] graph = new Node[numCourses];

        for(int[] pre: prerequisites) {
            int course = pre[0];
            int preRequisite = pre[1];
            Node newNode = new Node(preRequisite, graph[course]);
            graph[course] = newNode;
        }

        int[] status = new int[numCourses]; // 0-> not visited, 1-> currently visited, 2-> visited
        result = new int[numCourses];
        for(int course = 0; course < numCourses; course++) {
            if(!dfs(graph, course, status)) return new int[0];
        }

        return result;
    }

    public boolean dfs(Node[] graph, int course, int[] status) {
        if(status[course] == 1) return false;
        if(status[course] == 2) return true;

        status[course] = 1;
        Node curr = graph[course];
        while(curr != null) {
            if(!dfs(graph, curr.courseNum, status)) return false;
            curr = curr.next;
        }

        status[course] = 2;
        result[coursesNeeded++] = course;
        return true;
    }

    class Node {
        int courseNum;
        Node next = null;
        Node(int c, Node n) {
            courseNum = c;
            next = n;
        }
    }

    int currResultIndex = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Node[] graph = new Node[numCourses];
        int[] result = new int[numCourses];
        int[] status = new int[numCourses];


        for(int i = 0; i < prerequisites.length ; i++) {
            Node node = new Node(prerequisites[i][1], graph[prerequisites[i][0]]);
            graph[prerequisites[i][0]] = node;
        }

        for(int i = 0; i < numCourses; i++) {
            if(status[i] == 2) continue;

            Node curr = graph[i];
            while(curr != null) {
                if(!visitNode(graph, status, result, curr.courseNum)) return new int[0];
                curr = curr.next;
            }
            // Mark as done
            status[i] = 2;
            result[this.currResultIndex++] = i;
        }
        return result;
    }

    private boolean visitNode(Node[] graph, int[] status, int[] result, int courseNum) {
        if(status[courseNum] == 1) return false;
        else if (status[courseNum] == 2) return true;

        status[courseNum] = 1;

        Node curr = graph[courseNum];
        while(curr != null) {
            if(!visitNode(graph, status, result, curr.courseNum)) return false;
            curr = curr.next;
        }
        // Mark as done
        status[courseNum] = 2;
        result[this.currResultIndex++] = courseNum;

        return true;
    }

}
