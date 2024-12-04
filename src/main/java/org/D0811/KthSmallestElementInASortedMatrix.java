package org.D0811;

import java.util.Arrays;
import java.util.PriorityQueue;
/*
Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
Note that it is the kth smallest element in the sorted order, not the kth distinct element.
You must find a solution with a memory complexity better than O(n2).



Example 1:
Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13

Example 2:
Input: matrix = [[-5]], k = 1
Output: -5


Constraints:
n == matrix.length == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= 109
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2

 */
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

    /*
    Time Complexity: O(N×log(Max−Min))

Let's think about the time complexity in terms of the normal binary search algorithm.
For a one-dimensional binary search over an array with N elements, the complexity comes out to be O(log(N)).
For our scenario, we are kind of defining our binary search space in terms of the minimum and the maximum numbers in the array.

Going by this idea, the complexity for our binary search should be O(log(Max−Min))
where Max is the maximum element in the array and likewise, Min is the minimum element.

However, we update our search space after each iteration. So, even if the maximum element is super large as compared
to the remaining elements in the matrix, we will bring down the search space considerably in the next iterations.
But, going purely by the extremes for our search space, the complexity of our binary search in search of  Kth smallest element will be O(log(Max−Min)).
In each iteration of our binary search approach, we iterate over the matrix trying to determine the size of the left-half as explained before.
That takes O(N).
Thus, the overall time complexity is O(N×log(Max−Min))

Space Complexity: O(1) since we don't use any additional space for performing our binary search.
     */
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
