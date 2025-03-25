package hubspot;

import java.util.HashMap;

public class MostFrequentSubstring {

    /*
    Time Complexity: O(n): The sliding window ensures that each character is processed only once,
            and substring construction is done in constant time.

    Space Complexity: O(n): The HashMap still stores up to O(n - k + 1) substrings in the worst case.
     */
    public static String findMostFrequentSubstring(String s, int k) {
        if (s == null || s.length() < k || k <= 0) {
            return ""; // Return empty string if input is invalid
        }

        HashMap<String, Integer> substringCount = new HashMap<>();
        int maxCount = 0;
        String result = "";

        // Initialize the first substring of length k
        StringBuilder window = new StringBuilder(s.substring(0, k));
        substringCount.put(window.toString(), 1);
        maxCount = 1;
        result = window.toString();

        // Slide the window across the string
        for (int i = k; i < s.length(); i++) {
            // Remove the first character and add the next character
            window.deleteCharAt(0);
            window.append(s.charAt(i));

            String currentSubstring = window.toString();
            substringCount.put(currentSubstring, substringCount.getOrDefault(currentSubstring, 0) + 1);

            // Update the result if this substring has a higher count
            if (substringCount.get(currentSubstring) >= maxCount) {
                maxCount = substringCount.get(currentSubstring);
                result = currentSubstring;
            }
        }
        System.out.println(substringCount);
        return result;
    }

    public static void main(String[] args) {
        String s = "aabbaaa";
        int k = 2;
        System.out.println("Most frequent substring of length " + k + ": " + findMostFrequentSubstring(s, k));
        k=4;
        System.out.println("Most frequent substring of length " + k + ": " + findMostFrequentSubstring("abcdabcde", k));
        k=5;
        System.out.println("Most frequent substring of length " + k + ": " + findMostFrequentSubstring("abcdabcde", k));
    }

    public static String findMostFrequentSubstringRollingHash(String s, int k) {
        if (s == null || s.length() < k || k <= 0) {
            return ""; // Return empty string if input is invalid
        }

        HashMap<Integer, Integer> substringCount = new HashMap<>();
        int maxCount = 0;
        String result = "";

        int base = 26; // Assuming lowercase English letters
        int hash = 0;
        int basePower = 1;

        // Compute the hash for the first substring of length k
        for (int i = 0; i < k; i++) {
            hash = hash * base + (s.charAt(i) - 'a');
            if (i < k - 1) {
                basePower *= base;
            }
        }
        substringCount.put(hash, 1);
        maxCount = 1;
        result = s.substring(0, k);

        // Slide the window across the string
        for (int i = k; i < s.length(); i++) {
            // Update the hash: remove the first character and add the next character
            hash = hash - (s.charAt(i - k) - 'a') * basePower;
            hash = hash * base + (s.charAt(i) - 'a');

            substringCount.put(hash, substringCount.getOrDefault(hash, 0) + 1);

            // Update the result if this substring has a higher count
            if (substringCount.get(hash) > maxCount) {
                maxCount = substringCount.get(hash);
                result = s.substring(i - k + 1, i + 1);
            }
        }
        return result;
    }
}
