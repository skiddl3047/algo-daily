package blind75.arrays;

import java.util.HashSet;
import java.util.Set;

public class AAContainsDuplicate {

    public boolean containsDuplicateSetApproach(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            if(!set.add(num))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new AAContainsDuplicate().containsDuplicateSetApproach(new int[]{1,2,3,1}));
        System.out.println(new AAContainsDuplicate().containsDuplicate(new int[]{1,2,3,1}));
    }

    public boolean containsDuplicate(int[] nums) {
        int temp;
        for(int i=1; i<nums.length; i++){
            if(nums[i]==nums[i-1])
                return true;
            temp = nums[i];
            if(nums[i]<nums[i-1]){
                for(int j=i-2; j>=0; j--){
                    if(nums[j] == temp)
                        return true;
                }
                nums[i] = nums[i-1];
                nums[i-1]=temp;
            }
        }
        return false;
    }
}
