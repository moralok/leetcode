package leetbook.data_structure_binary_tree.lowest_common_ancestor_of_a_binary_tree;

import java.util.HashMap;
import java.util.Map;

public class LowestCommonAncestorOfABinaryTree2 {

    private Map<Integer, TreeNode> parentMap = new HashMap<>();

    private Map<Integer, Boolean> visitedMap = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 提交结果有点慢
        dfs(root, p, q);
        while (p != null) {
            visitedMap.put(p.val, true);
            p = parentMap.get(p.val);
        }
        while (q != null) {
            if (visitedMap.containsKey(q.val)) {
                return q;
            }
            q = parentMap.get(q.val);
        }
        return null;
    }

    private void dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node.left != null) {
            parentMap.put(node.left.val, node);
            dfs(node.left, p, q);
        }
        if (node.right != null) {
            parentMap.put(node.right.val, node);
            dfs(node.right, p, q);
        }
    }
}
