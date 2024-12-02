package org.D0903;

import java.util.HashSet;
import java.util.Set;

/*
Given a string s, return true if a permutation of the string could form a palindrome and false otherwise.



Example 1:
Input: s = "code"
Output: false

Example 2:
Input: s = "aab"
Output: true

Example 3:
Input: s = "carerac"
Output: true


Constraints:

1 <= s.length <= 5000
s consists of only lowercase English letters.
 */
public class PalindromePermutation {
/*
Time complexity : O(n). We traverse over the string s of length n once only.
Space complexity : O(1). The set can grow up to a maximum number of all distinct elements.
However, the number of distinct characters are bounded, so as the space complexity.
 */
    public boolean canPermutePalindromeUsingSet(String s) {
        Set< Character> set = new HashSet< >();
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i)))
                set.remove(s.charAt(i));
        }
        return set.size() <= 1;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePermutation().canPermutePalindromeUsingSet("aab"));
        System.out.println(new PalindromePermutation().canPermutePalindromeUsingSet("code"));
        System.out.println(new PalindromePermutation().canPermutePalindromeUsingSet("carerac"));
    }

    /*
    Complexity Analysis

Time complexity : O(n). We traverse over the string s of length n once only.
Space complexity : O(1). A map of constant size(128) is used.
     */
    public boolean canPermutePalindromeUsingArray(String s) {
        int[] map = new int[128];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            if (map[s.charAt(i)] % 2 == 0)
                count--;
            else
                count++;
        }
        return count <= 1;
    }
}
