package depth_first_search.construct_binary_tree_from_preorder_and_inorder_traversal;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 递归
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, n-1, 0, n-1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preorderLeft, int preOrderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preOrderRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderLeft]);
        int rootIndex = indexMap.get(preorder[preorderLeft]);
        root.left = buildTree(preorder, inorder, preorderLeft + 1, preorderLeft + rootIndex - inorderLeft, inorderLeft, rootIndex - 1);
        root.right = buildTree(preorder, inorder, preorderLeft + rootIndex - inorderLeft + 1, preOrderRight, rootIndex + 1, inorderRight);
        return root;
    }
}