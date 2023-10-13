package practice2023.binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

public class Lc0145SolutionIterate2 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode prev = null;
        while (!stack.empty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (node.right == null || prev == node.right) {
                    list.add(node.val);
                    // 每次添加后，哨兵就指向它
                    prev = node;
                    node = null;
                } else {
                    stack.push(node);
                    node = node.right;
                }
            }
        }
        return list;
    }
}
