package org.D0909;

import java.util.HashMap;
import java.util.Map;

/*
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
A subarray is a contiguous part of the array.



Example 1:
Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]

Example 2:
Input: nums = [0,0,0,0,0], goal = 0
Output: 15


Constraints:
1 <= nums.length <= 3 * 104
nums[i] is either 0 or 1.
0 <= goal <= nums.length
 */
public class BinarySubarraysWithSum {

    /*
    Let n be the length of the nums array.

Time complexity: O(n)

The function iterates through the nums array once using a single for loop (end loop).
Inside the loop, the while loop might contract the window, but the total number of iterations within this loop is still bounded by the number of elements in the array (n).
Therefore, the overall time complexity is dominated by the single iteration through the array, resulting in O(n).

Space complexity: O(1)
The space complexity is O(1) because the algorithm uses a constant amount of space for variables such as start,
currentSum, and totalCount. The space required does not depend on the size of the input array.
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        int start = 0;
        int prefixZeros = 0;
        int currentSum = 0;
        int totalCount = 0;
        // Loop through the array using end pointer
        for (int end = 0; end < nums.length; end++) {
            // Add current element to the sum
            currentSum += nums[end];
            // Slide the window while condition is met
            while (start < end && (nums[start] == 0 || currentSum > goal)) {
                if (nums[start] == 1) {
                    prefixZeros = 0;
                } else {
                    prefixZeros++;
                }
                currentSum -= nums[start];
                start++;
            }
            // Count subarrays when window sum matches the goal
            if (currentSum == goal) {
                totalCount += 1 + prefixZeros;
            }
        }
        return totalCount;
    }

    //https://leetcode.com/problems/binary-subarrays-with-sum/solutions/4872605/prefixsum-hashmap-98-85-beats-o-n-time-complexity-java-c-python3/
    public int numSubarraysWithSumLink1(int[] nums, int goal) {
        int result = 0;
        int prefixSum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        //We initialize the hashmap with (0, 1) to handle the case where the prefix sum equals the target sum without including any elements from the array. This ensures that subarrays starting from the beginning of the array are also considered.
        map.put(0,1);
        for (int num : nums) {
            prefixSum += num;
            result += map.getOrDefault(prefixSum - goal, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySubarraysWithSum().numSubarraysWithSum(new int[]{1,0,1,0,1},2));
    }
}
