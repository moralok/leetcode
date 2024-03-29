package daily;

import common.Node;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Daily20240217Lc0429Solution {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);
                if (node.children != null && !node.children.isEmpty()) {
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }
}
