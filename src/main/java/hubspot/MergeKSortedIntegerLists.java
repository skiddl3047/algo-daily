package hubspot;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class MergeKSortedIntegerLists {

    /*
        Operation	            Complexity
        Heap Initialization	        O(K log K)
        Heap Operations	            O(N log K)
        Total Time Complexity	    O(N log K)
        Space Complexity	        O(K) (for heap) + O(N) (for result)
    */
    public static List<Integer> mergeKLists(List<List<Integer>> lists) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));
        List<Integer> result = new ArrayList<>();
        // Add the first element of each list into the heap
        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty()) {
                minHeap.offer(new Element(lists.get(i).getFirst(), i, 0));
            }
        }
        // Extract the minimum element and add the next element from the corresponding list
        while (!minHeap.isEmpty()) {
            Element current = minHeap.poll();
            result.add(current.value);

            int nextIndex = current.indexInList + 1;
            if (nextIndex < lists.get(current.listIndex).size()) {
                minHeap.offer(new Element(lists.get(current.listIndex).get(nextIndex), current.listIndex, nextIndex));
            }
        }
        return result;
    }

    static class Element {
        int value, listIndex, indexInList;
        Element(int value, int listIndex, int indexInList) {
            this.value = value;
            this.listIndex = listIndex;
            this.indexInList = indexInList;
        }
    }

    // Example usage
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(List.of(1, 4, 5));
        lists.add(List.of(1, 3, 4));
        lists.add(List.of(2, 6));

        List<Integer> mergedList = mergeKLists(lists);
        System.out.println(mergedList); // Output: [1, 1, 2, 3, 4, 4, 5, 6]
    }
    /*
        Time & Space Complexity
        Operation	                    Complexity
        Heap Initialization	                O(K log K)
        Heap Operations (restricted to m)	O(m log K)
        Total Time Complexity	            O(m log K)
        Space Complexity	                O(K + m) (heap + result)
     */

    public static List<Integer> mergeKLists(List<List<Integer>> lists, int m) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));
        List<Integer> result = new ArrayList<>();

        // Add the first element of each list into the heap
        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty()) {
                minHeap.offer(new Element(lists.get(i).getFirst(), i, 0));
            }
        }
        // Extract the minimum element and add the next element from the corresponding list
        while (!minHeap.isEmpty() && result.size() < m) {
            Element current = minHeap.poll();
            result.add(current.value);
            int nextIndex = current.indexInList + 1;
            if (nextIndex < lists.get(current.listIndex).size()) {
                minHeap.offer(new Element(lists.get(current.listIndex).get(nextIndex), current.listIndex, nextIndex));
            }
        }
        return result;
    }
}

