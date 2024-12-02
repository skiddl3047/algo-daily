package org.D0902;

import java.util.Arrays;

/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100]. After sorting, it becomes [0,1,9,16,100].

Example 2:
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]


Constraints:
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.


Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 */
public class SquaresOfSortedArray {

    public int[] sortedSquares(int[] nums) {
        int arrayLength = nums.length ;
        int left = 0;
        int right = arrayLength-1;
        int[] result = new int[nums.length];
        for(int i = arrayLength-1; i>= 0; i-- ){
            int square = 0;
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                square = nums[left];
                left++;
            }
            else {
                square = nums[right];
                right--;
            }
            result[i] = square * square;
        }


        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SquaresOfSortedArray().sortedSquares(new int[]{-5, 1, 2, 3, 4})));
    }
}
