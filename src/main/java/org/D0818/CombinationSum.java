package org.D0818;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of distinct integers candidates and a target integer target,
return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 */
// I/P : [2,3,6,7] Target : 7 O/P : [2,2,3], [7]
public class CombinationSum {

    List<List<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> ls = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums, target, 0);
        return ans;
    }

    public void backtrack(int[] nums, int target, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(ls));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] <= target) {
                ls.add(nums[i]);
                backtrack(nums, target - nums[i], i);
                ls.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{1,2,3}, 7));
        System.out.println(new CombinationSum().combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(new CombinationSum().combinationSum(new int[]{2,3,5}, 8));

        System.out.println(new CombinationSum().combinationSum(new int[]{5,2,3}, 8));
    }
}
