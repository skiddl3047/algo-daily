package org.D0810;

import java.util.Arrays;

public class ArrayOfProductsExceptSelf {

    public static void main(String[] args) {
        ArrayOfProductsExceptSelf arrayOfProductsExceptSelf = new ArrayOfProductsExceptSelf();
        //System.out.println(Arrays.toString(arrayOfProductsExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(arrayOfProductsExceptSelf.productExceptSelf(new int[]{1, 2, 3})));
    }

    public int[] productExceptSelf(int[] nums) {

        int[] products = new int[nums.length];

        int leftRunningProduct = 1;
        for(int i=0; i< nums.length; i++){
            products[i] = leftRunningProduct;
            System.out.println(leftRunningProduct+" " +nums[i]);
            leftRunningProduct = leftRunningProduct * nums[i];
        }
        System.out.println(Arrays.toString(products));
        int rightRunningProduct = 1;
        for(int i = nums.length-1; i >= 0; i--){
            products[i] = products[i] * rightRunningProduct;
            rightRunningProduct = rightRunningProduct * nums[i];
        }

        return products;
    }
}
