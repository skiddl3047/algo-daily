package org.D0822;

import java.util.Arrays;

/*
Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
Return any array that satisfies this condition.

Example 1:
Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

Example 2:
Input: nums = [0]
Output: [0]

Constraints:
1 <= nums.length <= 5000
0 <= nums[i] <= 5000
 */
public class SortArrayByParity {

    // Time Complexity : O(n) in worest case we need scan entire array
    //Space Complexity : O(1)

    /*
    Algorithm - use 2 pointer approach
    start from left and right
    if even num is found on the left do left ++ and odd num is found on right do right--
    in other case do a swap operation
     */
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        while(left < right){
            if(nums[left] % 2 == 0 ){
                left++;
            }else if(nums[right] % 2 == 1){
                right--;
            }else{
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortArrayByParity().sortArrayByParity(new int[]{1, 2, 3, 4, 5, 6})));
        System.out.println(Arrays.toString(new SortArrayByParity().sortArrayByParity(new int[]{2, 4, 8, 5, 6})));
    }
}
