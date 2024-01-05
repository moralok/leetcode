package linked_list.palindrome_linked_list;

import common.ListNode;

public class PalindromeLinkedList3 {
    public boolean isPalindrome(ListNode head) {
        // 翻转一半链表
        // O(n) O(1)
        if (head == null) {
            // 没注意的特殊用例
            return true;
        }
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode SecondHalfStart = reverseList(firstHalfEnd.next);
        // 使用新的节点
        ListNode p1 = head;
        ListNode p2 = SecondHalfStart;
        boolean res = checkIsPalindrome(p1, p2);
        firstHalfEnd.next = reverseList(SecondHalfStart);
        return res;
    }

    private boolean checkIsPalindrome(ListNode p1, ListNode p2) {
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    private ListNode endOfFirstHalf(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}