package org.D0827;

import java.util.Arrays;

/*
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted,
you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
The remaining elements of nums are not important as well as the size of nums.
Return k.

Custom Judge: The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int val = ...; // Value to remove
int[] expectedNums = [...]; // The expected answer with correct length.
                            // It is sorted with no values equaling val.

int k = removeElement(nums, val); // Calls your implementation

assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i < actualLength; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

Example 1:

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).

 */
public class RemoveElement {

    /*
    Algorithm

    When we encounter nums[i]=val, we can swap the current element out with the last element and dispose the last one.
     This essentially reduces the array's size by 1.
     Note that the last element that was swapped in could be the value you want to remove itself.
     But don't worry, in the next iteration we will still check this element.

     Time complexity : O(n). Both i and n traverse at most n steps.
     In this approach, the number of assignment operations is equal to the number of elements to remove.
     So it is more efficient if elements to remove are rare.

    Space complexity : O(1).
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1]; //It does not matter what you leave beyond the returned k
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    /*
    Consider the number of elements in nums which are not equal to val be k, to get accepted,
    you need to do the following things:

    1. Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
    The remaining elements of nums are not important as well as the size of nums.
    2.Return k.
     */
    public int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int elem: nums){
            if (elem != val){
                nums[i] = elem; // It does not matter what you leave beyond the returned k
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] input1 = new int[]{3,2,2,3};
        System.out.println(new RemoveElement().removeElement(input1, 3));
        System.out.println(Arrays.toString(input1));
        input1 = new int[]{3,2,2,3};
        System.out.println(new RemoveElement().removeElement1(input1, 3));
        System.out.println(Arrays.toString(input1));
    }
}
