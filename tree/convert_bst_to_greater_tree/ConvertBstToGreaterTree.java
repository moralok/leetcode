package tree.convert_bst_to_greater_tree;

public class ConvertBstToGreaterTree {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        // 反向中序遍历
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}