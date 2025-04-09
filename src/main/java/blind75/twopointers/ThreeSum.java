package blind75.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


Constraints:
3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */
public class ThreeSum {

    /*
Time Complexity: O(n ^ 2 ). twoSum is O(n), and we call it n times.
Sorting the array takes O(nlogn), so overall complexity is O(nlogn + n ^ 2 ). This is asymptotically equivalent to O(n ^ 2 ).

Space Complexity: O(n) for the hashset.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2 && nums[i] <= 0; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(i + 1, -nums[i], nums, res);
        }
        return res;
    }

    public void twoSum(int start, int t, int[] nums, List<List<Integer>> res){
        int end = nums.length - 1;
        while(start < end){
            if(nums[start] + nums[end] > t){
                end--;
            } else if(nums[start] + nums[end] < t){
                start++;
            } else{
                res.add(Arrays.asList(-t, nums[start], nums[end]));
                start++;
                end--;
                while(start < end && nums[start] == nums[start - 1]){
                    start++;
                }
            }
        }
    }
}
