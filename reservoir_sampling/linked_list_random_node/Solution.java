package reservoir_sampling.linked_list_random_node;

import common.ListNode;

import java.util.Random;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    private ListNode head;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int count = 0;
        int reserve = 0;
        ListNode cur = this.head;
        Random random = new Random();
        while (cur != null) {
            count++;
            int rand = random.nextInt(count) + 1;
            if (rand == count) {
                reserve = cur.val;
            }
            cur = cur.next;
        }
        return reserve;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Solution solution = new Solution(head);
        for (int i = 0; i < 10; i++) {
            System.out.println(solution.getRandom());
        }
    }
}

