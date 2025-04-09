package org.D0824;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        else if(l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(l1 != null && l2!= null){
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null? l2:l1;
        return dummy.next;
    }

    public ListNode mergeTwoListsPan(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null)
            return listNode2;
        if (listNode2 == null)
            return listNode1;
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode head = prehead;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val <= listNode2.val) {
                head.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                head.next = listNode2;
                listNode2 = listNode2.next;
            }
            head = head.next;
        }

        // At least one of l1 and l2 can still have nodes at this point, so connect
        // the non-null list to the end of the merged list.
        head.next = listNode1 == null ? listNode2 : listNode1;

        return prehead.next;
    }

}
