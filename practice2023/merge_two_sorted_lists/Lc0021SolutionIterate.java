package practice2023.merge_two_sorted_lists;

import common.ListNode;

public class Lc0021SolutionIterate {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(), last = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                last.next = list1;
                list1 = list1.next;
            } else {
                last.next = list2;
                list2 = list2.next;
            }
            last = last.next;
        }
        last.next = list1 == null ? list2 : list1;
        return dummy.next;
    }
}
