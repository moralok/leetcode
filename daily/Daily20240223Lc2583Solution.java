package daily;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Daily20240223Lc2583Solution {

    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> heap = new PriorityQueue<Long>(Comparator.reverseOrder());
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            heap.offer(sum);
        }
        if (k > heap.size()) {
            return -1;
        }
        for (int i = 0; i < k - 1; i++) {
            heap.poll();
        }
        return heap.poll();
    }
}
