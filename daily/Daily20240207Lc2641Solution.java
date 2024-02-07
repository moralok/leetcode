package daily;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Daily20240207Lc2641Solution {

    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        root.val = 0;

        while (!queue.isEmpty()) {
            Queue<TreeNode> tmp = new ArrayDeque<>();
            int sum = 0;
            for (TreeNode node : queue) {
                if (node.left != null) {
                    tmp.offer(node.left);
                    sum += node.left.val;
                }
                if (node.right != null) {
                    tmp.offer(node.right);
                    sum += node.right.val;
                }
            }
            for (TreeNode node : queue) {
                int total = (node.left != null ? node.left.val : 0) + (node.right != null ? node.right.val : 0);
                if (node.left != null) {
                    node.left.val = sum - total;
                }
                if (node.right != null) {
                    node.right.val = sum - total;
                }
            }
            queue = tmp;
        }
        return root;
    }
}
