package daily;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Lc0144Solution3 {
    public List<Integer> preorderTraversal(TreeNode root) {
        // 迭代，只存入右结点
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode node = null;
        while (!stack.isEmpty() || node != null) {
            if (node == null) {
                node = stack.pop();
            }
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            node = node.left;
        }
        return res;
    }
}
