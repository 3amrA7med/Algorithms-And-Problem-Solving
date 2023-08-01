package com.playground.intervals.medium;

import java.util.Arrays;

/**
 * 435. Non-overlapping Intervals
 */
public class NonOverlappingIntervals {

    /**
     * 49ms Beats 97.48%
     * 76.98mb Beats 97.91%
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 1) return 0;
        int res = 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));

        int prevIntervalEndTime = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= prevIntervalEndTime) prevIntervalEndTime = intervals[i][1];
            else {
                res++;
                prevIntervalEndTime = Math.min(prevIntervalEndTime, intervals[i][1]);
            }
        }
        return res;
    }
}
