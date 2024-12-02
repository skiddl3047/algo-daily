package org.D0820;

public class MaxSumSubArray {

    public static void main(String[] args) {

    }

    /*
     Kadance's algorithm
     The idea of Kadane’s algorithm is to traverse over the array from left to right and for each element,
     find the maximum sum among all subarrays ending at that element.
      The result will be the maximum of all these values.
     */
    public int maxSubArray(int[] nums) {
        //Arrays.sort(nums);
        int curSubArraySum = nums[0];
        int maxSubArraySum = nums[0];

        for(int num: nums){
            curSubArraySum = Math.max(num, curSubArraySum+num);
            maxSubArraySum = Math.max(maxSubArraySum, curSubArraySum);
        }
        return maxSubArraySum;
    }
}
