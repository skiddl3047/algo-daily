package org.D0820;

/*
Given an integer array nums, find a subarray that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


Constraints:
1 <= nums.length <= 2 * 10^4
-10 <= nums[i] <= 10
The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
 */
public class MaxProductSubArray {

    public int maxProduct(int[] nums) {
        int curSubArraySum = nums[0];
        int maxSubArraySum = nums[0];

        for(int i=1; i< nums.length; i++){
            int num = nums[i];
            curSubArraySum = Math.max(num, curSubArraySum * num);
            maxSubArraySum = Math.max(maxSubArraySum, curSubArraySum);
        }
        return maxSubArraySum;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProductSubArray().maxProduct(new int[]{2,3,-2,4}));
        System.out.println(new MaxProductSubArray().maxProduct(new int[]{-2,0,-1}));
        System.out.println(new MaxProductSubArray().maxProduct(new int[]{1,2,3,4,-5}));
    }
}
