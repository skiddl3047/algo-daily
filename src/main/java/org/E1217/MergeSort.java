package org.E1217;

import java.util.Arrays;

public class MergeSort {

    // Function to merge two sub-arrays in sorted order.
    private void merge(int[] arr, int left, int mid, int right, int[] tempArr) {
        // Calculate the start and sizes of two halves.
        int midStart = mid + 1;
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Copy elements of both halves into a temporary array.
        for (int i = 0; i < n1; i++)
            tempArr[left + i] = arr[left + i];
        for (int i = 0; i < n2; i++)
            tempArr[midStart + i] = arr[midStart + i];

        // Merge the sub-arrays 'in tempArray' back into the original array 'arr' in sorted order.
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (tempArr[left + i] <= tempArr[midStart + j]) {
                arr[k] = tempArr[left + i];
                i++;
            } else {
                arr[k] = tempArr[midStart + j];
                j++;
            }
            k++;
        }

        // Copy remaining elements
        while (i < n1) {
            arr[k] = tempArr[left + i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = tempArr[midStart + j];
            j++;
            k++;
        }
    }

    // Recursive function to sort an array using merge sort
    private void mergeSort(int[] arr, int left, int right, int[] tempArr) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        // Sort first and second halves recursively.
        mergeSort(arr, left, mid, tempArr);
        mergeSort(arr, mid + 1, right, tempArr);
        // Merge the sorted halves.
        merge(arr, left, mid, right, tempArr);
    }

    public int[] sortArray(int[] nums) {
        int[] temporaryArray = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temporaryArray);
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MergeSort().sortArray(new int[]{9,8,7,6,5,4,3,2,1})));
        System.out.println(Arrays.toString(new MergeSort().sortArray(new int[]{5,2,3,1})));
    }
}
