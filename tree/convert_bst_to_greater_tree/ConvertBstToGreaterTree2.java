package tree.convert_bst_to_greater_tree;

import java.util.LinkedList;

public class ConvertBstToGreaterTree2 {

    public TreeNode convertBST(TreeNode root) {
        // 迭代、栈
        int sum = 0;
        TreeNode node = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || node != null) {
            // 先右子树
            while (node != null) {
                stack.push(node);
                node = node.right;
            }
            // 处理子树根结点
            node = stack.pop();
            sum += node.val;
            node.val = sum;
            // 处理左子树
            node = node.left;
        }
        return root;
    }
}