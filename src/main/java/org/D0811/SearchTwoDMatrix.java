package org.D0811;

/*
you are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

 */
public class SearchTwoDMatrix {

    /*
    Time complexity : O(log(mn)) since it's a standard binary search.
    Space complexity : O(1).
    */
    /*
    Sorted array is a perfect candidate for the binary search because the element index in this virtual array (for sure we're not going to construct it for real)
    could be easily transformed into the row and column in the initial matrix

    row = idx / n and col = idx % n.
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;
        // binary search
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = left + (right-left) / 2;
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement)
                return true;
            else {
                if (target < pivotElement) right = pivotIdx - 1;
                else left = pivotIdx + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //Key here is this "Input condition The first integer of each row is greater than the last integer of the previous row."
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(new SearchTwoDMatrix().searchMatrix(matrix, 11));
    }
}
