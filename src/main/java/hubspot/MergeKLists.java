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
