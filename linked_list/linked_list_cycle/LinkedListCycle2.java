package linked_list.linked_list_cycle;

public class LinkedListCycle2 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        // 双指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}