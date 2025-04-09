package org.E1216;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    //https://leetcode.com/problems/longest-substring-without-repeating-characters/editorial/comments/160158
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int maxLength=0;
        int left=0;
        int right =0;
        while(right < s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right++));
                maxLength=Math.max(maxLength,set.size());
            }else{
                set.remove(s.charAt(left++));
            }

        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().findLongestUniqueSubstring("abcabcbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().findLongestUniqueSubstring("bbbbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().findLongestUniqueSubstring("pwwkew"));

        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));

        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringOptimal("abcabcbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringOptimal("bbbbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringOptimal("pwwkew"));
    }

    public String findLongestUniqueSubstring(String s) {
        int left = 0, right = 0, maxLength = 0, start = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < s.length()) {
            char ch = s.charAt(right);

            // If duplicate character found, move left pointer
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            // Update max length and starting index of substring
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                start = left;
            }
            right++;
        }

        // Extract the substring
        return s.substring(start, start + maxLength);
    }

    public int lengthOfLongestSubstringOptimal(String s) {
        int[] pos=new int[128];
        int maxlen=0;
        int start=0,end=0;
        for(char i:s.toCharArray()){
            start=Math.max(start,pos[i]);
            maxlen=Math.max(maxlen,end-start+1);
            pos[i]=end+1;
            end++;
        }
        return maxlen;
    }
}
