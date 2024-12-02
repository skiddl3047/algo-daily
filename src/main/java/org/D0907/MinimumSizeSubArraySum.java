package org.D0907;

/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray
 whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104


Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 */
public class MinimumSizeSubArraySum {

    /*
    Here n is the length of nums.

Time complexity: O(n).

You may be thinking: there is an inner while loop inside another for loop, isn't the time complexity O(n^2)?
The reason it is still O(n) is because the right pointer right can move n times and the left pointer left can move also n times in total.
The inner loop is not running n times for each iteration of the outer loop. A sliding window guarantees a maximum of 2n window iterations.
This is what is referred to as amortized analysis - even though the worst case for an iteration inside the for loop is O(n),
it averages out to O(1) when you consider the entire runtime of the algorithm.

Space complexity: O(1).

We are not using any extra space other than a few integer variables:left, right, sumOfCurrentWindow, and res, which takes up constant space each.
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sumOfCurrentWindow = 0;
        int res = Integer.MAX_VALUE;

        for(right = 0; right < nums.length; right++) {
            sumOfCurrentWindow += nums[right];
            //minimal length of a subarray whose sum is greater than or equal to target.
            while (sumOfCurrentWindow >= target) {
                res = Math.min(res, right - left + 1);
                sumOfCurrentWindow -= nums[left++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumSizeSubArraySum().minSubArrayLen(7, new int[]{2,2,2,2}));
        System.out.println(new MinimumSizeSubArraySum().minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(new MinimumSizeSubArraySum().minSubArrayLen(4, new int[]{1,4,4}));
    }

    public int minSubArrayLenWithWhileLoop(int target, int[] nums) {
        int left = 0, right = 0, sumOfCurrentWindow = 0;
        int res = Integer.MAX_VALUE;

        while(right < nums.length) {
            sumOfCurrentWindow += nums[right++];

            while (sumOfCurrentWindow >= target) {
                res = Math.min(res, right - left);
                sumOfCurrentWindow -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
