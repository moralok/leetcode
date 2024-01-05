package top;

import common.ListNode;

public class Lc0002Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 因为是从低位开始的，马上想到的是顺序累加，记录是否进位
        // 一个链表抵达末尾时可以直接利用未结束的链表的剩余部分
        // 犯错1:短链最后的进位还可以引发不断地进位，自己的思路总是有遗漏呢
        // 果然使用新建链表的方式吗。。。
        int carry = 0, sum = 0;
        ListNode i = l1, j = l2;
        while (i.next != null && j.next != null) {
            sum = i.val + j.val + carry;
            i.val = sum % 10;
            carry = sum / 10;
            i = i.next;
            j = j.next;
        }
        // 处理短链的最后一个结点
        sum = i.val + j.val + carry;
        i.val = sum % 10;
        carry = sum / 10;
        if (i.next == null) {
            i.next = j.next;
        }
        // 此时如果仍有一个进位，且i.next != null，依次处理
        while (carry == 1 && i.next != null) {
            sum = i.next.val + 1;
            i.next.val = sum % 10;
            carry = sum / 10;
            i = i.next;
        }
        // 此时如果仍有一个进位，且i.next == null，新建结点
        if (carry == 1) {
            i.next = new ListNode(1);
        }
        return l1;
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
        Lc0002Solution solution = new Lc0002Solution();
        solution.addTwoNumbers(l1, l2);
        return;
    }
}
