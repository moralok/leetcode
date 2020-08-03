package lcof.lcof007;

import java.util.LinkedList;

public class Lcof007Solution2 {
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        // 迭代的思路很重要啊，第二次遇到熟悉了很多
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        int idx = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[idx]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                // 用来比较的是stack.peek，不是 node！！！太傻了我
                while (!stack.isEmpty() && stack.peek().val == inorder[idx]) {
                    node = stack.pop();
                    idx++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}