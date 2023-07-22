package com.playground.graph.medium;

/**
 * 10. Course Schedule II, 100% runtime.
 */
public class CourseSchedule2 {

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
