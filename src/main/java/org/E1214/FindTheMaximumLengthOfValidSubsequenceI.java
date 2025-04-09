package org.E1214;

/*
You are given an integer array nums.
A subsequence sub of nums with length x is called valid if it satisfies:

(sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2.
Return the length of the longest valid subsequence of nums.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

Example 1:
Input: nums = [1,2,3,4]
Output: 4
Explanation: The longest valid subsequence is [1, 2, 3, 4].

Example 2:
Input: nums = [1,2,1,1,2,1,2]
Output: 6
Explanation: The longest valid subsequence is [1, 2, 1, 2, 1, 2].

Example 3:
Input: nums = [1,3]
Output: 2
Explanation: The longest valid subsequence is [1, 3].



Constraints:
2 <= nums.length <= 2 * 105
1 <= nums[i] <= 10 ^ 7
 */
public class FindTheMaximumLengthOfValidSubsequenceI {

    public int maximumLengthDP(int[] nums) {
        int res = 0, k = 2, dp[][] = new int[k][k];
        for (int a : nums) {
            for (int b = 0; b < k; b++) {
                dp[b][a % k] = dp[a % k][b] + 1;
                res = Math.max(res, dp[b][a % k]);
            }
        }
        return res;
    }

    public int maximumLength(int[] A) {
        int[] count = new int[2], end = new int[2];
        for (int a : A) {
            count[a % 2]++;
            end[a % 2] = end[1 - a % 2] + 1;
        }
        return Math.max(Math.max(count[0], count[1]), Math.max(end[0], end[1]));
    }
}
