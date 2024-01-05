package linked_list.remove_linked_list_elements;

import common.ListNode;

public class RemoveLinkedListElements2 {
    public ListNode removeElements(ListNode head, int val) {
        // 题解妙啊
        ListNode sentinel = new ListNode(0, head);
        ListNode pre = sentinel;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                // 如果开头就删除，也处理了
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return sentinel.next;
    }
}