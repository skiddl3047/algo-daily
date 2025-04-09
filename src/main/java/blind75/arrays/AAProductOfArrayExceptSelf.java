package blind75.arrays;

import java.util.Arrays;

public class AAProductOfArrayExceptSelf {

    /*
    Why leftRunningProduct and rightRunningProduct are Needed
We can't use division, so instead, we compute the result in two passes:

Left Pass: We calculate the cumulative product of all elements to the left of the current index (leftRunningProduct).
Right Pass: We calculate the cumulative product of all elements to the right of the current index (rightRunningProduct).
     */
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        int leftSideProduct=1;
        for(int i =0; i < nums.length ; i++){
            products[i] = leftSideProduct;
            leftSideProduct = leftSideProduct * nums[i];
        }
        int rightSideProduct = 1;
        for(int i = nums.length-1; i >= 0; i--){
            products[i] = products[i] * rightSideProduct;
            rightSideProduct = rightSideProduct * nums[i];
        }
        return products;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new AAProductOfArrayExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
