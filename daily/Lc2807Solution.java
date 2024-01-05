package daily;

import common.ListNode;
import common.Utils;

import java.util.Objects;

public class Lc2807Solution {

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode tmp = head;
        while (tmp.next != null) {
            int a = tmp.val, b = tmp.next.val;
            int gcd = gcd(a, b);
            ListNode node = new ListNode(gcd);
            node.next = tmp.next;
            tmp.next = node;

            tmp = node.next;
        }
        return head;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        Lc2807Solution solution = new Lc2807Solution();

        ListNode head = Utils.buildListNode("[18,6,10,3]");
        ListNode newHead = solution.insertGreatestCommonDivisors(head);
        assert Objects.equals(Utils.buildStr(newHead), "[18,6,6,2,10,1,3]");

        head = Utils.buildListNode("[7]");
        newHead = solution.insertGreatestCommonDivisors(head);
        assert Objects.equals(Utils.buildStr(newHead), "[7]");
    }
}
