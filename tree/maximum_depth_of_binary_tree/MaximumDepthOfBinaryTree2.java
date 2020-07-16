package tree.maximum_depth_of_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

public class MaximumDepthOfBinaryTree2 {

    public int maxDepth(TreeNode root) {
        // 广度优先遍历，利用队列，查询所有节点深度
        if (root == null) {
            return 0;
        }
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<TreeNode,Integer>(root, 1));
        int depth = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> cur = queue.poll();
            TreeNode node = cur.getKey();
            Integer curDepth = cur.getValue();
            depth = Math.max(depth, curDepth);
            // 也可以像题解把空节点推入队列，取出时判断
            // 为什么题解认为这是利用了栈呢？
            if (node.left != null) {
                queue.add(new Pair<TreeNode,Integer>(node.left, curDepth + 1));
            }
            if (node.right != null) {
                queue.add(new Pair<TreeNode,Integer>(node.right, curDepth + 1));
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        
    }
}