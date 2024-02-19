package daily;

import common.Node;

import java.util.*;

public class Daily20240219Lc0590Solution {

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.children != null && !root.children.isEmpty()) {
            for (Node child : root.children) {
                dfs(child, res);
            }
        }
        res.add(root.val);
    }

    public List<Integer> postorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> stack = new ArrayDeque<>();
        Map<Node, Integer> index = new HashMap<>();
        Node head = root;
        while (head != null || !stack.isEmpty()) {
            while (head != null) {
                stack.push(head);
                List<Node> children = head.children;
                if (children != null && children.size() > 0) {
                    index.put(head, 0);
                    head = children.get(0);
                } else {
                    head = null;
                }
            }
            head = stack.peek();
            Integer idx = index.getOrDefault(head, -1) + 1;
            List<Node> children = head.children;
            if (children != null && idx < children.size()) {
                index.put(head, idx);
                head = children.get(idx);
            } else {
                res.add(head.val);
                stack.pop();
                index.remove(head);
                head = null;
            }
        }
        return res;
    }
}
