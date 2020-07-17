package tree.same_tree;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 队列、迭代
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            queue.add(t1.left);
            queue.add(t2.left);
            queue.add(t1.right);
            queue.add(t2.right);
        }
        return true;
    }
}