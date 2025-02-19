package org.E1220;

public class SubarrayProductLessThanK {
    //https://leetcode.com/problems/subarray-product-less-than-k/solutions/108861/java-c-clean-code-with-explanation
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int left = 0, right = 0, prod = 1, ans = 0;
        while(right<nums.length) {
            prod = prod * nums[right];
            while(prod >= k) {
                prod = prod/nums[left];
                left++;
            }
                       /* think the trickiest part is why the number of newly introduced subarrays is right - left + 1.
Say now we have {1,2,3} and add {4} into it. Apparently, the new subarray introduced here are:
{1,2,3,4}, {2,3,4}, {3,4}, {4}, which is the number of elements in the new list.
If we also remove some at the left, say we we remove 1, then subarrays are:
{2,3,4}, {3,4}, {4}. It is easy to get the result is j - i + 1. */
            ans = ans + (right - left + 1);
            right++;
        }
        return ans;
    }
}
