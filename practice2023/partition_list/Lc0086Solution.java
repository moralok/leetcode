package practice2023.partition_list;

import common.ListNode;

/**
 * 官方题解中，改用双哑节点，最后连接起来的方式更加清晰
 */
public class Lc0086Solution {
    
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        ListNode p1 = dummy, p2 = p1;
        while (head != null) {
            // 保存 head 后继节点
            ListNode next = head.next;
            if (head.val < x) {
                head.next = p1.next;
                p1.next = head;
                if (p2 == p1) {
                    p2 = p2.next;
                }
                p1 = p1.next;
            } else {
                head.next = null;
                p2.next = head;
                p2 = p2.next;
            }
            // 循环终止
            head = next;
        }
        return dummy.next;
    }
}
