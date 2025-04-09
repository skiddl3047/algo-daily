package amazon.coding;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeBasedKeyValueStore {

    HashMap<String, ArrayList<Pair<Integer, String>>> keyTimeMap;

    public TimeBasedKeyValueStore() {
        keyTimeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!keyTimeMap.containsKey(key)) {
            keyTimeMap.put(key, new ArrayList<>());
        }

        // Store '(timestamp, value)' pair in 'key' bucket.
        keyTimeMap.get(key).add(new Pair<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        // If the 'key' does not exist in map we will return empty string.
        if (!keyTimeMap.containsKey(key)) {
            return "";
        }

        if (timestamp < keyTimeMap.get(key).getFirst().getKey()) {
            return "";
        }

        // Using binary search on the list of pairs.
        int left = 0;
        int right = keyTimeMap.get(key).size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (keyTimeMap.get(key).get(mid).getKey() <= timestamp) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // If iterator points to first element it means, no time <= timestamp exists.
        if (right == 0) {
            return "";
        }

        return keyTimeMap.get(key).get(right - 1).getValue();
    }

    public static void main(String[] args) {
        TimeBasedKeyValueStore timeMap = new TimeBasedKeyValueStore();
        List<Object> output = new ArrayList<>();

        // Constructor call
        output.add(null);
        // set("foo", "bar", 1)
        timeMap.set("foo", "bar", 1);
        output.add(null);
        // get("foo", 1)
        output.add(timeMap.get("foo", 1));
        // get("foo", 3)
        output.add(timeMap.get("foo", 3));
        // set("foo", "bar2", 4)
        timeMap.set("foo", "bar2", 4);
        output.add(null);
        // get("foo", 4)
        output.add(timeMap.get("foo", 4));
        // get("foo", 5)
        output.add(timeMap.get("foo", 5));
        // Format the output to match the expected format
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < output.size(); i++) {
            Object element = output.get(i);
            if (element == null) {
                sb.append("null");
            } else {
                sb.append("\"").append(element).append("\"");
            }
            if (i < output.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

}
