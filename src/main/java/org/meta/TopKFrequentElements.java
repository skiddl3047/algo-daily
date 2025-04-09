package org.meta;

import java.util.*;

public class TopKFrequentElements {
/*
A PriorityQueue is what is called a binary heap. It is only ordered/sorted in the sense that the first element is the least. In other word, it only cares about what is in the front of the queue, the rest are "ordered" when needed.

The elements are only ordered as they are dequeued, i.e. removed from the queue using poll(). This is the reason why a PriorityQueue manages to have such good performance, as it is not doing any more sorting than it needs at any time.
 */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        System.out.println(Arrays.toString(map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray()));

        //PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        //PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }
        //p.addAll(map.entrySet());
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequent(new int[]{30, 30, 30, 47, 47, 55}, 2)));
    }
}
