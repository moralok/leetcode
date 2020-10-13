package leetbook.data_structure_binary_tree.populating_next_right_pointers_in_each_node_ii;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeIi2 {

    public Node connect(Node root) {
        // 层序遍历，不合题意
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node last = null;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i != 0) {
                    last.next = node;
                }
                last = node;
            }
        }
        return root;
    }
}
