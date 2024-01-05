package pathway.week1.reverse_linked_list;

import common.ListNode;

public class Solution2 {

    public ListNode reverseList(ListNode head) {
        ListNode dummyNode = new ListNode();
        while (head != null) {
            ListNode tmp = head.next;
            head.next = dummyNode.next;
            dummyNode.next = head;
            head = tmp;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode dummyNode = new ListNode();
        for (int i = 5; i > 0; i--) {
            ListNode node = new ListNode(i);
            node.next = dummyNode.next;
            dummyNode.next = node;
        }
        ListNode head = dummyNode.next;
        Solution2 solution2 = new Solution2();
        ListNode result = solution2.reverseList(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
