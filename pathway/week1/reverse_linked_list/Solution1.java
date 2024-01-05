package pathway.week1.reverse_linked_list;

import common.ListNode;

public class Solution1 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = head;
        head = head.next;
        tmp.next = null;
        ListNode result = reverseList(head);
        head.next = tmp;
        return result;
    }
}
