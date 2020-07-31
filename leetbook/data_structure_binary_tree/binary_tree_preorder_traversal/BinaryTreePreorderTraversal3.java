package leetbook.data_structure_binary_tree.binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal3 {
    public List<Integer> preorderTraversal(TreeNode root) {
        // 莫里斯遍历
        List<Integer> ret = new ArrayList<Integer>();
        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                // 查看左子节点，无则直接进入右子树
                ret.add(node.val);
                node = node.right;
            } else {
                // 查找前驱节点
                TreeNode predecessor = node.left;
                while (predecessor.right != null && predecessor.right != node) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    // 第一次到达
                    ret.add(node.val);
                    predecessor.right = node;
                    node = node.left;
                } else {
                    // 第二次到达
                    predecessor.right = null;
                    node = node.right;
                }
            }
        }
        return ret;
    }
}