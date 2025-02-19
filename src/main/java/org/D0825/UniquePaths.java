package org.D0825;

import java.util.Arrays;
/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths
that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:

Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down


Constraints:

1 <= m, n <= 100
 */
public class UniquePaths {

    /*
    Time complexity: O(N×M).
    Space complexity: O(N×M).
     */
    public int uniquePathsDP(int m, int n) {
        int[][] d = new int[m][n];

        for (int[] arr : d) {
            Arrays.fill(arr, 1);
        }
        for (int col = 1; col < m; ++col) {
            for (int row = 1; row < n; ++row) {
                d[col][row] = d[col - 1][row] + d[col][row - 1];
            }
        }
        return d[m - 1][n - 1];
    }
/*

In a particular path, there will be (m-1) D and (n-1) R.
For eg: in a 3x3 matrix - path can be DRDR, DDRR etc. (D = down, R = right)

Thus totalSteps = (m-1) + (n-1).
Now the number of ways to choose a specific number of moves D (m-1) or R(n-1) from a totalSteps without regard to order, is the total unique paths.
This is given by Binomial coefficient = nCr = C(n,r) = n!/(r! * (n-r)!)
which is calculated using the for loop where n=totalSteps & r=moves (here n-1 i.e sideMoves)

Time complexity:  O(n)
Space complexity: O(1)
 */
    public int uniquePathsOptimal(int m, int n) {
        long totalSteps = (long) m + n - 2;
        long moves = n - 1;
        long result = 1;

        // Calculate C(totalSteps, moves) (BINOMIAL COEFFICIENT) using long
        for (long i = 1; i <= moves; i++) {
            result = result * (totalSteps - moves + i) / i;
        }

        // Convert the final result to int and return
        return (int) result;
    }
}
