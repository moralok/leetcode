package leetbook.data_structure_binary_tree.binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal3 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                ret.add(node.val);
                node = node.right;
            } else {
                TreeNode predecessor = node.left;
                // 因为左指针会被释放，因此不用担心第二次回来时会有前继节点
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = node;
                // 这个释放左指针很妙啊
                TreeNode tmp = node;
                node = node.left;
                tmp.left = null;
            }
        }
        return ret;
    }
}