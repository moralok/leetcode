package tree.invert_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree2 {
    
    public TreeNode invertTree(TreeNode root) {
        // 迭代
        // 不论遍历方式是什么，只要接触到节点，就可以翻转左右节点
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        
    }
}