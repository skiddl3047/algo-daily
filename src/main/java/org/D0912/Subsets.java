package org.D0912;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
Input: nums = [0]
Output: [[],[0]]


Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
 */
public class Subsets {


    /*
    Time complexity: O(N×2^N) to generate all subsets and then copy them into the output list.

    Space complexity: O(N). We are using O(N) space to maintain curr, and are modifying curr in-place with backtracking.
    Note that for space complexity analysis, we do not count space that is only used for the purpose of returning output, so the output array is ignored.


     */
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();
    int n, k;
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        for (k = 0; k <= n; k++){
            backtrack(0, nums);
        }
        return result;
    }

    private void backtrack(int start, int[] nums) {
        if (subset.size() == k) {
            result.add(new ArrayList<>(subset));
            return;
        }
        for(int i = start; i< n; i++){
            subset.add(nums[i]);
            backtrack(i+1,nums);
            subset.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1,2,3}));
    }

}
