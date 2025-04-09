package org.D0901;

/*
Given a string s, return true if the s can be palindrome after deleting at most one character from it.



Example 1:
Input: s = "aba"
Output: true

Example 2:
Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.

Example 3:
Input: s = "abc"
Output: false


Constraints:
1 <= s.length <= 105
s consists of lowercase English letters.
 */
public class ValidPalindromeII {

    /*
Complexity Analysis

Given N as the length of s,

Time complexity: O(N).
The main while loop we use can iterate up to N / 2 times, since each iteration represents a pair of characters.
On any given iteration, we may find a mismatch and call checkPalindrome twice.
checkPalindrome can also iterate up to N / 2 times, in the worst case where the first and last character of s do not match.
Because we are only allowed up to one deletion, the algorithm only considers one mismatch. This means that checkPalindrome will never be called more than twice.
As such, we have a time complexity of O(N).

Space complexity: O(1).
The only extra space used is by the two pointers i and j, which can be considered constant relative to the input size.
*/

    private boolean checkPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // Found a mismatched pair - try both deletions
            if (s.charAt(left) != s.charAt(right)) {
                return (checkPalindrome(s, left, right - 1) || checkPalindrome(s, left + 1, right));
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindromeII().validPalindrome("aba"));
        System.out.println(new ValidPalindromeII().validPalindrome("abca"));
        System.out.println(new ValidPalindromeII().validPalindrome("aabaac"));
        System.out.println(new ValidPalindromeII().validPalindrome("caabaa"));
    }
}
