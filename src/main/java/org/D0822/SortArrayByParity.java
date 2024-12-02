package org.D0822;

import java.util.Arrays;

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {

        int left = 0;
        int right = nums.length -1;

        while(left < right){
            if(nums[left] % 2 == 0 ){
                left++;
            }else if(nums[right] % 2 == 1){
                right--;
            }else{
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortArrayByParity().sortArrayByParity(new int[]{1, 2, 3, 4, 5, 6})));
        System.out.println(Arrays.toString(new SortArrayByParity().sortArrayByParity(new int[]{2, 4, 8, 5, 6})));
    }
}
