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
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));

        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringOptimal("abcabcbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringOptimal("bbbbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringOptimal("pwwkew"));
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
