package org.E1212;

import java.util.Arrays;

/*
You are given an integer array coins representing coins of different denominations and
an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Example 3:
Input: coins = [1], amount = 0
Output: 0

Constraints:
1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
 */
/*
Hint : Take coins=[1,2,5] and amount = 11 as an example,

If I use one 1, I need to know the fewest number of coins I need to make up 10, i.e.,
dp[10]. Overall I need 1+dp[10] coins.

If I use one 2, I need 1+dp[9] coins.

If I use one 5, I need 1+dp[6] coins.
Therefore, I need to calculate dp from 1 to amount.
 */
public class CoinChange {

    /*
Time complexity : O(S∗n).
On each step the algorithm finds the next F(i) in n iterations, where 1≤i≤S. Therefore in total the iterations are S∗n.
Space complexity : O(S).
We use extra space for the memoization table.*/
    public int coinChangeBottomUp(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];

    }

    public int coinChangeTopDown(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
}
