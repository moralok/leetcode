package linked_list.merge_two_sorted_lists;

import common.ListNode;

public class MergeTwoSortedLists2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);;
        ListNode next = head;
        
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                next.next = l2;
                break;
            }
            if (l2 == null) {
                next.next = l1;
                break;
            }
            if (l1.val <= l2.val) {
                next.next = l1;
                l1 = l1.next;
            } else {
                next.next = l2;
                l2 = l2.next;
            }
            next = next.next;
        }
        return head.next;
    }
}