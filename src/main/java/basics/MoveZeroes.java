package basics;

import java.util.Arrays;

public class MoveZeroes {
    public static  void main(String[] args) {
        int[] nums = {1, 0, 6,0, 2};
        new MoveZeroes().moveZeroes(nums);
        new MoveZeroes().moveZeroesWithSwap(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    private int[] moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[index] = nums[i];
                index ++;
            }
        }
        while(index < nums.length) {
            nums[index] =0;
            index ++;
        }
        return nums;
    }

    private int[] moveZeroesWithSwap(int[] nums) {
        int index = 0;  // Pointer for non-zero elements

        // Move non-zero elements forward
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap only when necessary to minimize writes
                if (i != index) {
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                }
                index++;
            }
        }
        return nums;
    }
}
