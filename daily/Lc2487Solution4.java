package daily;

public class Lc2487Solution4 {

    public ListNode removeNodes(ListNode head) {
        head = reverse(head);
        for (ListNode p = head; p.next != null; ) {
            if (p.val > p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return reverse(head);
    }

    private ListNode reverse(ListNode node) {
        ListNode dummy = new ListNode();
        while (node != null) {
            ListNode tmp = node.next;
            node.next = dummy.next;
            dummy.next = node;
            node = tmp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
