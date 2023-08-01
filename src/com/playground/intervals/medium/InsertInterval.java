package com.playground.intervals.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. Insert Interval
 */
public class InsertInterval {

    /**
     * 1ms Beats 98.76%
     * 44.14mb Beats 35.73%
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) {
            int[][] res = new int[1][2];
            res[0] = new int[]{newInterval[0],newInterval[1]};
            return res;
        }

        List<int[]> result = new ArrayList<>();

        // Case 1: new interval is at the beginning
        if(newInterval[1] < intervals[0][0]) {
            result.add(newInterval);
            newInterval = null;
        }

        // Case 2: new interval is at the middle
        for(int i = 0; i < intervals.length; i++) {
            // No new intervals or new interval didn't yet come in the order
            if(newInterval == null || intervals[i][1] < newInterval[0]) result.add(intervals[i]);
                // Merge curr interval as it appears to end inside the new interval
            else if(intervals[i][1] < newInterval[1]) {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
            // Curr interval exceeded new interval end time so insert both in sequence
            else if(intervals[i][0] > newInterval[1]){
                result.add(newInterval);
                result.add(intervals[i]);
                newInterval = null;
            }
            // Merge 2 intervals and add new interval as end time is the same
            else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
                result.add(newInterval);
                newInterval = null;
            }
        }
        if(newInterval != null) result.add(newInterval);

        int[][] res = new int[result.size()][2];

        for(int i = 0; i < res.length; i++) res[i] = result.get(i);

        return res;
    }
}
