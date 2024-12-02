package org.D0829;

public class HouseRobber {

    /*
    robFrom(i)=max(robFrom(i+1),robFrom(i+2)+nums(i))


Time Complexity: O(N) since we have a loop from N−2⋯0 and we use the precalculated values of our dynamic programming table to calculate the current value in the table which is a constant time operation.

Space Complexity: O(1) since we are not using a table to store our values.
Simply using two variables will suffice for our calculations.
    */
    public int rob(int[] nums) {
        int N = nums.length;
        // Special handling for empty array case.
        if (N == 0) {
            return 0;
        }
        int robNext, robNextPlusOne;
        // Base case initializations.
        robNextPlusOne = 0;
        robNext = nums[N - 1];
        // DP table calculations. Note: we are not using any
        // table here for storing values. Just using two
        // variables will suffice.
        for (int i = N - 2; i >= 0; --i) {
            // Same as the recursive solution.
            int current = Math.max(robNext, robNextPlusOne + nums[i]);
            // Update the variables
            robNextPlusOne = robNext;
            robNext = current;
        }
        return robNext;
    }


}
