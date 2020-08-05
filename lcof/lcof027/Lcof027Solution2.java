package lcof.lcof027;

import java.util.LinkedList;

public class Lcof027Solution2 {
    public TreeNode mirrorTree(TreeNode root) {
        // 迭代
        if (root == null) {
            return root;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }
}