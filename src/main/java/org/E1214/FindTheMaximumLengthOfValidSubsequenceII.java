package org.E1214;

/*
You are given an integer array nums and a positive integer k.
A subsequence sub of nums with length x is called valid if it satisfies:

(sub[0] + sub[1]) % k == (sub[1] + sub[2]) % k == ... == (sub[x - 2] + sub[x - 1]) % k.
Return the length of the longest valid subsequence of nums.


Example 1:
Input: nums = [1,2,3,4,5], k = 2
Output: 5
Explanation: The longest valid subsequence is [1, 2, 3, 4, 5].

Example 2:
Input: nums = [1,4,2,3,1,4], k = 3
Output: 4
Explanation: The longest valid subsequence is [1, 4, 1, 4].

 Constraints:

2 <= nums.length <= 103
1 <= nums[i] <= 107
1 <= k <= 103


Solution 3: 1D DP
Continue to learn optimised version in
3202. Find the Maximum Length of Valid Subsequence II


More DP problems
Here is small DP problem list.
Good luck and have fun.

Find the Maximum Length of Valid Subsequence II
Count the Number of Inversions
Find the Maximum Length of a Good Subsequence II
Maximum Difference Score in a Grid
Taking Maximum Energy From the Mystic Dungeon
Maximum Points After Collecting Coins From All Nodes
Minimum Increment Operations to Make Array Beautiful
Apply Operations to Make Two Strings Equal
Maximize the Profit as the Salesman
Maximum Earnings From Taxi
Maximum Number of Events That Can Be Attended II
Maximum Profit in Job Scheduling

 */
public class FindTheMaximumLengthOfValidSubsequenceII {

    //https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-ii/solutions/5389262/lis-approach-tabulation-easy-c-solution-o-n-n
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n][k];
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int mod = (nums[i] + nums[j]) % k;
                dp[i][mod] = Math.max(dp[i][mod], dp[j][mod] + 1);
                ans = Math.max(ans, dp[i][mod]+1);
            }
        }
        return ans;
    }
}
