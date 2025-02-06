package org.D0902;

public class ContainerWithMostWater {

    /*
    Complexity Analysis

    Time complexity: O(n). Single pass.
    Space complexity: O(1). Constant space is used.
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            System.out.println("left : "+left + " right : "+right + " height[left] : "+height[left]+" height[right] : "+height[right]);
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(area, maxArea);

            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
