package hubspot;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfOccurrencesOfASubstring {

    /*
        Understanding the Algorithm
We use a sliding window approach to find substrings of length minSize.

The ch array (size 26) tracks character frequencies in the current window.

A HashMap<String, Integer> keeps frequency counts of valid substrings.

The loop expands and shrinks the window while ensuring:

The substring has at most maxLetters unique characters.

The substring length does not exceed minSize.

If a valid substring is found, we update the frequency in map and track the max frequency.

Time Complexity Analysis :

Sliding Window Processing
We iterate through s once (right moves from 0 to s.length()), meaning the outer while loop runs O(N) times.
The inner while loop (shrinking left) runs at most O(N) times overall since each character is processed once.
Extracting substrings using s.substring(left, right) takes O(minSize) time in each valid case.

HashMap Operations
Each valid substring (length = minSize) is stored in map and updated.

Worst case: all substrings of length minSize are unique, leading to O(N) insertions.

Overall Complexity
Sliding window traversal: O(N)
Substring extraction: O(minSize) per valid substring, at most O(N) substrings → O(N * minSize)
HashMap insertions & lookups: O(N)

Total worst-case time complexity: O(N x minSize)
Since minSize is small (compared to N), it can be treated as a constant, making the complexity O(N) in practical cases.

Space Complexity Analysis
Space Usage
Character frequency array (ch[26]) → O(1) (constant space).

HashMap (map) storage:

In the worst case, each substring of length minSize is unique.

This results in storing O(N) substrings, each of length minSize, leading to O(N * minSize) space.

Total Space Complexity: O(N⋅minSize)
Again, if minSize is small, this is approximately O(N).
     */
    //Tracking all possible sizes introduces unnecessary complexity since
    // substrings of smaller sizes inherently "cover" their larger extensions.
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String,Integer> map=new HashMap<>();
        int result=0;
        int[] charCount=new int[26];
        int left=0, right=0, currLettersCount =0;
        while(right < s.length()) {
            if (charCount [s.charAt(right++) -97]++ == 0) { // first if condition check
                currLettersCount ++;
            }
//            charCount [s.charAt(right) - 97]++;
//            right++;
            while(currLettersCount  > maxLetters || (right-left) > minSize){
                if(charCount [s.charAt(left++) -97 ]-- == 1) {
                    currLettersCount --;
                }
//                charCount [s.charAt(left) - 97]--;
//                left++;
            }
            if((right-left)==minSize){
                String sb=s.substring(left, right);
                map.put(sb, map.getOrDefault(sb,0) + 1);
                result=Math.max(result, map.get(sb));
            }
        }
        System.out.println(map);
        return result;
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
        System.out.println(new MaximumNumberOfOccurrencesOfASubstring().maxFreq("aababcaab",2,3,4));
        System.out.println(new MaximumNumberOfOccurrencesOfASubstring().maxFreq("abc",1,1,2));
        System.out.println(new MaximumNumberOfOccurrencesOfASubstring().maxFrequency("abcdabcde",4,3,4));
        System.out.println(new MaximumNumberOfOccurrencesOfASubstring().maxFreq("abcdabcde",4,3,4));
        System.out.println(new MaximumNumberOfOccurrencesOfASubstring().maxFrequency("aaaabbbb",3,3,4));
        System.out.println(new MaximumNumberOfOccurrencesOfASubstring().maxFreq("aaaabbbb",3,3,4));
        System.out.println(new MaximumNumberOfOccurrencesOfASubstring().maxFrequency("aababcaab",2,3,4));
        System.out.println(new MaximumNumberOfOccurrencesOfASubstring().maxFreq("aababcaab",2,3,4));
    }
}
