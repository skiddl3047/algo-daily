package org.D0910;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int count =0;
        int max = 0;
        for(int i=0; i< nums.length; i++){
            if(nums[i] == 0)
                count =0;
            else{
                count++;
                max = Math.max(max,count);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxConsecutiveOnes().findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
        System.out.println(new MaxConsecutiveOnes().findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
    }
}
