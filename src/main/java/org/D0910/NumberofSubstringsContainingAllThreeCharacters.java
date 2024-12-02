package org.D0910;

/*
Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.



Example 1:
Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).

Example 2:
Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".

Example 3:
Input: s = "abc"
Output: 1

 */
public class NumberofSubstringsContainingAllThreeCharacters {

    public int numberOfSubstrings(String s) {
        int[] count = {0, 0, 0};
        int res = 0;
        int i = 0;
        int n = s.length();
        for (int j = 0; j < n; ++j) {
            ++count[s.charAt(j) - 'a'];
            while (count[0] > 0 && count[1] > 0 && count[2] > 0){
                --count[s.charAt(i++) - 'a'];
            }
            res += i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NumberofSubstringsContainingAllThreeCharacters().numberOfSubstrings("abcabc"));
        System.out.println(new NumberofSubstringsContainingAllThreeCharacters().numberOfSubstrings("aaacb"));
    }
}
