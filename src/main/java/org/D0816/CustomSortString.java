package org.D0816;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
// Time Complexity - O(n+m) Space Complexity - O(1)
    public static String customSortString(String order, String s) {
        int[] arr = new int[26];
        for(char ch:s.toCharArray())
            arr[ch-'a']++;

        StringBuilder result = new StringBuilder();
        for(char ch: order.toCharArray()){
            if(arr[ch-'a'] > 0){
                int length = arr[ch-'a'];
                for(int j=0; j<length; j++){
                    result.append(ch);
                    arr[ch-'a']--;
                }
            }
        }
        System.out.print(result.toString()+" final:");
        for(int i=0; i<26; i++){
            if(arr[i] > 0){
                for(int j=0; j<arr[i]; j++){
                    result.append((char)(i+'a')); //i+'a' will give correct letter
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(customSortString("cba", "abcd"));
        System.out.println(customSortString("abc", "aabbccdd"));
        System.out.println(customSortString("cab", "aabbccdd"));


        System.out.println(customSortStringWithMap("cba", "abcd"));
        System.out.println(customSortStringWithMap("abc", "aabbccdd"));
        System.out.println(customSortStringWithMap("cab", "aabbccdd"));
    }

    /*

    Step-1 : Create Frequency Map using characters in String
    Step-2 : Iterate over Order String characters and append characters from frequency map in the same order
    Step-3 : Iterate over remaining characters in frequency map and append it to the StringBuilder

    Here, we define N as the length of string s, and K as the length of string order.

Time Complexity: O(N)
It takes O(N) time to populate the frequency table, and all other hashmap operations performed
take O(1) time in the average case.
Building the result string also takes O(N) time because each letter from s is appended
to the result in the custom order, making the overall time complexity O(N).

Space Complexity: O(N) :
A hash map and a result string are created, which results in an additional space complexity of O(N).
     */
    public static String customSortStringWithMap(String order, String s) {
        // Create a frequency table
        Map<Character, Integer> freq = new HashMap<>();
        // Initialize frequencies of letters
        // freq[c] = frequency of char c in s
        int N = s.length();
        for (int i = 0; i < N; i++) {
            char letter = s.charAt(i);
            freq.put(letter, freq.getOrDefault(letter, 0) + 1);
        }
        // Iterate order string to append to result
        int K = order.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < K; i++) {
            char letter = order.charAt(i);
            while (freq.getOrDefault(letter, 0) > 0) {
                result.append(letter);
                freq.put(letter, freq.get(letter) - 1);
            }
        }
        // Iterate through freq and append remaining letters
        // This is necessary because some letters may not appear in `order`
        for (char letter : freq.keySet()) {
            int count = freq.get(letter);
            while (count > 0) {
                result.append(letter);
                count--;
            }
        }
        // Return the result
        return result.toString();
    }
}
