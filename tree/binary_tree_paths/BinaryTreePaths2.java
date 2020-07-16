package tree.binary_tree_paths;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths2 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        LinkedList<TreeNode> nodeStack = new LinkedList<>();
        LinkedList<String> pathStack = new LinkedList<>();
        nodeStack.add(root);
        pathStack.add(Integer.toString(root.val));
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pollLast();
            String path = pathStack.pollLast();
            if (node.left == null && node.right == null) {
                paths.add(path);
            }
            if (node.left != null) {
                nodeStack.add(node.left);
                pathStack.add(path + "->" + Integer.toString(node.left.val));
            }
            if (node.right != null) {
                nodeStack.add(node.right);
                pathStack.add(path + "->" + Integer.toString(node.right.val));
            }
        }
        return paths;
    }
}