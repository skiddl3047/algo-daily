package blind75.twopointers;

public class ContainerWithMostWater {

    /*Time complexity: O(n). Single pass.

    Space complexity: O(1). Constant space is used.*/
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int area=0;
        while(left<right){
            int minHeight= Math.min(height[left], height[right]);
            area = Math.max(area, minHeight * (right-left));
            while(height[left] <= minHeight && left < right)
                left++;
            while(height[right] <= minHeight && left < right)
                right--;
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1,1}));
    }
}
