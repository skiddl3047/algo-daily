package org.D0824;

import java.util.Arrays;

/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and
two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.


Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109


Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 */
public class MergeSortArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int arrayLen1 = m - 1;
        int totalLenOfArray = m + n - 1;
        int arrayLen2 = n - 1;
        // Compare from the end and place the larger element at the end of nums1
        while (arrayLen1 >= 0 && arrayLen2 >= 0) {
            if (nums1[arrayLen1] > nums2[arrayLen2]) {
                nums1[totalLenOfArray--] = nums1[arrayLen1--];
            } else {
                nums1[totalLenOfArray--] = nums2[arrayLen2--];
            }
        }
        // If there are remaining elements in nums2, fill them in nums1
        /* handles cases where all elements in nums1 (up to m elements) are greater than all elements in nums2, 
            requiring the remaining elements from nums2 to be filled in the beginning of nums1.
        */
        System.out.println(Arrays.toString(nums1));
        while (arrayLen2 >= 0) {
            nums1[totalLenOfArray--] = nums2[arrayLen2--];
        }
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{1,2,3,0,0,0};
        new MergeSortArray().merge(array1, 3, new int[]{2,5,6}, 3);
        System.out.println(Arrays.toString(array1));
        array1 = new int[]{4,5,6,0,0,0};
        new MergeSortArray().merge(array1, 3, new int[]{1,2,3}, 3);
        System.out.println(Arrays.toString(array1));

        array1 = new int[]{1,2,3,0,0,0,0};
        new MergeSortArray().merge(array1, 3, new int[]{2,4,5,6}, 4);
        System.out.println(Arrays.toString(array1));
    }
}
