package binary_search_tree.balance_a_binary_search_tree;

import java.util.ArrayList;
import java.util.List;

public class BalanceABinarySearchTree {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return build(list, 0, list.size() - 1);
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    private TreeNode build(List<Integer> list, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = (lo + hi) >> 1;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = build(list, lo, mid - 1);
        node.right = build(list, mid + 1, hi);
        return node;
    }
}