package linked_list.remove_duplicates_from_sorted_list;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;
        ListNode cur = head;
        while (cur != null) {
            // 批量处理连续的重复项
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }
            pre.next = cur.next;
            pre = cur.next;
            cur = cur.next;
        }
        return head;
    }
}