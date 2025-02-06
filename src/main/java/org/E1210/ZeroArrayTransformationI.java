package org.E1210;

public class ZeroArrayTransformationI {

    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diffArray = new int[n + 1];

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            diffArray[l]++;
            diffArray[r + 1]--;
        }

        for (int i = 1; i <= n; ++i)
            diffArray[i] += diffArray[i - 1];
        for (int i = 0; i < n; ++i) {
            if (diffArray[i] < nums[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ZeroArrayTransformationI().isZeroArray(new int[]{1,0,1}, new int[][]{{0,2}}));
        System.out.println(new ZeroArrayTransformationI().isZeroArray(new int[]{4,3, 2, 1}, new int[][]{{1,3},{0,2}}));
    }
}
