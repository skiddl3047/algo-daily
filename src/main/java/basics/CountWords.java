package basics;

import java.util.HashMap;
import java.util.Map;

public class CountWords {

    public static void main(String[] args) {
        System.out.println(new CountWords().countWords("Hello, How are you doing? Hello,"));
    }

    private Map<String, Integer> countWords(String input) {
        Map<String, Integer> map = new HashMap<>();
        String[] wordsArray = input.split("\\s+");

        for(String word : wordsArray) {
            map.put(word, map.getOrDefault(word, 0) +1);
        }
        return map;
    }
}
