package tree.average_of_levels_in_binary_tree;

import java.util.ArrayList;
import java.util.List;

public class AverageOfLevelsInBinaryTree2 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> sum = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        average(root, 0, sum, count);
        for (int i = 0; i < sum.size(); i++) {
            sum.set(i, sum.get(i) / count.get(i));
        }
        return sum;
    }

    private void average(TreeNode node, int i, List<Double> sum, List<Integer> count) {
        if (node == null) {
            return;
        }
        if (i < sum.size()) {
            sum.set(i, sum.get(i) + node.val);
            count.set(i, count.get(i) + 1);
        } else {
            sum.add((double)node.val);
            count.add(1);
        }
        average(node.left, i + 1, sum, count);
        average(node.right, i + 1, sum, count);
    }
}