package daily;

import java.util.LinkedList;
import java.util.List;

public class Lc0144Solution4 {
    public List<Integer> preorderTraversal(TreeNode root) {
        // Morris，再次写又生疏了
        List<Integer> res = new LinkedList<>();
        TreeNode node = root, pre = null;
        while (node != null) {
            pre = node.left;
            if (pre == null) {
                res.add(node.val);
            } else {
                while (pre.right != null && pre.right != node) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    res.add(node.val);
                    pre.right = node;
                    node = node.left;
                    continue;
                } else {
                    pre.right = null;
                }
            }
            node = node.right;
        }
        return res;
    }
}
