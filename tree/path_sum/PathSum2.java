package tree.path_sum;

import java.util.LinkedList;
import java.util.Queue;

public class PathSum2 {
    public boolean hasPathSum(TreeNode root, int sum) {
        // 广度优先遍历
        if (root == null) {
            return false;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> countQueue = new LinkedList<>();
        nodeQueue.add(root);
        countQueue.add(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            Integer tmp = countQueue.poll();
            if (node.left == null && node.right == null) {
                // 注意false不能直接返回
                if (tmp == sum) {
                    return true;
                }
                continue;
            }
            if (node.left != null) {
                nodeQueue.add(node.left);
                countQueue.add(tmp + node.left.val);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
                countQueue.add(tmp + node.right.val);
            }
        }
        return false;
    }
}