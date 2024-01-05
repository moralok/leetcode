package sort.sort_list;

import common.ListNode;

public class SortList2 {
    public ListNode sortList(ListNode head) {
        // 自底向上
        // 计算长度
        // 真滴强，感觉好理解多了
        int len = 0;
        for (ListNode i = head; i != null; i = i.next) {
            len++;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int i = 1; i < len; i *= 2) {
            // 第二段的索引值是 j+i
            // 获取头部
            ListNode cur = dummy.next;
            ListNode tail = dummy;
            while (cur != null) {
                // 左半部分头部
                ListNode left = cur;
                // 右半部分头部
                ListNode right = cut(cur, i);
                // 更新为新的头部
                cur = cut(right, i);
                tail.next = merge(left, right);
                // 保持尾部
                while (tail.next != null) {
                    tail = tail.next;
                }
            }
        }
        return dummy.next;
    }

    // merge(l1, l2)
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

    // cut(l, n)
    private ListNode cut(ListNode cur, int i) {
        ListNode p = cur;
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