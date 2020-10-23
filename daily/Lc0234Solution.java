package daily;

public class Lc0234Solution {
    public boolean isPalindrome(ListNode head) {
        // 感觉对O(1)翻转链表还不够敏锐，不小心瞄到之前写得答案的一丢丢就被动想起来了。。。
        // 虽然不满足O(1)，可以用数组、可以用递归，递归返回后比较首尾的值，很巧妙
        if (head == null) {
            return true;
        }
        ListNode mid = findMid(head);
        ListNode newHead = reverseList(mid.next);
        while (newHead != null) {
            if (newHead.val != head.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }

    private ListNode findMid(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode tmp;
        while (head != null) {
            tmp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = tmp;
        }
        return dummy.next;
    }
}
