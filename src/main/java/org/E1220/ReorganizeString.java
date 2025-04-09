package org.E1220;
/*
Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.


Example 1:

Input: s = "aab"
Output: "aba"
Example 2:

Input: s = "aaab"
Output: ""


Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
 */
public class ReorganizeString {

    /*
    Complexity Analysis :
    Let N be the total characters in the string.
    Let k be the total unique characters in the string.

    Time complexity: O(N). We will have to iterate over the entire string once to gather the counts of each character.
    Then, we place each character in the answer which costs O(N).

    Space complexity: O(k). The counter used to count the number of occurrences will incur a space complexity of O(k).
    Again, one could argue that because k <= 26, the space complexity is constant.
     */
    public String reorganizeString(String s) {
        int[] charCounts = new int[26];
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }
        int maxCount = 0, letter = 0;
        for (int i = 0; i < charCounts.length; i++) {
            if (charCounts[i] > maxCount) {
                maxCount = charCounts[i];
                letter = i;
            }
        }
        if (maxCount > (s.length() + 1) / 2) {
            return "";
        }
        char[] ans = new char[s.length()];
        int index = 0;

        // Place the most frequent letter
        while (charCounts[letter] != 0) {
            ans[index] = (char) (letter + 'a');
            index += 2;
            charCounts[letter]--;
        }

        // Place rest of the letters in any order
        for (int i = 0; i < charCounts.length; i++) {
            while (charCounts[i] > 0) {
                if (index >= s.length()) {
                    index = 1;
                }
                ans[index] = (char) (i + 'a');
                index += 2;
                charCounts[i]--;
            }
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        System.out.println(new ReorganizeString().reorganizeString("aabbcaabcd"));
        System.out.println(new ReorganizeString().reorganizeString("aab"));
        System.out.println(new ReorganizeString().reorganizeString("aaab"));
    }
}
