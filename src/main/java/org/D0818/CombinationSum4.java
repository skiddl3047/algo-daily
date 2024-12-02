package org.D0818;

import java.util.Arrays;
/*
Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.
 */
public class CombinationSum4 {

    int total = 0;
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += combinationSum4(nums, target - nums[i]);
            }
        }
        return res;
    }
    // with DP Top-Down Approach
    private int[] dp;

    public int combinationSum4DPTopDown(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }

    private int helper(int[] nums, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += helper(nums, target - nums[i]);
            }
        }
        dp[target] = res;
        return res;
    }

    public int combinationSum4DPBottomUP(int[] nums, int target) {
        int[] comb = new int[target + 1];
        comb[0] = 1;
        for (int i = 1; i < comb.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    comb[i] += comb[i - nums[j]];
                }
            }
        }
        return comb[target];
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum4().combinationSum4(new int[]{1,2,3}, 4));
        System.out.println(new CombinationSum4().combinationSum4DPTopDown(new int[]{1,2,3}, 4));
        System.out.println(new CombinationSum4().combinationSum4DPBottomUP(new int[]{1,2,3}, 4));
    }
}
