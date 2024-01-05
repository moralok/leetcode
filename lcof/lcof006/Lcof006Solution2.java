package lcof.lcof006;

import common.ListNode;

public class Lcof006Solution2 {
    public int[] reversePrint(ListNode head) {
        // 两次遍历
        // O(n) O(n)
        ListNode node = head;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        int[] res = new int[len];
        node = head;
        while (node != null) {
            res[--len] = node.val;
            node = node.next;
        }
        return res;
    }
}