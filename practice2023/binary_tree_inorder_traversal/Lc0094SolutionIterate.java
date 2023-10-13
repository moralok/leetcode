package practice2023.binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

public class Lc0094SolutionIterate {
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.empty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else  {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }
}
