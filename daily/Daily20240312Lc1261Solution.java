package daily;

import common.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Daily20240312Lc1261Solution {

    static class FindElements {

        private final Set<Integer> set;

        public FindElements(TreeNode root) {
            this.set = new HashSet<>();
            dfs(root, 0);
        }

        private void dfs(TreeNode node, int val) {
            if (node == null) {
                return;
            }
            node.val = val;
            set.add(val);
            dfs(node.left, 2 * val + 1);
            dfs(node.right, 2 * val + 2);
        }

        public boolean find(int target) {
            return set.contains(target);
        }
    }
}
