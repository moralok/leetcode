package practice2023.binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class Lc0145SolutionRecursion {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversal(root, list);
        return list;
    }

    private void postorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left, list);
        postorderTraversal(node.right, list);
        list.add(node.val);
    }
}
