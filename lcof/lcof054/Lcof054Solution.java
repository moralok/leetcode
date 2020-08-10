package lcof.lcof054;

import java.util.ArrayList;
import java.util.List;

public class Lcof054Solution {

    public int kthLargest(TreeNode root, int k) {
        // 完整递归，空间占有 O(n) 
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list.get(list.size() - k);
    }

    private void helper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        helper(node.left, list);
        list.add(node.val);
        helper(node.right, list);
    }
}