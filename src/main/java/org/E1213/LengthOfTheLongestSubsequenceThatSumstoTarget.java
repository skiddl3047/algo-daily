package org.E1213;

import java.util.Arrays;
import java.util.List;

public class LengthOfTheLongestSubsequenceThatSumstoTarget {

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[] dp = new int[target + 1];
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                if (i == num || dp[i - num] > 0) {
                    dp[i] = Math.max(dp[i], 1 + dp[i - num]);
                }
            }
        }
        return dp[target] > 0 ? dp[target] : -1;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfTheLongestSubsequenceThatSumstoTarget().
                lengthOfLongestSubsequence(List.of(1,2,3), 2));
        System.out.println(new LengthOfTheLongestSubsequenceThatSumstoTarget().
                lengthOfLongestSubsequence(List.of(1,2,3), 3));
        System.out.println(new LengthOfTheLongestSubsequenceThatSumstoTarget().
                lengthOfLongestSubsequence(List.of(1,2,3,4,5), 9));
        System.out.println(new LengthOfTheLongestSubsequenceThatSumstoTarget().
                lengthOfLongestSubsequence(List.of(4,1,3,2,1,5), 7));
        System.out.println(new LengthOfTheLongestSubsequenceThatSumstoTarget().
                lengthOfLongestSubsequence(List.of(1,1,5,4,5), 3));
    }
}
