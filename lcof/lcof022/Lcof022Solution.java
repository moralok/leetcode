package lcof.lcof022;

public class Lcof022Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = new ListNode(0);
        fast.next = head;
        ListNode slow = fast;
        while (k-- > 0) {
            fast = fast.next;
            if (fast == null) {
                return null;
            }
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}