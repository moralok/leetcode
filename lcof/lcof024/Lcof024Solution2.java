package lcof.lcof024;

public class Lcof024Solution2 {
    public ListNode reverseList(ListNode head) {
        // 迭代
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = newHead;
            newHead = tmp;
        }
        return newHead;
    }
}