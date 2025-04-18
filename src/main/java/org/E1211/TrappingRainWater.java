package org.E1211;

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.



Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9


Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
 */
public class TrappingRainWater {

    /*
    Complexity Analysis

    Time complexity: O(n). Single iteration of O(n).
    Space complexity: O(1) extra space. Only constant space required for left, right, left_max and right_max.
     */
    //check the diagram to get better idea - https://leetcode.com/problems/trapping-rain-water/description/
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                left_max = Math.max(left_max, height[left]);
                ans += left_max - height[left];
                left++;
            } else {
                right_max = Math.max(right_max, height[right]);
                ans += right_max - height[right];
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(new TrappingRainWater().trap(new int[]{4,2,0,3,2,5}));
    }
}
