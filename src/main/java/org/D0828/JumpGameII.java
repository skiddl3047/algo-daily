package org.D0828;
/*
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i.
In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

Example 1:
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [2,3,0,1,4]
Output: 2

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].
 */
public class JumpGameII {
    /*
        Complexity Analysis Let n be the length of the input array nums.

        Time complexity: O(n)
        We iterate over nums and stop at the second last element. In each step of the iteration,
        we make some calculations that take constant time. Therefore, the overall time complexity is O(n).

        Space complexity: O(1)
        In the iteration, we only need to update three variables, curEnd, curFar and answer, they only take constant space.
     */
    // This algo will return the min no of jumps to destination
    public int jump(int[] nums) {
        // The starting range of the first jump is [0, 0]
        int answer = 0, n = nums.length;
        int currentEnd = 0, currentFarthest = 0;
        for (int i = 0; i < n - 1; ++i) {
            // Update the farthest reachable index of this jump.
            currentFarthest = Math.max(currentFarthest, i + nums[i]);
            // If we finish the starting range of this jump,
            // Move on to the starting range of the next jump.
            if (i == currentEnd) {
                answer++;
                currentEnd = currentFarthest;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGameII().jump(new int[]{2,3,1,1,4}) );
    }
}
