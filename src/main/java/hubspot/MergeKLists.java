package hubspot;

import org.D0824.ListNode;

import java.util.ArrayList;
import java.util.List;

import static org.D0824.ListNode.printList;

/*
Time complexity : O(N logk) where k is the number of linked lists.

We can merge two sorted linked list in O(n) time where n is the total number of nodes in two lists.
Sum up the merge process and we can get: O(∑ i=1 log2^k N) = O(Nlogk)
Space complexity : O(1)

We can merge two sorted linked lists in O(1) space.
*/
public class MergeKLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        int amount = lists.length;
        int interval = 1;
        while (interval < amount) {
            for (int i = 0; i < amount - interval; i += interval * 2) {
                lists[i] = merge2Lists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return amount > 0 ? lists[0] : null;
    }

    public static ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode point = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                point.next = l1;
                l1 = l1.next;
            } else {
                point.next = l2;
                l2 = l1;
                l1 = point.next.next;
            }
            point = point.next;
        }
        if (l1 == null) {
            point.next = l2;
        } else {
            point.next = l1;
        }
        return head.next;
    }

    public static void main(String[] args) {
        // Creating the lists of ListNode
        ListNode[] lists = new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        };
        // Printing the lists to verify
        for (ListNode node : lists) {
            printList(node);
        }
        // Storing them in a list
        ListNode mergeKListsNode = mergeKLists(lists);
        printList(mergeKListsNode);

        // Creating the lists of ListNode
        lists = new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        };
        // Printing the lists to verify
        for (ListNode node : lists) {
            printList(node);
        }
        mergeKListsNode = mergeKLists(lists,3);
        printList(mergeKListsNode);

        lists = new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6)),
                new ListNode(1, new ListNode(7))
        };
        // Printing the lists to verify
        for (ListNode node : lists) {
            printList(node);
        }
        // Storing them in a list
        mergeKListsNode = mergeKLists(lists);
        printList(mergeKListsNode);

        lists = new ListNode[]{
                new ListNode(8, new ListNode(4, new ListNode(5))),
                new ListNode(9, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6)),
                new ListNode(1, new ListNode(7))
        };
        // Printing the lists to verify
        for (ListNode node : lists) {
            printList(node);
        }
        // Storing them in a list
        mergeKListsNode = mergeKLists(lists,1);
        printList(mergeKListsNode);

    }
    /*
    Time Complexity Analysis
The function uses a bottom-up merge sort approach but stops merging once we collect m elements.

Step 1: Merging pairs of lists (merge2Lists)
We merge k lists in a pairwise fashion.

In each merge step, interval doubles (1 → 2 → 4 → ...).

This results in log k levels of merging.

Step 2: Processing only m elements
The key difference from the standard merge algorithm is that we only process the first m elements.

Normally, merging two lists of length N takes O(N) time.

However, since we stop merging after m elements, each merge2Lists call only processes at most m elements.

Total Time Complexity
Each level of merging runs O(m), and there are log k levels.

Total complexity: O(m log k)
In the worst case where m = N (the total number of elements in all lists), it falls back to: O(N log k)
which is the standard merge complexity.

Space Complexity Analysis
Heap/Extra Storage
The algorithm uses only a few extra pointers (no additional data structures like heaps or arrays).

The only extra space is for the dummy head node and tracking pointers.

Linked List Storage
The output list consists of exactly m nodes.

Since the nodes are from the original lists (linked by references), no extra space is used.

Total Space Complexity O(1)
(excluding the output list, which is necessary for the result).

Final Complexity Summary
Complexity	Worst Case
Time Complexity	O(m log k)
Space Complexity	O(1) (excluding the output list)

Key Observations
Efficient Early Stopping: Unlike a full merge that processes all nodes, this approach stops once we reach m elements, improving efficiency.

No Additional Space: The algorithm does not use extra memory (like heaps), making it space-efficient.

Scalability: If m is much smaller than the total number of elements (N), this method avoids unnecessary processing.
Conclusion: This is an optimized approach when we only need m elements instead of fully merging all k lists!

*/


    public static ListNode mergeKLists(ListNode[] lists, int m) {
        int amount = lists.length;
        int interval = 1;
        while (interval < amount) {
            for (int i = 0; i < amount - interval; i += interval * 2) {
                lists[i] = merge2Lists(lists[i], lists[i + interval], m);
            }
            interval *= 2;
        }
        return amount > 0 ? lists[0] : null;
    }

    public static ListNode merge2Lists(ListNode l1, ListNode l2, int m) {
        ListNode head = new ListNode(0); // Dummy node
        ListNode point = head;
        int count = 0;

        while (l1 != null && l2 != null && count < m) {
            if (l1.val <= l2.val) {
                point.next = l1;
                l1 = l1.next;
            } else {
                point.next = l2;
                l2 = l2.next;
            }
            point = point.next;
            count++;
        }
        // If we haven't reached m elements yet, append the remaining elements.
        while (l1 != null && count < m) {
            point.next = l1;
            l1 = l1.next;
            point = point.next;
            count++;
        }

        while (l2 != null && count < m) {
            point.next = l2;
            l2 = l2.next;
            point = point.next;
            count++;
        }
        // Cut off any remaining elements beyond m
        point.next = null;
        return head.next;
    }
}
