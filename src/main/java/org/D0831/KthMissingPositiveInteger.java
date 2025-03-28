package org.D0831;

public class KthMissingPositiveInteger {

    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            System.out.println("left : "+left+" right : "+right+" pivot : "+pivot+" arr[pivot] : "+arr[pivot]);
            // If number of positive integers which are missing before arr[pivot] is less than k -->
            // continue to search on the right.
            if (arr[pivot] - pivot - 1 < k) { // (arr[pivot] - pivot - 1) missing positive numbers before the index
                left = pivot + 1;
                // Otherwise, go left.
            } else {
                right = pivot - 1;
            }
        }
        // At the end of the loop, left = right + 1, and the kth missing is in-between arr[right] and arr[left].
        // The number of integers missing before arr[right] is arr[right] - right - 1 -->
        // the number to return is arr[right] + k - (arr[right] - right - 1) = k + left
        return left + k;
    }

    public static void main(String[] args) {
        System.out.println(new KthMissingPositiveInteger().findKthPositive(new int[]{2,3,4,7,11},5));
        System.out.println(new KthMissingPositiveInteger().findKthPositive(new int[]{1,2,3,4,5},2));
    }

}
