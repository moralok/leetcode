package lcof.lcof034;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lcof034Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum);
        return res;
    }

    private void helper(TreeNode node, int target) {
        if (node == null) {
            return;
        }
        target -= node.val;
        path.add(node.val);
        // 没关注到必须是叶子结点啊
        if (target == 0 && node.left == null && node.right == null) {
            res.add(new LinkedList<>(path));
        }
        helper(node.left, target);
        helper(node.right, target);
        path.removeLast();
    }
}