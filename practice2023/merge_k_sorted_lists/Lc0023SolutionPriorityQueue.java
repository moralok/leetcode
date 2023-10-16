package practice2023.merge_k_sorted_lists;

import java.util.PriorityQueue;

import common.ListNode;

public class Lc0023SolutionPriorityQueue {
    
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.offer(lists[i]);
            }
        }
        ListNode dummy = new ListNode(), tail = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            tail.next = node;
            tail = tail.next;
            node = node.next;
            if (node != null) {
                queue.offer(node);
            }
        }
        return dummy.next;
    }
}
