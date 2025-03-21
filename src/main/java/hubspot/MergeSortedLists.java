package hubspot;

import java.util.*;

public class MergeSortedLists {

    static class Node implements Comparable<Node> {
        int value;
        int listIndex;
        int elementIndex;

        public Node(int value, int listIndex, int elementIndex) {
            this.value = value;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }

        @Override
        public int compareTo(Node other) {
            return this.value - other.value;
        }
    }

    public static List<Integer> mergeAndCut(List<List<Integer>> lists, int k) {
        List<Integer> result = new ArrayList<>();
        if (k <= 0 || lists == null || lists.isEmpty()) {
            return result;
        }

        PriorityQueue<Node> heap = new PriorityQueue<>();

        // Initialize the heap with the first element of each non-empty list
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            if (list != null && !list.isEmpty()) {
                heap.offer(new Node(list.getFirst(), i, 0));
            }
        }

        // Merge until we reach k elements or the heap is empty
        while (!heap.isEmpty() && result.size() < k) {
            Node node = heap.poll();
            result.add(node.value);

            // Move to the next element in the current list
            int nextElementIndex = node.elementIndex + 1;
            List<Integer> currentList = lists.get(node.listIndex);
            if (nextElementIndex < currentList.size()) {
                heap.offer(new Node(currentList.get(nextElementIndex), node.listIndex, nextElementIndex));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1, 3, 5));
        lists.add(Arrays.asList(2, 4, 6));
        lists.add(Arrays.asList(7, 9));

        int k = 5;
        List<Integer> merged = mergeAndCut(lists, k);
        System.out.println(merged); // Output: [1, 2, 3, 4, 5]
    }
}
