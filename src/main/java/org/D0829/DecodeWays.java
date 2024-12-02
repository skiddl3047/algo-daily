package org.D0829;

/*
You have intercepted a secret message encoded as a string of numbers. The message is decoded via the following mapping:

"1" -> 'A'
"2" -> 'B'
...

"25" -> 'Y'
"26" -> 'Z'

However, while decoding the message, you realize that there are many different ways you can decode the message because some codes are contained in other codes ("2" and "5" vs "25").

For example, "11106" can be decoded into:

"AAJF" with the grouping (1, 1, 10, 6)
"KJF" with the grouping (11, 10, 6)
The grouping (1, 11, 06) is invalid because "06" is not a valid code (only "6" is valid).
Note: there may be strings that are impossible to decode.

Given a string s containing only digits, return the number of ways to decode it.
If the entire string cannot be decoded in any valid way, return 0.

The test cases are generated so that the answer fits in a 32-bit integer.

Example 1:
Input: s = "12"
Output: 2
Explanation:
"12" could be decoded as "AB" (1 2) or "L" (12).

Example 2:
Input: s = "226"
Output: 3
Explanation:
"226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

Example 3:
Input: s = "06"
Output: 0
Explanation:
"06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
In this case, the string is not a valid encoding, so return 0.
Constraints:

1 <= s.length <= 100
s contains only digits and may contain leading zero(s).
 */
public class DecodeWays {

    /*
    In Approach 2 we are using an array dp to save the results for future.
    As we move ahead character by character of the given string, we look back only two steps.
    For calculating dp[i] we need to know dp[i-1] and dp[i-2] only.
    Thus, we can easily cut down our O(N) space requirement to O(1) by using only two variables to store the last two results.
     */
    /*
    Complexity Analysis
Time Complexity: O(N), where N is length of the string.
We're essentially doing the same work as what we were in Approach 2, except this time we're throwing away calculation results when we no longer need them.
Space Complexity: O(1). Instead of a dp array, we're simply using two variables.
     */
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int twoBack = 1;
        int oneBack = 1;
        for (int i = 1; i < n; i++) {
            int current = 0;
            if (s.charAt(i) != '0') {
                current = oneBack;
            }
            int twoDigit = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigit >= 10 && twoDigit <= 26) {
                current += twoBack;
            }
            twoBack = oneBack;
            oneBack = current;
        }
        return oneBack;
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("12"));
        System.out.println(new DecodeWays().numDecodings("2125"));
    }
/*
    Time Complexity: O(N), where N is length of the string. We iterate the length of dp array which is N+1.
    Space Complexity: O(N). The length of the DP array.
*/
    public int numDecodingsDP(String s) {
        // DP array to store the subproblem results
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        // Ways to decode a string of size 1 is 1. Unless the string is '0'.
        // '0' doesn't have a single digit decode.
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < dp.length; i++) {
            // Check if successful single digit decode is possible.
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }

            // Check if successful two digit decode is possible.
            int twoDigit = Integer.valueOf(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
