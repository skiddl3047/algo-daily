package org.E1214;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        int previousEndTime = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (start >= previousEndTime)
                previousEndTime = end;
            else
                ans++;
        }
        return ans;
    }

    public int eraseOverlapIntervalsApproach2(int[][] intervals) {
        if (intervals.length == 0)
            return 0;
        // Sort the intervals based on the end time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 1;
        // end time of the first/current interval
        int previous_interval = 0;
        for (int i = 1; i < intervals.length; i++) {
            // If the start time of the next interval is greater than or equal to
            // the end time of the current interval, then we can keep it
            if (intervals[i][0] >= intervals[previous_interval][1]) {
                previous_interval = i;
                count++;
            }
        }
        // Return the number of intervals to remove
        return intervals.length - count;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2},{2,3},{3,4},{1,3}};
        System.out.println(new NonOverlappingIntervals435().eraseOverlapIntervals(intervals));

        intervals = new int[][]{{1,2},{1,3},{3,4},{2,3}};
        System.out.println(new NonOverlappingIntervals435().eraseOverlapIntervals(intervals));
    }
}
