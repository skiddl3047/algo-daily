package lakshmi.hubspot;

import java.util.Arrays;

//Time Complexity Analysis
//Extracting start and end times:O(N)
//Sorting both arrays:O(NlogN)
//Iterating through meetings using two pointers:O(N)
//
//Total Complexity: O(NlogN) (due to sorting)
//
//
//Space Complexity Analysis
//Uses two additional arrays startTimes[] and endTimes[] → O(N)
//Other variables (rooms, maxRooms, startPtr, endPtr) O(1) space.
//Total Space Complexity: O(N) (due to extra arrays)
public class MeetingRoomsIIBlind75 {

    public static void main(String[] args) {
        int[][] intervals = {{7,14}, {9,11}, {0,5}, {2,6}};
        int minMeetingRooms = findMinMeetingRooms(intervals);
        System.out.println(minMeetingRooms);
    }

    private static int findMinMeetingRooms(int[][] intervals) {
        int length = intervals.length;
        int[] startTimes = new int[length];
        int[] endTimes = new int[length];

        for(int i = 0; i< intervals.length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        int startPtr = 0, endPtr = 0, rooms = 0;
        while (startPtr < startTimes.length) {
            if (startTimes[startPtr] < endTimes[endPtr]) {
                rooms ++;
            } else {
                endPtr++;
            }
            startPtr++;
        }
        // Above while loop and startPtr++ can be replaced with
        // below for loop
        /* for (int startTime : startTimes) {
            if (startTime < endTimes[endPtr]) {
               rooms++;
            } else {
                endPtr++;
            }
        } */
        return rooms;
    }
}
