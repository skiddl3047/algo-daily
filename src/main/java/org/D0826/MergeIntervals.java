package org.D0826;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int[] interval : intervals) {
            // If res is empty or there is no overlap, add the interval to the result
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
                // If there is an overlap, merge the intervals by updating the end of the last interval in res
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1],interval[1]);
            }
        }
        //Converting List<int[]> to int[][]
        return merged.toArray(new int[0][]); // this will avoid type casting..
        //The 0 in new int[0][] ensures efficient memory usage while specifying the desired return type (int[][]).
        // It signals to toArray() that the exact size should be determined based on the list contents.
        //Why 0 is Preferred:
        //Conciseness: new int[0][] is minimal and readable.
        //Clarity: It focuses only on the type (int[][]), not the size.
        //Avoids Waste: No extra memory is allocated since the array is resized automatically.
    }

    public static void main(String[] args) {
        // test for pan
        int[][] testArray = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        for(int i=0; i < testArray.length; i++)
            for(int j=0; j< testArray[i].length; j++)
                System.out.println(" i : "+i+" j : "+j+" testArray["+i+"]["+j+"] : "+testArray[i][j]);

        System.out.println(Arrays.deepToString(new MergeIntervals().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(new MergeIntervals().merge(new int[][]{{1, 4}, {4, 5}})));

        System.out.println(Arrays.deepToString(new MergeIntervals().mergeSweepLineAlgorithm(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }

    public int[][] mergeSweepLineAlgorithm(int[][] intervals) {
        // Sweepline algorithm
        int max = 0;
        for (int[] interval : intervals)
            max = Math.max(interval[0], max);
        int[] mp = new int[max + 1];

        for (int[] interval : intervals)
            mp[interval[0]] = Math.max(interval[1] + 1, mp[interval[0]]); //start = interval[0]; end = interval[1];

        int r = 0;
        int initialStart = -1;
        int have = -1;
        for (int i = 0; i < mp.length; i++) {
            if (mp[i] != 0) {
                if (initialStart == -1)
                    initialStart = i;
                have = Math.max(mp[i] - 1, have);
            }
            if (have == i) {
                intervals[r++] = new int[] { initialStart, have };
                initialStart = -1;
                have = -1;
            }
        }
        if (initialStart != -1) {
            intervals[r++] = new int[] { initialStart, have };
        }
        if (intervals.length == r) {
            return intervals;
        }
        int[][] res = new int[r][];
        System.arraycopy(intervals, 0, res, 0, r);
        return res;
    }
}
