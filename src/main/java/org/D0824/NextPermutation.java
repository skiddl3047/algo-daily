package org.D0824;

import java.util.Arrays;

/*
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr:
[1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
More formally, if all the permutations of the array are sorted in one container according to their lexicographical order,
 then the next permutation of that array is the permutation that follows it in the sorted container.
 If such arrangement is not possible, the array must be rearranged as the lowest possible order
 (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100
 */


public class NextPermutation {
/*
Summary of the Algorithm
1) Find the first index i from the end where nums[i] < nums[i + 1]. // find first the decreasing element
2) Identify the smallest element nums[j] from the end that’s larger than nums[i]. // find larger number just larger than that
3) Swap nums[i] with nums[j]. // swap them
4) Reverse the subarray starting from i + 1 to get the smallest possible sequence after the swap.
 */
    /*
    Time complexity: O(n)
The first while loop runs at most n iterations, decrementing the variable i as it searches for the first decreasing element from the right.
In the worst case, it checks all elements, so it takes O(n) time.
The second while loop also runs at most n iterations, decrementing the variable j as it searches for the smallest element larger than nums[i].
Similarly, it can take O(n) time.
The reverse function is called on a portion of the array, from index i + 1 to the end.
In the worst case, this can cover the entire array, leading to a time complexity of O(n).
The swap function runs in constant time, O(1), since it only exchanges two elements.
Therefore, the overall time complexity is O(n).

Space complexity: O(1)
The function operates in-place on the nums array, meaning no extra space is used for storing additional data.

     */
    // for easy understanding check this
    //https://leetcode.com/problems/next-permutation/solutions/13994/readable-code-without-confusing-i-j-and-with-explanation
        public void nextPermutation(int[] nums) {
            int i = nums.length - 2; // this is for validating i + 1 condition.
            while (i >= 0 && nums[i + 1] <= nums[i]) {
                i--;
            }
            if (i >= 0) {
                int j = nums.length - 1;
                while (nums[j] <= nums[i]) {
                    j--;
                }
                swap(nums, i, j);
            }
            reverse(nums, i + 1);
        }

        private void reverse(int[] nums, int start) {
            int i = start, j = nums.length - 1;
            while (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    public static void main(String[] args) {
        int[] input1 = new int[]{0,1,2,5,3,3,0};
        new NextPermutation().nextPermutation(input1);
        System.out.println(Arrays.toString(input1));
        input1 = new int[]{1,2,3,4,5,6,7,8};
        new NextPermutation().nextPermutation(input1);
        System.out.println(Arrays.toString(input1));
        new NextPermutation().nextPermutation(input1);
        System.out.println(Arrays.toString(input1));
        input1 = new int[]{9,8,7,6,5,4,3,2,1};
        new NextPermutation().nextPermutation(input1);
        System.out.println(Arrays.toString(input1));
        input1 = new int[]{1,2,3};
        new NextPermutation().nextPermutation(input1);
        System.out.println(Arrays.toString(input1));
    }
}
