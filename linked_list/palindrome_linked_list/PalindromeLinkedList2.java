package linked_list.palindrome_linked_list;

import common.ListNode;

public class PalindromeLinkedList2 {

    private ListNode front;

    public boolean isPalindrome(ListNode head) {
        // 递归
        // O(n) O(n)
        front = head;
        return checkIsPalindrome(head);
    }

    private boolean checkIsPalindrome(ListNode head) {
        // （犯错）head != null
        if (head != null) {
            if (!checkIsPalindrome(head.next)) {
                return false;
            }
            if (front.val != head.val) {
                return false;
            }
            front = front.next;
        }
        return true;
    }
}