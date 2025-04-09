package org.E1219;
/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and using only constant extra space.



Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [3,3,3,3,3]
Output: 3


Constraints:

1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.


Follow up:

How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?
 */
public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIdx = nums[i] - 1;
            if (nums[i] != nums[correctIdx]) {
                swap(nums, i, correctIdx);
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                return nums[i];

        return 0;
    }

    private static void swap(int[] nums, int i, int correctIdx) {
        int temp = nums[i];
        nums[i] = nums[correctIdx];
        nums[correctIdx] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new FindTheDuplicateNumber().findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(new FindTheDuplicateNumber().findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(new FindTheDuplicateNumber().findDuplicate(new int[]{3,3,3,3,3}));
    }
}
