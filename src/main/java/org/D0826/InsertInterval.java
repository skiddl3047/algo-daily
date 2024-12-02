package org.D0826;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {

    //Time complexity: O(n) - We iterate through the intervals once, and each interval is considered and processed only once.
    //Space complexity: O(1) -  We only use the result (res) array to store output, so this could be considered O(1).
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> res = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        // Left part (no overlap with newInterval)
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        // Middle part (overlapping intervals with newInterval)
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval); // Add the merged interval
        // Right part (no overlap with newInterval)
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }

    /*
    Let N be the number of intervals.
         Time complexity: O(N)

        The binary search for finding the position to insert the newInterval has a time complexity of O(logN).
        However, the insertion of the newInterval into the list may take O(N) time in the worst case,
         as it could involve shifting elements within the list.
         Consequently, the overall time complexity is O(N+logN), which simplifies to O(N).

        Space complexity: O(N)

        We use the additional space to store the result (res) and perform calculations using res,
        so it does count towards the space complexity.
        In the worst case, the size of res will be proportional to the number of intervals in the input list.
     */
    public int[][] insertUsingBinarySearch(int[][] intervals, int[] newInterval) {
        // If the intervals vector is empty, return a vector containing the newInterval
        if (intervals.length == 0) {
            return new int[][] { newInterval };
        }
        int n = intervals.length;
        int target = newInterval[0];
        int left = 0, right = n - 1;
        // Binary search to find the position to insert newInterval
        while (left <= right) {
            int mid = (left + right) / 2;
            if (intervals[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // Insert newInterval at the found position
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < left; i++) {
            result.add(intervals[i]);
        }
        result.add(newInterval);
        for (int i = left; i < n; i++) {
            result.add(intervals[i]);
        }
        // Merge overlapping intervals
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : result) {
            // If res is empty or there is no overlap, add the interval to the result
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {// If there is an overlap, merge the intervals by updating the end of the last interval in res
                merged.getLast()[1] = Math.max(merged.getLast()[1],interval[1]);
            }
        }
        return merged.toArray(new int[0][]);
    }

    /*
    Append newInterval into intervals, and the problem effectively becomes the "Merge Intervals"
    problem: re-sort intervals, and the code is pretty-much self-explanatory.
    The trade-off for being lazy is O(nlogn) time and O(n) space (for Python),
    but it did well in tests - it beat 76% submissions. Now, if you need to insert m intervals, this is probably a bad idea.
     */
    //https://leetcode.com/problems/insert-interval/editorial/comments/2304939
    public List<int[]> insertOptimal(int[][] intervals, int[] newInterval) {
        // Convert the input array to a list and add the new interval
        List<int[]> intervalList = new ArrayList<>(Arrays.asList(intervals));
        intervalList.add(newInterval);

        // Sort intervals based on the starting point
        intervalList.sort(Comparator.comparingInt(a -> a[0]));

        // Initialize the answer list with the first interval
        List<int[]> result = new ArrayList<>();
        result.add(intervalList.getFirst());

        // Iterate through each interval to merge overlapping intervals
        for (int i = 1; i < intervalList.size(); i++) {
            int[] lastInterval = result.getLast();
            int[] currentInterval = intervalList.get(i);

            // Check for overlap
            if (lastInterval[1] < currentInterval[0]) {
                // No overlap, add the current interval to result
                result.add(currentInterval);
            } else {
                // Overlap, merge intervals
                lastInterval[1] = Math.max(lastInterval[1], currentInterval[1]);
            }
        }

        return result;
    }
}
