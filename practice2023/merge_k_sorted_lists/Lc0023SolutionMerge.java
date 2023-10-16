package practice2023.merge_k_sorted_lists;

import common.ListNode;

public class Lc0023SolutionMerge {

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode l = mergeKLists(lists, left, mid);
        ListNode r = mergeKLists(lists, mid + 1, right);
        return merge(l, r);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(), tail = dummy;
        while (l != null && r != null) {
            if (l.val <= r.val) {
                tail.next = l;
                tail = tail.next;
                l = l.next;
            } else {
                tail.next = r;
                tail = tail.next;
                r = r.next;
            }
        }
        tail.next = l == null ? r : l;
        return dummy.next;
    }
}
