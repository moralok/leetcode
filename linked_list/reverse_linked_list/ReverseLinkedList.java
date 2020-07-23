package linked_list.reverse_linked_list;

public class ReverseLinkedList {
    
    public ListNode reverseList(ListNode head) {
        // 迭代
        ListNode newHead = null;
        ListNode tmp = null;
        while (head != null) {
            tmp = newHead;
            newHead = head;
            head = head.next;
            newHead.next = tmp;
        }
        return newHead;
    }
}