package org.D0902;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

    /*
    Time complexity : O(nlogn).
    The time complexity is dominated by sorting. Once the array has been sorted, only O(n) time is taken to go through the array and determine if there is any overlap.

Space complexity : O(1).
Since no additional space is allocated.
     */
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }
}
