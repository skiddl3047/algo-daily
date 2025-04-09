package blind75.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AAGroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> freqMap = new HashMap<>();
        for(String str : strs) {
            String frequency = getFrequency(str);
            List<String> ang = freqMap.computeIfAbsent(frequency, key -> new ArrayList<>());
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
        System.out.println(new AAGroupAnagrams().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
