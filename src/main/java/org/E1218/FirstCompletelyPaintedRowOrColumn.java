package org.E1218;

public class FirstCompletelyPaintedRowOrColumn {
    /*
    By leveraging the map array, you efficiently track the position of each element in arr in 𝑂(1).
For each row or column, you compute the maximum index of its elements in arr to determine when it is completed.
The overall algorithm ensures that the minimum of these maximum indices gives you the earliest point at which a row or column is fully painted.
This approach is efficient and directly addresses the problem of determining the first completely painted row or column.
     */
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int[] map = new int[arr.length + 1]; // this array is used for quick lookup with O(1) complexity
        for (int i = 0; i < arr.length; i++) {
            map[arr[i]] = i;
        }
        int ans = Integer.MAX_VALUE;
        for (int[] values : mat) {
            int max = 0;
            for (int val : values) {
                max = Math.max(max, map[val]);
            }
            ans = Math.min(ans, max);
        }
        for (int i = 0; i < mat[0].length; i++) {
            int max = 0;
            for (int[] values : mat) {
                max = Math.max(max, map[values[i]]);
            }
            ans = Math.min(ans, max);
        }
        return ans;
    }

    public static void main(String[] args) {
        //[1,3,4,2], mat = [[1,4],[2,3]]
        System.out.println(new FirstCompletelyPaintedRowOrColumn().firstCompleteIndex(new int[]{1,3,4,2}, new int[][] { {1,4},{2,3} }));
        System.out.println(new FirstCompletelyPaintedRowOrColumn().firstCompleteIndex(new int[]{2,8,7,4,1,3,5,6,9},
                new int[][] { {3,2,5}, {1,4,6}, {8,7,9} }));
    }
}
