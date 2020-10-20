package daily;

import java.util.LinkedList;

public class Lc0143Solution {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode tail = head;
        while (tail != null) {
            stack.push(tail);
            tail = tail.next;
        }
        tail = new ListNode(0);
        ListNode p = head, q = stack.pop();
        while (p.next != null && tail != null) {
            tail.next = p;
            p = p.next;
            tail.next.next = q;
            // 虽然有点懵，但好像意外可以涵盖两种情况（单数结点时，有点特别）
            // 不知道如何想出来，但有些结点的操作在最后总能符合，好神奇
            // 就是跳出循环的判断有点不优雅
            // 也没有坚定地走翻转合并的思路（主要是一时想到了递归翻转，觉得没意思，想想用栈还不如答案的顺序表，我好蠢）
            q.next = null;
            tail = tail.next.next;
            q = stack.pop();
        }
    }
}
