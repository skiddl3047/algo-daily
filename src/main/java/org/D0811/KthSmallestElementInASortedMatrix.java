package org.D0811;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {

    // Time Complexity for add() & remove() is O(log N) as we're doing it for N+ K times N+K(log N)
    public int kthSmallestUsingPriorityQueue(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int[] nums: matrix){
            for(int num: nums){
                heap.add(num);
            }
        }
        int ans = 0;
        for(int i = 0; i < k; i++){
            ans = heap.remove();
        }
        return ans;
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int start = matrix[0][0], end = matrix[n - 1][n - 1];

        while (start < end) {
            int mid = start + (end - start) / 2;
            // first number is the smallest and the second number is the largest
            int[] smallLargePair = {matrix[0][0], matrix[n - 1][n - 1]};
            int count = this.countLessEqual(matrix, mid, smallLargePair);
            System.out.println(Arrays.toString(smallLargePair));
            if (count == k)
               return smallLargePair[0];
            if (count < k)
                start = smallLargePair[1]; // search higher
            else
                end = smallLargePair[0]; // search lower
        }
        return start;
    }

    private int countLessEqual(int[][] matrix, int mid, int[] smallLargePair) {
        int count = 0;
        int n = matrix.length, row = n - 1, col = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] > mid) {
                // as matrix[row][col] is bigger than the mid, let's keep track of the smallest number greater than the mid
                smallLargePair[1] = Math.min(smallLargePair[1], matrix[row][col]);
                row--;
            } else {
                // as matrix[row][col] is less than or equal to the mid, let's keep track of the biggest number less than or equal to the mid
                smallLargePair[0] = Math.max(smallLargePair[0], matrix[row][col]);
                count += row + 1;
                col++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        //System.out.println(new KthSmallestElementInASortedMatrix().kthSmallest(matrix,3));
        matrix = new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(new KthSmallestElementInASortedMatrix().kthSmallest(matrix,8));
        matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(new KthSmallestElementInASortedMatrix().kthSmallest(matrix,13));
    }
}
