package daily;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Daily20240212Lc0145Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        dfs(node.left, list);
        dfs(node.right, list);
        list.add(node.val);
    }
}
