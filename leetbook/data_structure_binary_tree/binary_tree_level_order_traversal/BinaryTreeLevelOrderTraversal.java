package leetbook.data_structure_binary_tree.binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        TreeNode node = root;
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmpList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                tmpList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ret.add(tmpList);
        }
        return ret;
    }
}