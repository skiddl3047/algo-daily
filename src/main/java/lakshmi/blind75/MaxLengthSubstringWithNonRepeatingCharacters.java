package lakshmi.blind75;

import java.util.HashSet;
import java.util.Set;

// Time Complexity: O(n) - n is the length of the input string.
// Each character is processed at most twice:
// Once when it is added to the hashSet.
// Once when it is removed due to a duplicate being found (inside the while loop).
// So, the for loop and the while loop together run in linear time relative to the length of the input.

//Space Complexity: O(min(n, m)) n is the length of the input string.
// m is the size of the character set (e.g., 26 for lowercase English letters, 128 for ASCII).
// In the worst case, the set stores every character of the string, so:
// If all characters are unique, it stores n elements.
// But typically, it’s limited by the character set size.
// So space complexity is O(min(n, m)).
public class MaxLengthSubstringWithNonRepeatingCharacters {

    public static void main(String[] args) {
        String inputString = "abbcdaddddead";
        int length = findMaxLengthSubstringWithNonRepeatingCharacters(inputString);
        System.out.println(length);
    }

    private static int findMaxLengthSubstringWithNonRepeatingCharacters(String inputString) {
        Set<Character> hashSet = new HashSet<>();
        int left = 0, maxLength = 0;
        for (int right = 0; right < inputString.length(); right++) {

            while(hashSet.contains(inputString.charAt(right))) {
                hashSet.remove(inputString.charAt(left));
                left ++;
            }

            hashSet.add(inputString.charAt(right));
            maxLength = Math.max(maxLength, right-left+1);

        }
        return maxLength;
    }
}
