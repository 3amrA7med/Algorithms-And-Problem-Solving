package com.playground.heap.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 973. K Closest Points to Origin
 * ==================================
 * Beats 64.78%, 34ms, best ~20ms, super 2ms
 * Beats 67.12%, 49mb, best 45mb
 */
public class KClosestPointsToOrigin {

    public void run() {
        int[][] points = new int[][] {{-5,4},{-6,-5},{4,6}};
        System.out.println(Arrays.deepToString(this.kClosest1(points, 2)));
    }

    /**
     * Runtime 20 ms Beats 91.30%
     * Memory 52.2 MB Beats 44.86%
     */
    static class Point {
        int[] val;
        int dist;

        Point(int[] p) {
            this.val = p;
            this.dist = getEucDistance(p);
        }

        private int getEucDistance(int[] point) {
            return (point[0]*point[0]+point[1]*point[1]);
        }
    }

    public int[][] kClosest1(int[][] points, int k) {
        int[][] result = new int[k][2];

        PriorityQueue<Point> pQueue = new PriorityQueue<>(k, (a,b)-> Integer.compare(a.dist, b.dist));

        for (int[] point : points) pQueue.offer(new Point(point));

        for(int i = 0; i <  k; i ++)
            result[i] = pQueue.poll().val;

        return result;
    }


    // ========================================

    class pQueuePointsComparator implements Comparator<int[]> {
        public int compare(int[] point1, int[] point2)
        {
            int dist1 = getEucDistance(point1);
            int dist2 = getEucDistance(point2);
            return Integer.compare(dist2, dist1);
        }
    }

    /**
     * we will be saving lowest distance k, so we will be needing max heap to extract max value if the new point is better.
     */
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];

        PriorityQueue<int[]> pQueue = new PriorityQueue<>(k, new pQueuePointsComparator());

        for(int i = 0; i < k; i++)
            pQueue.offer(points[i]);

        for(int i = k; i < points.length; i++) {
            int[] point = pQueue.peek();
            int dist1 = getEucDistance(point);
            int dist2 = getEucDistance(points[i]);
            if(dist1 > dist2) {
                pQueue.poll();
                pQueue.offer(points[i]);
            }
        }

        for(int i = 0; i <  k; i ++)
            result[i] = pQueue.poll();

        return result;
    }

    private int getEucDistance(int[] point) {
        return (point[0]*point[0]+point[1]*point[1]);
    }
}
