package daily;

import common.ListNode;

public class Lc0143Solution2 {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = midNode(head);
        ListNode l1 = head;
        ListNode l2 = reverseList(mid.next);
        mid.next = null;
        merge(l1, l2);
    }

    private void merge(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode tmp1 = l1.next;
            ListNode tmp2 = l2.next;
            l1.next = l2;
            l1 = tmp1;
            // 喵
            l2.next = l1;
            l2 = tmp2;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode tmp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = tmp;
        }
        return dummy.next;
    }

    private ListNode midNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
