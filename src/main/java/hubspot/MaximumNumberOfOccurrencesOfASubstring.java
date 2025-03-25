package hubspot;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfOccurrencesOfASubstring {

    //Tracking all possible sizes introduces unnecessary complexity since substrings of smaller sizes inherently "cover" their larger extensions.
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String,Integer> map=new HashMap<>();
        int res=0;
        int[] ch=new int[128];
        int left=0, right=0, letters=0;
        while(right < s.length()) {
            if (ch[s.charAt(right)] == 0) {
                letters++;
            }
            ch[s.charAt(right)]++;
            right++;
            while(letters > maxLetters || (right-left) > minSize){
                if(ch[s.charAt(left)] == 1) {
                    letters--;
                }
                ch[s.charAt(left)]--;
                left++;
            }
            if((right-left)==minSize){
                String sb=s.substring(left, right);
                map.put(sb, map.getOrDefault(sb,0) + 1);
                res=Math.max(res, map.get(sb));
            }
        }
        System.out.println(map);
        return res;
    }

    //https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/solutions/6105020/intuition-optimized-sliding-window
    public int maxFrequency(String s, int maxLetters, int minSize, int maxSize) {
        int maxFreq = 0;
        Map<Character, Integer> window = new HashMap<>();
        Map<String, Integer> substringCountMap = new HashMap<>();

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // Expand window
            char cr = s.charAt(right);
            window.put(cr, window.getOrDefault(cr, 0) + 1);

            // Fixed size sliding window
            if (right - left + 1 == minSize) {
                // Check if the window has at most 'maxLetters' distinct characters
                if (window.size() <= maxLetters) {
                    String sub = s.substring(left, right + 1);
                    substringCountMap.put(sub, substringCountMap.getOrDefault(sub, 0) + 1);
                    maxFreq = Math.max(maxFreq, substringCountMap.get(sub));
                }
                // Shrink window
                char cl = s.charAt(left);
                window.put(cl, window.get(cl) - 1);
                if (window.get(cl) == 0)
                    window.remove(cl);
                left++;
            }
        }
        System.out.println(substringCountMap);
        return maxFreq;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumNumberOfOccurrencesOfASubstring().maxFrequency("abcdabcde",4,3,4));
        System.out.println(new MaximumNumberOfOccurrencesOfASubstring().maxFreq("abcdabcde",4,3,4));
        System.out.println(new MaximumNumberOfOccurrencesOfASubstring().maxFrequency("aaaabbbb",3,3,4));
        System.out.println(new MaximumNumberOfOccurrencesOfASubstring().maxFreq("aaaabbbb",3,3,4));
        System.out.println(new MaximumNumberOfOccurrencesOfASubstring().maxFrequency("aababcaab",2,3,4));
        System.out.println(new MaximumNumberOfOccurrencesOfASubstring().maxFreq("aababcaab",2,3,4));
    }
}
