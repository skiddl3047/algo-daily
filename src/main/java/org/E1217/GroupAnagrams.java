package org.E1217;

import java.util.*;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:

Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

 */
public class GroupAnagrams {

    /*
    Total Time Complexity:

The algorithm's overall time complexity is: 𝑂(𝑛 * 𝑚)
n: Number of strings. & m: Average length of each string.

Total Space Complexity:

The total space complexity is: 𝑂(𝑛 * 𝑚)
n: Number of strings. & m: Average length of each string.

 */
    public List<List<String>> groupAnagramsOptimal(String[] strs) {
        HashMap<String,List<String>> freqMap = new HashMap<>();
        for(String str : strs) {
            String frequency = getFrequency(str);
            List<String> ang = freqMap.computeIfAbsent(frequency, k -> new ArrayList<>());
            ang.add(str);
        }
        return new ArrayList<>(freqMap.values());
    }

    private String getFrequency(String str){
        char[] arr = new char[26];
        char[] strArr = str.toCharArray();
        for(char c : strArr){
            arr[c-'a']++;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagramsOptimal(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    public List<List<String>> groupAnagramsLeetCodeEditorial(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
