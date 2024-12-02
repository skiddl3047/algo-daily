package org.D0825;

import java.util.*;

public class WordBreak {

    // Time Complexity : O(n ^ 2) - due to substring generation for each possible substring starting from each index
    // Space Complexity : O(n) - for wordMap
    /*
        In our specific problem, backtracking with memoization effectively acts like a top-down dynamic programming solution.
         The memoization step transforms what would be an exponential time complexity recursive solution into
         a polynomial one by storing intermediate results, similar to how a DP table would in a classical DP solution.

        Summary: While backtracking with memoization isn’t exactly traditional DP,
        it is closely related. By memoizing recursive calls, it becomes a form of dynamic programming,
        especially when solving problems with overlapping subproblems and an optimal substructure, as seen here.
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return canSegment(s, 0, wordSet, new HashMap<>());
    }

    private boolean canSegment(String s, int start, Set<String> wordSet, Map<Integer, Boolean> wordMap) {
        // If we reached the end of the string, return true
        if (start == s.length()) {
            return true;
        }
        // Check if result is already in wordMap
        if (wordMap.containsKey(start)) {
            return wordMap.get(start);
        }
        // Try every possible end index for the current starting point
        for (int end = start + 1; end <= s.length(); end++) {
            String currentSubstring = s.substring(start, end);
            // Check if substring is in word set and if the remaining can be segmented
            if (wordSet.contains(currentSubstring) && canSegment(s, end, wordSet, wordMap)) {
                wordMap.put(start, true);
                return true;
            }
        }
        // Mark this starting index as false in wordMap if no segmentation found
        wordMap.put(start, false);
        return false;
    }
    /*
        Dynamic Programming approach
        Time Complexity : O(n ^ 2) where n is the length of s. This is due to the nested loops.
        Space Complexity : O(n)  since we are using a boolean array dp of size n+1.
     */
    public boolean wordBreakDP(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();

        // DP array where dp[i] means s[0:i] can be segmented.
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // Empty string can be segmented.

        // Iterate through each substring s[0:i]
        for (int i = 1; i <= n; i++) {
            // Check for each possible substring s[j:i]
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
