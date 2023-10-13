package practice2023.binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import common.TreeNode;

/**
 * 本方法挺慢的
 * 也可以通过前序遍历“中右左”的逆序获得
 * 用一个哨兵就行，太久没写就想不起来了
 */
public class Lc0145SolutionIterate {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Boolean> poped = new HashMap<>();
        TreeNode node = root;
        while (!stack.empty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                // 容易出错
                node = stack.pop();
                if (!poped.containsKey(node)) {
                    poped.put(node, true);
                    stack.push(node);
                    node = node.right;
                } else {
                    list.add(node.val);
                    node = null;
                }
            }
        }
        return list;
    }
}
