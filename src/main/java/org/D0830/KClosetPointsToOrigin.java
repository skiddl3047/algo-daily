package org.D0830;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosetPointsToOrigin {

    public int dist(int[] p) {
        return p[0]*p[0] + p[1]*p[1];
    }

    public int[][] kClosestUsingQueue(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> dist(b) - dist(a));

        for (var point : points) {
            pq.offer(point);
            if (pq.size() > k)
                pq.poll();
        }

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++)
            ans[i] = pq.poll();
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new KClosetPointsToOrigin().kClosestUsingQueue(new int[][]{{1, 3}, {-2, 2}}, 1)));
        System.out.println(Arrays.deepToString(new KClosetPointsToOrigin().kClosestUsingQueue(new int[][]{{3,3}, {5,-1},{-2,4}}, 2)));
    }

    public int[][] kClosest(int[][] points, int k) {
        return quickSelect(points, k);
    }

    private int[][] quickSelect(int[][] points, int k) {
        int left = 0, right = points.length - 1;
        int pivotIndex = points.length;
        while (pivotIndex != k) {
            // Repeatedly partition the array
            // while narrowing in on the kth element
            pivotIndex = partition(points, left, right);
            if (pivotIndex < k) {
                left = pivotIndex;
            } else {
                right = pivotIndex - 1;
            }
        }

        // Return the first k elements of the partially sorted array
        return Arrays.copyOf(points, k);
    }

    private int partition(int[][] points, int left, int right) {
        int[] pivot = choosePivot(points, left, right);
        int pivotDist = squaredDistance(pivot);
        while (left < right) {
            // Iterate through the range and swap elements to make sure
            // that all points closer than the pivot are to the left
            if (squaredDistance(points[left]) >= pivotDist) {
                int[] temp = points[left];
                points[left] = points[right];
                points[right] = temp;
                right--;
            } else {
                left++;
            }
        }

        // Ensure the left pointer is just past the end of
        // the left range then return it as the new pivotIndex
        if (squaredDistance(points[left]) < pivotDist)
            left++;
        return left;
    }

    private int[] choosePivot(int[][] points, int left, int right) {
        // Choose a pivot element of the array
        return points[left + (right - left) / 2];
    }

    private int squaredDistance(int[] point) {
        // Calculate and return the squared Euclidean distance
        return point[0] * point[0] + point[1] * point[1];
    }
}
