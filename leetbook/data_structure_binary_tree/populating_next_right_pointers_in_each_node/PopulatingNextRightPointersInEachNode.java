package leetbook.data_structure_binary_tree.populating_next_right_pointers_in_each_node;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {

    public Node connect(Node root) {
        // 层序遍历，空间复杂度O(n)，不符合题目要求
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}
