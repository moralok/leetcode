package daily;

import common.ListNode;

public class Lc0148Solution {
    public ListNode sortList(ListNode head) {
        // 计算长度
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int i = 1; i < len; i *= 2) {
            // 从头开始
            ListNode cur = dummy.next;
            // 标记末尾
            ListNode tail = dummy;
            while (cur != null) {
                // 切割
                ListNode left = cur;
                ListNode right = cut(cur, i);
                cur = cut(right, i);
                // 合并
                tail.next = merge(left, right);
                while (tail.next != null) {
                    tail = tail.next;
                }
            }
        }
        return dummy.next;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
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
        return dummy.next;
    }

    private ListNode cut(ListNode cur, int i) {
        ListNode p = cur;
        // 为了断开，少跳一个
        while (p != null && --i > 0) {
            p = p.next;
        }
        if (p == null) {
            return null;
        }
        ListNode next = p.next;
        // 断开
        p.next = null;
        return next;
    }
}
