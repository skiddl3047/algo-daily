package org.D0831;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges {

    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;
        List<List<Integer>> missingRanges = new ArrayList<>();
        if (n == 0) {
            missingRanges.add(Arrays.asList(lower, upper));
            return missingRanges;
        }
        // Check for any missing numbers between the lower bound and nums[0].
        if (lower < nums[0]) {
            missingRanges.add(Arrays.asList(lower, nums[0] - 1));
        }
        // Check for any missing numbers between successive elements of nums.
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] == 1) {
                continue;
            }
            missingRanges.add(Arrays.asList(nums[i] + 1, nums[i + 1] - 1));
        }
        // Check for any missing numbers between the last element of nums and the upper bound.
        if (upper > nums[n - 1]) {
            missingRanges.add(Arrays.asList(nums[n - 1] + 1, upper));
        }
        return missingRanges;
    }

    public static void main(String[] args) {
        System.out.println(new MissingRanges().findMissingRanges(new int[]{0,1,3,50,75},0,99));
        System.out.println(new MissingRanges().findMissingRanges(new int[]{-1,0,1,2,3},0,99));
        System.out.println(new MissingRanges().findMissingRanges(new int[]{-1},-1,-1));

        System.out.println(new MissingRanges().findMissingRangesLessLines(new int[]{0,1,3,50,75},0,99));
        System.out.println(new MissingRanges().findMissingRangesLessLines(new int[]{-1,0,1,2,3},0,99));
        System.out.println(new MissingRanges().findMissingRangesLessLines(new int[]{-1},-1,-1));
    }

    public List<List<Integer>> findMissingRangesLessLines(int[] nums, int lower, int upper) {
        List<List<Integer>> answer = new ArrayList<>();
        int prev = lower - 1, n = nums.length;

        for (int i = 0; i <= n; ++i) {
            int curr = i< n ? nums[i] : upper + 1;
            // checking previous element with current element
            if (prev + 1 <= curr - 1) {
                answer.add(Arrays.asList(prev + 1, curr - 1));
            }
            prev = curr;
        }
        return answer;
    }
}
