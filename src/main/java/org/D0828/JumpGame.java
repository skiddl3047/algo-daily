package org.D0828;

public class JumpGame {

    //Greedy Approach
    /*
    Time complexity : O(n).
    We are doing a single pass through the nums array, hence n steps, where n is the length of array nums.

    Space complexity : O(1). We are not using any extra memory.
     */
    /*
    Step-by-Step Solution
    1. Set the Initial Goal:
    Start by setting the goal as the last index, which is nums.length - 1.
    This goal represents the position we want to reach (or eventually "move" backward to the start if possible).

    2. Loop Backward Through the Array:
    Start iterating from the second-to-last index (i.e., nums.length - 2) and move backward to the first index (index 0).
    For each index i, check if it's possible to reach the current goal from i.

    3.Update the Goal:
    If i + nums[i] (the farthest position we can jump to from i) is greater than or equal to the current goal, update the goal to i.
    This means that from index i, we can jump to or beyond the current goal, so now i becomes the new goal.

    4.Check If We Can Reach the Start:
    By the end of the loop, if the goal has reached 0, it means we can jump from the start to the end of the array.
    If goal is not 0, then it's not possible to reach the last index from the beginning.
     */
    public boolean canJumpBackwardGreedy(int[] nums) {
                int lastPos = nums.length - 1;
                for (int i = nums.length - 1; i >= 0; i--) {
                    // Check if the current index can reach or pass the goal
                    if (i + nums[i] >= lastPos) {
                        // If yes, update the goal to the current index
                        lastPos = i;
                    }
                }
                // If we've moved the goal to the start, we can reach the end
                return lastPos == 0;
    }

    public boolean canJumpForward(int[] nums) {
        int farthest = 0; // Track the farthest point reachable
        for (int i = 0; i < nums.length; i++) {
            // If the current index is beyond the farthest reachable position, return false
            if (i > farthest) return false;

            // Update the farthest point reachable from this index
            farthest = Math.max(farthest, i + nums[i]);

            // If we can reach or go beyond the last index, return true
            if (farthest >= nums.length - 1) return true;
        }
        return false;
    }

    public boolean canJump(int[] nums) {
        // Start with the last index as the initial goal
        int goal = nums.length - 1;

        // Iterate from the second-to-last index down to the first
        for (int i = nums.length - 2; i >= 0; i--) {
            // Check if the current index can reach or pass the goal
            if (i + nums[i] >= goal) {
                // If yes, update the goal to the current index
                goal = i;
            }
        }

        // If we've moved the goal to the start, we can reach the end
        return goal == 0;
    }


    public static void main(String[] args) {
        System.out.println(new JumpGame().canJumpBackwardGreedy(new int[]{2,3,1,1,4}));
        System.out.println(new JumpGame().canJumpForward(new int[]{2,3,1,1,4}));
        System.out.println(new JumpGame().canJumpBackwardGreedy(new int[]{3,2,1,0,4}));
        System.out.println(new JumpGame().canJumpForward(new int[]{3,2,1,0,4}));
    }
}
