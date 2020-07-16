package tree.symmetric_tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree2 {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            if (p == null && q == null) {
                continue;
            }
            if ((p == null || q == null) || p.val != q.val){
                return false;
            }
            queue.add(p.left);
            queue.add(q.right);
            queue.add(p.right);
            queue.add(q.left);
        }
        return true;
    }
}