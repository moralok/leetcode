package daily;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Lc0144Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // 递归
        List<Integer> res = new LinkedList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        preorder(node.left, res);
        preorder(node.right, res);
    }
}
