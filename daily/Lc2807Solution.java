package daily;

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

}
