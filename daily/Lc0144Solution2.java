package daily;

import java.util.LinkedList;
import java.util.List;

public class Lc0144Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        // 迭代
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }
}
