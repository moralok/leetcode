package linked_list.reverse_linked_list;

import common.ListNode;

public class ReverseLinkedList2 {
    
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        // 要释放head.next
        head.next = null;
        return p;
    }
}