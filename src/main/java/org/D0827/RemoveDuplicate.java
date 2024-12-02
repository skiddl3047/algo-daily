package org.D0827;

import java.util.Arrays;

public class RemoveDuplicate {

    /*
        Complexity Analysis:  Let N be the size of the input array.
        Time Complexity: O(N), since we only have 2 pointers, and both the pointers will traverse the array at most once.

        Space Complexity: O(1), since we are not using any extra space.
     */
    public int removeDuplicates(int[] nums) {
        int insertIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            // We skip to next index if we see a duplicate element
            if (nums[i - 1] != nums[i]) { // concentrate on the non-equal values
                /* Storing the unique element at insertIndex index and incrementing the insertIndex by 1 */
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        return insertIndex;
    }

    public static void main(String[] args) {
        int[] input1 = new int[]{1,1,1,2};
        System.out.println(new RemoveDuplicate().removeDuplicates(input1));
        System.out.println(Arrays.toString(input1));
    }
}
