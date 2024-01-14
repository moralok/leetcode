package daily;

import common.ListNode;
import common.Utils;

public class Lc0083Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Lc0083Solution solution = new Lc0083Solution();
        ListNode head;

        head = Utils.buildListNode("[1,1,2]");
        assert "[1,2]".equals(Utils.buildStr(solution.deleteDuplicates(head)));

        head = Utils.buildListNode("[1,1,2,3,3]");
        assert "[1,2,3]".equals(Utils.buildStr(solution.deleteDuplicates(head)));
    }
}
