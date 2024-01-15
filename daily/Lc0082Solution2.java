package daily;

import common.ListNode;
import common.Utils;

public class Lc0082Solution2 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1000);
        dummy.next = head;
        ListNode ptr = dummy;
        while (ptr.next != null && ptr.next.next != null) {
            if (ptr.next.val != ptr.next.next.val) {
                ptr = ptr.next;
            } else {
                int val = ptr.next.val;
                while (ptr.next != null && ptr.next.val == val) {
                    ptr.next = ptr.next.next;
                }
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Lc0082Solution2 solution = new Lc0082Solution2();
        ListNode head;

        head = Utils.buildListNode("[1,2,3,3,4,4,5]");
        assert "[1,2,5]".equals(Utils.buildStr(solution.deleteDuplicates(head)));

        head = Utils.buildListNode("[1,1,1,2,3]");
        assert "[2,3]".equals(Utils.buildStr(solution.deleteDuplicates(head)));
    }
}
