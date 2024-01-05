package sort.sort_list;

import common.ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {
        // 空间复杂度不符合要求
        // 自顶向下
        if (head == null || head.next == null) {
            // 不是返回 null
            return head;
        }
        // 快慢指针法找中间点
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode cur = new ListNode(0);
        ListNode res = cur;
        // 有序链表合并
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left == null ? right : left;
        return res.next;
    }
}