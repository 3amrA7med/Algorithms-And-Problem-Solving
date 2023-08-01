package com.playground.intervals.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. Merge Intervals
 */
public class MergeIntervals {

    /**
     * 8ms Beats 97.11%
     * 45.02mb Beats 98.72%
     */
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return intervals;

//        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // better
         Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();

        int[] currInterval = intervals[0];
        for(int i = 1; i < intervals.length; i++) {

            // curr interval ends before next one
            if(currInterval[1] < intervals[i][0]){
                res.add(currInterval);
                currInterval = intervals[i];
            }
            // merge
            else {
                currInterval[0] = Math.min(currInterval[0], intervals[i][0]);
                currInterval[1] = Math.max(currInterval[1], intervals[i][1]);
            }
        }

        res.add(currInterval);

        int[][] result = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++) result[i] = res.get(i);
        return result;
    }
}
