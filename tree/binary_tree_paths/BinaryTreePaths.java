package tree.binary_tree_paths;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    private List<String> paths = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return paths;
        }
        StringBuilder sb = new StringBuilder();
        constructPaths(root, sb);
        return paths;
    }

    private void constructPaths(TreeNode root, StringBuilder sb) {
        if (root.left == null && root.right == null) {
            paths.add(new StringBuilder(sb).append(Integer.toString(root.val)).toString());
        } else {
            if (root.left != null) {
                // 注意递归中的路径对象不能共享
                constructPaths(root.left, new StringBuilder(sb).append(Integer.toString(root.val)).append("->"));
            }
            if (root.right != null) {
                constructPaths(root.right, new StringBuilder(sb).append(Integer.toString(root.val)).append("->"));
            }
        }
    }
}