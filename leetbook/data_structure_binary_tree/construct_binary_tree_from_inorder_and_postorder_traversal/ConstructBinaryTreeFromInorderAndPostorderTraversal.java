package leetbook.data_structure_binary_tree.construct_binary_tree_from_inorder_and_postorder_traversal;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    /**
     * 索引映射表
     */
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int lenIn = inorder.length;
        int lenPost = postorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(inorder, 0, lenIn - 1, postorder, 0, lenPost - 1);
    }

    private TreeNode buildTree(int[] inorder, int beginIn, int endIn, int[] postorder, int beginPost, int endPost) {
        if (beginPost > endPost) {
            return null;
        }
        // 确定 root 和 root 在 inorder 中的索引
        TreeNode root = new TreeNode(postorder[endPost]);
        int index = indexMap.get(root.val);
        // 确定递归中中序和后序序列中对应的索引范围
        root.left = buildTree(inorder, beginIn, index - 1, postorder, beginPost, beginPost + index - beginIn - 1);
        root.right = buildTree(inorder, index + 1, endIn, postorder, beginPost + index - beginIn, endPost - 1);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        int[] inorder = new int[] {9,3,15,20,7};
        int[] postorder = new int[] {9,15,7,20,3};
        solution.buildTree(inorder, postorder);
        return;
    }
}