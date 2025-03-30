package lakshmi.hubspot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Sorting is the bottleneck at O(N log N), but merging is linear (O(N)).
//The space complexity does not exceed O(N), making it efficient in memory usage.
public class MergeIntervalsBlind75 {

    public static void main(String[] args) {
        int[][] intervals = {{1,5},{9,11},{2,7} };
        int [][] mergedIntervals = mergeIntervals(intervals);
        for(int[] inter : mergedIntervals) {
            System.out.println(inter[0] + "," + inter[1]);
        }
    }

    private static int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> mergedIntervalsList = new ArrayList<>();
        int[] newInterval = intervals[0];
        mergedIntervalsList.add(newInterval);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                newInterval = interval;
                mergedIntervalsList.add(newInterval);
            }
        }
        return mergedIntervalsList.toArray(new int[0][]);
    }

}
