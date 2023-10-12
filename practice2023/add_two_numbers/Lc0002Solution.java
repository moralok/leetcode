package practice2023.add_two_numbers;

import common.ListNode;

/**
 * 注意 null 的判断和最后可能的进位
 * 
 * 将链表转换为数字再相加，再转回来。抛开溢出问题，这个思路对于看到链表就思路“僵化”的我是新颖的。
 */
public class Lc0002Solution {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        int carry = 0, sum;
        while (l1 != null || l2 != null) {
            // 计算和
            sum = 0;
            if (l1 != null) {
                sum += l1.val;
                // 移动指针
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            // 更新进位并创建节点
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
        }
        // 注意最后可能进位
        if (carry == 1) {
            tail.next = new ListNode(1);
        }
        return dummy.next;
    }
}
