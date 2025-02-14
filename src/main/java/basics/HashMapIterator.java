package basics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapIterator {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "Orange");
        map.put("2", "Apple");
        new HashMapIterator().iterateUsingWhile(map);
        new HashMapIterator().iterateUsingAdvancedForLoop(map);
    }

    private void iterateUsingAdvancedForLoop(Map<String, String> map) {
        for(Map.Entry<String, String> entry: map.entrySet()) {
          System.out.println(entry.getKey() + "-----" + entry.getValue());
        }
    }

    private void iterateUsingWhile(Map<String, String> map) {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entrySet = iterator.next();
            System.out.println(entrySet.getKey() + "--------" + entrySet.getValue());
        }
    }
}
