package org.D0825;

public class SortColors {

    //Time complexity : O(N) since it's one pass along the array of length N.
    //Space complexity : O(1) since it's a constant space solution.
    /*
    https://leetcode.com/problems/sort-colors/editorial

    Let's use a three-pointer to track the rightmost boundary of zeros, the leftmost boundary of twos,
    and the current element under consideration.
        The idea of a solution is to move curr pointer along the array, if nums[curr] = 0 - swap it with nums[p0],
        if nums[curr] = 2 - swap it with nums[p2].

    Algorithm:
        Initialise the rightmost boundary of zeros: p0 = 0. During the algorithm execution nums[idx < p0] = 0.
        Initialise the leftmost boundary of twos: p2 = n - 1. During the algorithm execution nums[idx > p2] = 2.
        Initialise the index of the current element to consider: curr = 0.
        While curr <= p2 :
        If nums[curr] = 0: swap currth and p0th elements and move both pointers to the right.
        If nums[curr] = 2: swap currth and p2th elements. Move pointer p2 to the left.
        If nums[curr] = 1: move pointer curr to the right.

    Time complexity : O(N) since it's one pass along the array of length N.
    Space complexity : O(1) since it's a constant space solution.*/
    public void sortColors(int[] nums) {
        int lo = 0, hi = nums.length - 1, index = 0;

        while (index <= hi) {
            if      (nums[index] == 0) swap(nums, lo++, index++);
            else if (nums[index] == 2) swap(nums, index, hi--);
            else if (nums[index] == 1) index++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
