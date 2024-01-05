package linked_list.remove_linked_list_elements;

import common.ListNode;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        // 果然题解才不会像我这么粗暴
        // 对哨兵的理解还有待提高
        ListNode pre = new ListNode(0);
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode res = head;
        pre.next = head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val != val) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return res;
    }
}