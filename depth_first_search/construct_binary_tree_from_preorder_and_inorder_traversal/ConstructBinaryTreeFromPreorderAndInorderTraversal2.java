package depth_first_search.construct_binary_tree_from_preorder_and_inorder_traversal;

import java.util.LinkedList;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal2 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 迭代
        // 感觉很不熟练
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}