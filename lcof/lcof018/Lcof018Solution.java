package lcof.lcof018;

import common.ListNode;

public class Lcof018Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
                break;
            } else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}