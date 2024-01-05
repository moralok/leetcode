package daily;

import common.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc2487Solution3 {

    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            if (head == null || stack.peek().val >= head.val) {
                stack.peek().next = head;
                head = stack.peek();
            }
            stack.pop();
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
