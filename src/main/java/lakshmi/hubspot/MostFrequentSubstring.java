package lakshmi.hubspot;

import java.util.HashMap;
import java.util.Map;

// Time Complexity: O(n * k) (effectively O(n) for practical k)
// Breakdown:
// The loop runs (n - k + 1) times → which is O(n).
// Inside the loop:
// substring(i, i + k) takes O(k) time (because Java creates a new string).
// map.getOrDefault() and map.put() are O(1) on average (HashMap operations).
// So overall:
// O(n) iterations × O(k) per substring extraction = O(n * k) time complexity.
// If k is much smaller than n (which is typical), this simplifies to O(n) in practice.

// Space Complexity: O(n) (or more precisely O(u * k))
// Breakdown:
// The HashMap stores up to u unique substrings of length k, where:
// u ≤ (n - k + 1)
// Each key is a substring of length k, and value is an integer.
// So:
// The space taken by the map is O(u * k).
// In the worst case (all substrings are unique), u = O(n), so:
// Space = O(n * k) → but typically treated as O(n).
// Again, if k is constant/small, it simplifies to O(n).

public class MostFrequentSubstring {
    public static void main(String[] args) {
        String input = "abcdabcdabcabc";
        String result = findMostFrequentSubstring(input, 3);
        System.out.println(result);
    }

    private static String findMostFrequentSubstring(String input, int substringLength) {
        if (input == null || substringLength <= 0 || input.length() < substringLength) {
            return "";
        }

        String mostFrequent = "";
        int highestFrequency = 0;
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i <= input.length() - substringLength; i++) {
            String currentSubstring = input.substring(i, i + substringLength);
            int currentCount = frequencyMap.getOrDefault(currentSubstring, 0) + 1;
            frequencyMap.put(currentSubstring, currentCount);

            if (currentCount > highestFrequency) {
                highestFrequency = currentCount;
                mostFrequent = currentSubstring;
            }
        }

        return mostFrequent;
    }
}