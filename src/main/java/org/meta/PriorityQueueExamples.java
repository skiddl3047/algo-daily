package org.meta;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExamples {
/*
A PriorityQueue is what is called a binary heap.
It is only ordered/sorted in the sense that the first element is the least.
In other word, it only cares about what is in the front of the queue,
the rest are "ordered" when needed.

The elements are only ordered as they are dequeued, i.e. removed from the queue using poll(). This is the reason why a PriorityQueue manages to have such good performance, as it is not doing any more sorting than it needs at any time.
 */
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        pq.offer(1);
        pq.offer(2);
        pq.offer(3);
        System.out.println(pq);
    }
}
