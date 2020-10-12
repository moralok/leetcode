package leetbook.data_structure_binary_tree.construct_binary_tree_from_inorder_and_postorder_traversal;

import java.util.Deque;
import java.util.LinkedList;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal2 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return null;
        }
        int inorderIndex = inorder.length - 1;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        for (int i = postorder.length - 2; i >= 0; i--) {
            int postOrderVal = postorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.right = new TreeNode(postOrderVal);
                stack.push(node.right);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(postOrderVal);
                stack.push(node.left);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal2 solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal2();
        int[] inorder = new int[] {9,3,15,20,7};
        int[] postorder = new int[] {9,15,7,20,3};
        solution.buildTree(inorder, postorder);
        return;
    }
}