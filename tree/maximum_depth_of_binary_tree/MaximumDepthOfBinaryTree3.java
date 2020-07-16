package tree.maximum_depth_of_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

public class MaximumDepthOfBinaryTree3 {

    public int maxDepth(TreeNode root) {
        // 深度优先遍历，利用栈，获取叶子结点的深度
        if (root == null) {
            return 0;
        }
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        stack.add(new Pair<TreeNode,Integer>(root, 1));
        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> cur = stack.remove();
            TreeNode node = cur.getKey();
            Integer curDepth = cur.getValue();
            if (node.left == null && node.right == null) {
                depth = Math.max(depth, curDepth);
            } 
            if (node.left != null) {
                stack.add(new Pair<TreeNode,Integer>(node.left, curDepth + 1));
            }
            if (node.right != null) {
                stack.add(new Pair<TreeNode,Integer>(node.right, curDepth + 1));
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        
    }
}