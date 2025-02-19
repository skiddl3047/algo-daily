package org.D0817;

public class MaximumSquareIsland {

    public int maximalSquare(int[][] matrix) {
        // Handle edge case: if the matrix is empty, return 0.
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int maxSide = 0;

        // Create a DP table with dimensions (m+1) x (n+1)
        // We use extra row and column to simplify boundary handling.
        int[][] dp = new int[m + 1][n + 1];

        // Iterate over each cell of the matrix (using 1-indexed dp)
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the current cell in the original matrix is land:
                if (matrix[i - 1][j - 1] == 1) {
                    // The side length of the largest square ending here is:
                    dp[i][j] = Math.min(
                            Math.min(dp[i - 1][j], dp[i][j - 1]),
                            dp[i - 1][j - 1] ) + 1;
                    // Update maxSide if needed.
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
                // Else dp[i][j] remains 0 (default), meaning no square can end here.
            }
        }

        // The area of the largest square is the square of its side length.
        return maxSide * maxSide;
    }

    // A simple main method to test the solution.
    public static void main(String[] args) {

        // Example 1: A grid where the largest square has an area of 4 (side length 2)
        int[][] matrix1 = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };
        System.out.println("Maximal Square Area: " + new MaximumSquareIsland().maximalSquare(matrix1));

        // Example 2: A simple grid with a single 1 gives an area of 1.
        int[][] matrix2 = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println("Maximal Square Area: " + new MaximumSquareIsland().maximalSquare(matrix2));
    }
}
