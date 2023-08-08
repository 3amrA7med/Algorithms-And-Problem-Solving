package com.playground.graph.medium.topological_sort;

/**
 * 207. Course Schedule
 * We didn't complete topological sort algorithm as we only interested in detecting a cycle
 */
public class CourseSchedule {

    /*

    207. Course Schedule

     */
    class Node {
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
