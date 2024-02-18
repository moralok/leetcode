package daily;

import common.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Daily20240218Lc0589Solution {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            res.add(pop.val);
            if (pop.children != null && !pop.children.isEmpty()) {
                int size = pop.children.size();
                for (int i = size - 1; i >= 0; i--) {
                    stack.push(pop.children.get(i));
                }
            }
        }
        return res;
    }
}
