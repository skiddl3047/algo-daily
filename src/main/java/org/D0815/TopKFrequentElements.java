package org.D0815;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public int[] topKFrequentWithStream(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        int[] res = map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
        return res;
    }

    public int[] topKFrequentWithPriorityQueue(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int num: nums){
            m.put(num, m.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> p = new PriorityQueue<>((a, b) -> b.getValue()-a.getValue());
        p.addAll(m.entrySet());
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = p.poll().getKey();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequentWithStream(new int[]{1,1,1,2,2,3}, 2)));

        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequentWithPriorityQueue(new int[]{1,1,1,2,2,3}, 2)));
    }
}
