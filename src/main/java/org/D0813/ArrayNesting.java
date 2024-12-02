package org.D0813;

public class ArrayNesting {

    public static void main(String[] args) {
        System.out.println(new ArrayNesting().arrayNesting(new int[]{5,4,0,3,1,6,2}));
        System.out.println(new ArrayNesting().arrayNesting(new int[]{1,2,3,4,5,6,0}));
    }

    public int arrayNesting(int[] nums) {
        int maxCount = 0;

        for (int i = 0; i < nums.length; i++) {
            maxCount = dfs(nums, i, maxCount);
        }
        return maxCount;
    }

    private static int dfs(int[] nums, int i, int maxCount) {
        if (nums[i] != -1) { // Check if the element has not been visited
            int count = 0;
            int index = i;

            while (nums[index] != -1) {
                int temp = nums[index];
                nums[index] = -1; // Mark the element as visited
                index = temp;
                count++;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}