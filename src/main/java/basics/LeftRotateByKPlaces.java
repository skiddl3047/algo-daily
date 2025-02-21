package basics;

import java.util.Arrays;

public class LeftRotateByKPlaces {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new LeftRotateByKPlaces().leftRotateByKPlaces(nums, 15);
    }

    private void leftRotateByKPlaces(int[] nums, int k) {
        int length = nums.length;
        k = k%length;

        reverse(nums, 0, length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, length-1);

        System.out.println(Arrays.toString(nums));
    }

    private void reverse(int[] nums, int start, int end) {
       while (start < end) {
           int temp = nums[start];
           nums[start] = nums[end];
           nums[end] = temp;
           start ++;
           end --;
       }
    }
}
