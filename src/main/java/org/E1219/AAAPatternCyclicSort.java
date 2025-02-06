package org.E1219;

import java.util.Arrays;

public class AAAPatternCyclicSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 3, 2};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            // the correct index is supposed to be the (element - 1)th index
            int correctIdx = arr[i] - 1;
            if (arr[i] != arr[correctIdx]) {
                // if the current element is not equal to the element present at the current index
                // put the element in the correct index by swapping
                int temp = arr[i];
                arr[i] = arr[correctIdx];
                arr[correctIdx] = temp;
            } else {
                i++;    // otherwise move forward
            }
        }
    }
}
