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
        for (int num : nums) {
            if (target >= num) {
                res += combinationSum4(nums, target - num);
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
        for (int num : nums) {
            if (target >= num) {
                res += helper(nums, target - num);
            }
        }
        dp[target] = res;
        return res;
    }

    public int combinationSum4DPBottomUP(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int pos = 1; pos < dp.length; pos++) {
            for (int num : nums) {
                if (pos - num >= 0) {
                    dp[pos] += dp[pos - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum4().combinationSum4(new int[]{1,2,3}, 4));
        System.out.println(new CombinationSum4().combinationSum4DPTopDown(new int[]{1,2,3}, 4));
        System.out.println(new CombinationSum4().combinationSum4DPBottomUP(new int[]{1,2,3}, 4));
        System.out.println(new CombinationSum4().combinationSum4DPBottomUP(new int[]{1,3,4}, 4));
    }
}
