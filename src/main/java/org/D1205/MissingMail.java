package org.D1205;

public class MissingMail {

    public double getMaxExpectedProfit(int N, int[] V, int C, double S) {
        int n = V.length;
        S = 1 - S; // Adjust probability
        double[] dp = new double[n + 1];

        for (int i = 1; i <= n; ++i) {
            double sum = 0, w = 1;
            for (int j = i - 1; j >= 0; --j) {
                sum = sum + V[j] * w;
                w = w * S;
                dp[i] = Math.max(dp[i], dp[j] + sum);
            }
            dp[i] = dp[i] - C;
        }

        double maxProfit = Double.NEGATIVE_INFINITY;
        for (double profit : dp) {
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] input = new int[]{10, 2, 8, 6, 4};
        System.out.println(new MissingMail().getMaxExpectedProfit(5, input, 5,0.0));
        System.out.println(new MissingMail().getMaxExpectedProfit(5, input, 5,1.0));
        System.out.println(new MissingMail().getMaxExpectedProfit(5, input, 3,0.5));
        System.out.println(new MissingMail().getMaxExpectedProfit(5, input, 3,0.15));
    }
}
