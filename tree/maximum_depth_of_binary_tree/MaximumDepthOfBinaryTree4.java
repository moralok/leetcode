package tree.maximum_depth_of_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree4 {

    public int maxDepth(TreeNode root) {
        // 广度优先遍历，利用队列，记录层数
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            // 批量取某一层的节点，因为queue时刻在变，所以要暂存次数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        
    }
}