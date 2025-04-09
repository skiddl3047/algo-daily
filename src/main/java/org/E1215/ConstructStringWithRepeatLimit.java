package org.E1215;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ConstructStringWithRepeatLimit {

    public String repeatLimitedString(String s, int repeatLimit) {

        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray())
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> Character.compare(b, a));

        for (char ch : freq.keySet())
            maxHeap.offer(ch);

        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();
            int count = freq.get(ch);

            int use = Math.min(count, repeatLimit);
            result.append(String.valueOf(ch).repeat(use));
            freq.put(ch, count - use);
            if (freq.get(ch) > 0 && !maxHeap.isEmpty()) {
                char nextCh = maxHeap.poll();
                result.append(nextCh);
                freq.put(nextCh, freq.get(nextCh) - 1);
                if (freq.get(nextCh) > 0) {
                    maxHeap.offer(nextCh);
                }
                maxHeap.offer(ch);
            }
        }
        return result.toString();
    }
}
