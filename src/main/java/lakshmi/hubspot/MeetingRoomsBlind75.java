package lakshmi.hubspot;

import java.util.Arrays;
import java.util.Comparator;

//Time Complexity Analysis - canAttendAllMeetings
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


//Time Complexity Analysis - canAttendAllMeetingsInLine
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

public class MeetingRoomsBlind75 {

    public static void main(String[] args) {
        int[][] intervals = {{7,14}, {9,11}, {0,5}, {2,6}};
        boolean flag = canAttendAllMeetings(intervals);
        boolean flag1 = canAttendAllMeetingsInLine(intervals);
        System.out.println(flag);
        System.out.println(flag1);
    }

    private static boolean canAttendAllMeetingsInLine(int[][] intervals) {
        if (intervals == null || intervals.length ==0){
            return true;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i< intervals.length-1; i++) {
            if(intervals[i+1][0] < intervals[i][1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean canAttendAllMeetings(int[][] intervals) {
        boolean canAttendAllMeetings = true;
        int length = intervals.length;
        int[] startTimes = new int[length];
        int[] endTimes = new int[length];
        for(int i =0 ; i< length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        int endPointer = 0;
        for (int startTime : startTimes) {
            if (startTime < endTimes[endPointer]) {
                canAttendAllMeetings = false;
                break;
            }
        }
        return canAttendAllMeetings;
    }
}
