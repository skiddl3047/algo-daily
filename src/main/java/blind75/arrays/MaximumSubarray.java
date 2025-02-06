package blind75.arrays;

public class MaximumSubarray {

    public int maxSubArray1ms(int[] nums) {
        //Arrays.sort(nums);
        int curSubArraySum = nums[0];
        int maxSubArraySum = nums[0];

        for(int i=1; i< nums.length; i++){
            int num = nums[i];
            curSubArraySum = Math.max(num, curSubArraySum+num);
            maxSubArraySum = Math.max(maxSubArraySum, curSubArraySum);
        }
        return maxSubArraySum;
    }

    public static void main(String[] args) {
        
    }

    public int maxSubArray0ms(int[] nums) {
        int curr_sum = 0;
        int max_sum = nums[0];
        for(int i = 0;i<nums.length;i++){
            curr_sum+=nums[i];
            max_sum = Math.max(curr_sum, max_sum);

            if(curr_sum<0) curr_sum=0;
        }
        return max_sum;
    }
}
