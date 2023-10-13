package practice2023.binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

public class Lc0144SolutionIterate {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }        
        return list;
    }
}
