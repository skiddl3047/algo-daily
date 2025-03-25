package hubspot;

import java.util.Arrays;

/*
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.



Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2

Example 2:
Input: intervals = [[7,10],[2,4]]
Output: 1

Constraints:
1 <= intervals.length <= 104
0 <= starti < endi <= 106
 */
public class MeetingRoomsII {
    /*
    Time Complexity: O(NlogN) because all we are doing is sorting the two arrays for start timings and end timings individually
    and each of them would contain N elements considering there are N intervals.

    Space Complexity: O(N) because we create two separate arrays of size N, one for recording the start times and one for the end times.
     */
    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsItr = 0;
        for (int start : starts) {
            if (start < ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
    }
}
