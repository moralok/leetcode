package practice2023.reverse_linked_list;

import common.ListNode;

public class Lc0206SolutionRecursion {

    public ListNode reverseList(ListNode head) {
        // 这个递归有点绕
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
