package lakshmi.hubspot;

import java.util.*;

// SC - O(min(n + m, limit))
// TC - O(min(n + m, limit))
public class MergeSortedLists {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 3, 5,7);
        List<Integer> list2 = Arrays.asList(2, 4, 6,8);
        List<Integer> mergedList = mergeSortedLists(list1, list2, 100);
        mergedList.forEach(System.out::println);
    }

    private static List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2, int limit) {
        int list1Size = Objects.nonNull(list1) ? list1.size() : 0;
        int list2Size = Objects.nonNull(list2) ? list2.size() : 0;
        if (limit < 0 ||  (list1Size == 0 &&  list2Size == 0)) {
            return Collections.emptyList();
        }
        int actualResultSize = Math.min(limit, list1Size + list2Size);
        List<Integer> mergedList = new ArrayList<>(actualResultSize);
        int i = 0, j = 0;
        while (i < list1Size && j < list2Size && mergedList.size() < limit) {
            if (list1.get(i) < list2.get(j)) {
                mergedList.add(list1.get(i++));
            } else {
                mergedList.add(list2.get(j++));
            }

        }
        while (i < list1Size && mergedList.size() < limit) {
            mergedList.add(list1.get(i++));
        }
        while (j < list2Size && mergedList.size() < limit) {
            mergedList.add(list2.get(j++));
        }
        return mergedList;
    }
}
