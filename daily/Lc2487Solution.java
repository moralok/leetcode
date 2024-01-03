package daily;

public class Lc2487Solution {

    public ListNode removeNodes(ListNode head) {
        ListNode newHead = head, tail = head;
        while (tail.next != null) {
            if (tail.val < tail.next.val) {
                if (newHead.val < tail.next.val) {
                    newHead = tail.next;
                } else {
                    ListNode tmp = newHead;
                    while (tmp.next != null && tmp.next.val >= tail.next.val) {
                        tmp = tmp.next;
                    }
                    tmp.next = tail.next;
                }
            }
            tail = tail.next;
        }
        return newHead;
    }

    public static void main(String[] args) {

    }
}
