package org.D0911;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {

    /*
    The basic idea is to set a key for each group: the sum of the difference between the adjacent chars in one string.
    Then we can easily group the strings belonging to the same shifting sequence with the same key. The code is as the following:
     */
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            char c0 = str.charAt(0); //Use the first character in a string as a reference for each string.
            StringBuilder sb = new StringBuilder();
            for (char ch : str.toCharArray()) {
                sb.append("#");// we can use any separator here like "." ","
                sb.append((ch - c0 + 26) % 26); // Relative_distance = (s.charAt(i) - s.charAt(0) + 26 ) % 26
            }
            String s = sb.toString();
            map.putIfAbsent(s, new ArrayList<>());
            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
        /*
            return new ArrayList(Stream.of(strings).collect(Collectors.groupingBy(
        s -> s.chars().mapToObj(c -> (c - s.charAt(0) + 26) % 26)
              .collect(Collectors.toList()))).values());
        */
    }

    public static void main(String[] args) {
        System.out.println(new GroupShiftedStrings().groupStrings(new String[]{"abc","bcd","acef","xyz","az","ba","a","z"}));
        System.out.println(new GroupShiftedStrings().groupStrings(new String[]{"aei","zdh","acef","xyz","ay","ca"}));
        System.out.println(new GroupShiftedStrings().groupStrings(new String[]{"a"}));
    }


}
