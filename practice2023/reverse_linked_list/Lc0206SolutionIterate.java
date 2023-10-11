package practice2023.reverse_linked_list;

import common.ListNode;

public class Lc0206SolutionIterate {
    
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
