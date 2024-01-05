package lcof.lcof024;

import common.ListNode;

public class Lcof024Solution {
    public ListNode reverseList(ListNode head) {
        // 递归
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}