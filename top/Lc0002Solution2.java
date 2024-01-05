package top;

import common.ListNode;

public class Lc0002Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 参照答案使用新建链表的方式
        int carry = 0, sum = 0, n1, n2;
        ListNode i = l1, j = l2, head = null, tail = null;
        while (i != null || j != null) {
            n1 = i == null ? 0 : i.val;
            n2 = j == null ? 0 : j.val;
            sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (i != null) {
                i = i.next;
            }
            if (j != null) {
                j = j.next;
            }
        }
        if (carry == 1) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode tmp = l1;
        for (int i = 0; i < 6; i++) {
            tmp.next = new ListNode(9);
            tmp = tmp.next;
        }
        ListNode l2 = new ListNode(9);
        tmp = l2;
        for (int i = 0; i < 3; i++) {
            tmp.next = new ListNode(9);
            tmp = tmp.next;
        }
        Lc0002Solution2 solution = new Lc0002Solution2();
        ListNode head = solution.addTwoNumbers(l1, l2);
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        return;
    }
}
