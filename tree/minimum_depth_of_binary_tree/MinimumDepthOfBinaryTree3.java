package tree.minimum_depth_of_binary_tree;

import java.util.LinkedList;

import javafx.util.Pair;

public class MinimumDepthOfBinaryTree3 {
    public int minDepth(TreeNode root) {
        // 深度优先遍历，迭代
        if (root == null) {
            return 0;
        }
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        stack.push(new Pair<TreeNode,Integer>(root, 1));
        int minDepth = Integer.MAX_VALUE;
        TreeNode curNode;
        Integer curDepth;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            curNode = pair.getKey();
            curDepth = pair.getValue();
            if (curNode.left == null && curNode.right == null) {
                minDepth = Math.min(minDepth, curDepth);
            }
            if (curNode.left != null) {
                stack.push(new Pair<TreeNode,Integer>(curNode.left, curDepth + 1));
            }
            if (curNode.right != null) {
                stack.push(new Pair<TreeNode,Integer>(curNode.right, curDepth + 1));
            }
        }
        return minDepth;
    }
}