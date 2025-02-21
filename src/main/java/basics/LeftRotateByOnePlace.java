package basics;

import java.util.Arrays;

public class LeftRotateByOnePlace {
    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7};
        Arrays.stream(new LeftRotateByOnePlace().leftRotateByOnesPlace(nums)).forEach(System.out::println);
    }

    private int[] leftRotateByOnesPlace(int[] nums) {
        int zeroIndexValue = nums[0];
        int length = nums.length;
        for (int i=1; i< length; i++) {
           nums[i-1] = nums[i];
        }
        nums[length-1] = zeroIndexValue;
        return nums;
    }
}
