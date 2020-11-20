package daily;

public class Lc0147Solution {
    public ListNode insertionSortList(ListNode head) {
        // 感觉自己的链表操作思路老和别人不太一样啊
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        while (head != null) {
            ListNode tmpHead = head.next;
            ListNode p = dummy;
            while (p.next != null && p.next.val < head.val) {
                p = p.next;
            }
            head.next = p.next;
            p.next = head;
            head = tmpHead;
        }
        return dummy.next;
    }
}
