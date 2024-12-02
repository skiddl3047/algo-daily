package org.D0814;

/*
Given two words returns-the least number-of characters between their two midpoints in number-of characters
* Words-can appear multiple times in any order and should be case insensitive.
E.g. for the document="This is a sample document we just made up"
leastNumberOfCharacters (•document, "we", "just" ) == 4
leastNumberofCharacters document, "is", "a" ) == 2.5
leastNumberOfCharacters (•document, "is", "not"）・==-1
 */
import java.util.ArrayList;
import java.util.List;

public class LeastNumberOfCharacters {

    public double leastNumberOfCharacters(String document, String word1, String word2) {
        // Normalize the document and words to lower case for case-insensitivity
        document = document.toLowerCase();
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        // Lists to store the midpoints of word1 and word2
        List<Double> midPointsWord1 = new ArrayList<>();
        List<Double> midPointsWord2 = new ArrayList<>();

        // Find all occurrences of word1 and word2 in the document
        int index = 0;
        while ((index = document.indexOf(word1, index)) != -1) {
            double midpoint = index + (word1.length() / 2.0);
            midPointsWord1.add(midpoint);
            index += word1.length();
        }

        index = 0;
        while ((index = document.indexOf(word2, index)) != -1) {
            double midpoint = index + (word2.length() / 2.0);
            midPointsWord2.add(midpoint);
            index += word2.length();
        }

        // If either word is not found, return -1
        if (midPointsWord1.isEmpty() || midPointsWord2.isEmpty()) {
            return -1;
        }

        // Find the minimum distance between any pair of midpoints
        double minDistance = Double.MAX_VALUE;
        for (double mid1 : midPointsWord1) {
            for (double mid2 : midPointsWord2) {
                double distance = Math.abs(mid1 - mid2);
                minDistance = Math.min(minDistance, distance);
            }
        }

        return minDistance;
    }

    public static void main(String[] args) {
        LeastNumberOfCharacters solver = new LeastNumberOfCharacters();
        String document = "This is a sample document we just made up";

        System.out.println(solver.leastNumberOfCharacters(document, "we", "just")); // Output: 4.0
        System.out.println(solver.leastNumberOfCharacters(document, "is", "a")); // Output: 2.5
        System.out.println(solver.leastNumberOfCharacters(document, "is", "not")); // Output: -1
    }
}
