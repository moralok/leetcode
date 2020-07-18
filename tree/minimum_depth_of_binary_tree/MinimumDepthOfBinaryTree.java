package tree.minimum_depth_of_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        // 层序遍历，不用遍历所有结点
        if (root == null) {
            return 0;
        }
        Queue<Pair<TreeNode, Integer>> queque = new LinkedList<>();
        int depth = 1;
        queque.add(new Pair<TreeNode, Integer>(root, depth));
        while (!queque.isEmpty()) {
            Pair<TreeNode, Integer> pair = queque.poll();
            TreeNode node = pair.getKey();
            depth = pair.getValue();
            if (node.left == null && node.right == null) {
                break;
            }
            if (node.left != null) {
                queque.add(new Pair<TreeNode,Integer>(node.left, depth + 1));
            }
            if (node.right != null) {
                queque.add(new Pair<TreeNode,Integer>(node.right, depth + 1));
            }
        }
        return depth;
    }
}