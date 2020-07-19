package tree.average_of_levels_in_binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        // 广度优先遍历
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 0;
        TreeNode cur = null;
        while (!queue.isEmpty()){
            size = queue.size();
            double total = 0;
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                total += cur.val;
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            double tmp = total / size;
            list.add(tmp);
        }
        return list;
    }
}