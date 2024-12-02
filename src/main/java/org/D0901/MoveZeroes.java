package org.D0901;

import java.util.Arrays;

public class MoveZeroes {

    /*
    is slightly more optimal in terms of operations because it doesn’t perform swaps as frequently as moveZeroesUsingForLoop,
     which could be advantageous in arrays with lots of zeros scattered throughout.
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = -1;
        int i = 0;

        while(i < n ){
            //first occurence of 0
            if(nums[i] == 0 && j == -1) {
                j = i;
                //has zero in the array before a valid digit, hence swap
            } else if(nums[i] != 0 && j != -1 ){
                nums[j] = nums[i];
                nums[i] = 0;
                j++ ;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int[] input1 = new int[]{1,2,3,4};
        new MoveZeroes().moveZeroes(input1);
        System.out.println(Arrays.toString(input1));
        input1 = new int[]{0,0,1,2,3,4};
        new MoveZeroes().moveZeroes(input1);
        System.out.println(Arrays.toString(input1));
    }

    public void moveZeroesUsingForLoop(int[] nums) {
        int lastNonZeroFoundAt = 0;
        for (int cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                // Swap nums[lastNonZeroFoundAt] and nums[cur]
                int temp = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt] = nums[cur];
                nums[cur] = temp;
                lastNonZeroFoundAt++;
            }
        }
    }

}
