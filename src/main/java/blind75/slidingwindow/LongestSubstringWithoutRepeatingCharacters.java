package blind75.slidingwindow;

public class LongestSubstringWithoutRepeatingCharacters {

    //https://leetcode.com/problems/longest-substring-without-repeating-characters/editorial/comments/160158
    public int lengthOfLongestSubstring(String s) {
        int[] pos = new int[128];
        int maxlen = 0;
        int start = 0, end=0;
        for(char i:s.toCharArray()){
            start = Math.max(start, pos[i]);
            maxlen = Math.max(maxlen, end-start+1);
            pos[i] = end+1;
            end++;
        }
        return maxlen;
    }

    public static void main(String[] args) {
        /*
        Characters from index 1: x, z, y, c, d, a, ' ' so this return output 7
        Ascii value of space is 32
         */
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("axzycda "));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("axzycda"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"));
    }
}
