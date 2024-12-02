package org.D0906;

import java.util.HashMap;
import java.util.Map;

/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109


Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class MajorityElement {

    //Approach 7: Boyer-Moore Voting Algorithm
    //Intuition
    //If we had some way of counting instances of the majority element as +1
    //and instances of any other element as −1, summing them would make it
    //obvious that the majority element is indeed the majority element.
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            candidate = (count == 0) ? num : candidate;
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;

    }
}
