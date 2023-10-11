package com.playground.intervals.medium;

import java.util.Arrays;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 * LeetCode 75
 * ==================================
 * There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are
 * represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal
 * diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.
 * Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis.
 * A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the
 * number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
 * Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 * ===================================
 * Example 1:
 * Input: points = [[10,16],[2,8],[1,6],[7,12]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
 * - Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
 * Example 2:
 * Input: points = [[1,2],[3,4],[5,6],[7,8]]
 * Output: 4
 * Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.
 * Example 3:
 * Input: points = [[1,2],[2,3],[3,4],[4,5]]
 * Output: 2
 * Explanation: The balloons can be burst by 2 arrows:
 * - Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
 * - Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
 * =======================================
 * Constraints:
 * 1 <= points.length <= 105
 * points[i].length == 2
 * -231 <= xstart < xend <= 231 - 1
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public void run() {
        System.out.println(this.findMinArrowShots2(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
    }

    /**
     * Removing lower val as it doesn't contribute to the answer.
     * Runtime 51 ms Beats 79.56%
     * Memory 75.9 MB Beats 81.78%
     */
    public int findMinArrowShots2(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[0], b[0]));

        int numOfArrows = 1;
        int higherVal = Integer.MAX_VALUE;

        for (int[] point : points) {
            // Check if we can group this balloon with the previous balloons.
            if (point[0] <= higherVal) {
                higherVal = Math.min(higherVal, point[1]);
            } else { // Start a new group
                numOfArrows++; // Shoot previous group
                higherVal = point[1];
            }
        }

        return numOfArrows;
    }

    /**
     * Sorting by end time doesn't enhance the computation time.
     * Runtime 51 ms Beats 79.56%
     * Memory 76.2 MB Beats 74.26%
     */
    public int findMinArrowShots1(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));

        int numOfArrows = 1;
        int higherVal = points[0][1];

        for (int[] point : points) {
            // Check if we can group this balloon with the previous balloons.
            if (point[0] <= higherVal) {
                continue;
            } else { // Start a new group
                numOfArrows++; // Shoot previous group
                higherVal = point[1];
            }
        }

        return numOfArrows;
    }

    /**
     * Runtime 55 ms Beats 34.13%
     * Memory 75.9 MB Beats 84.16%
     */
    public int findMinArrowShots3(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[0], b[0]));

        int numOfArrows = 1;
        int lowerVal = Integer.MIN_VALUE;
        int higherVal = Integer.MAX_VALUE;

        for(int i = 0; i < points.length; i++) {
            // Check if we can group this balloon with the previous balloons.
            if(points[i][0] <= higherVal) {
                lowerVal = Math.max(lowerVal, points[i][0]);
                higherVal = Math.min(higherVal, points[i][1]);
            }
            else { // Start a new group
                numOfArrows++; // Shoot previous group
                lowerVal = points[i][0];
                higherVal = points[i][1];
            }
        }

        return numOfArrows;
    }
}
