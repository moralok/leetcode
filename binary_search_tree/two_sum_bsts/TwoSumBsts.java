package binary_search_tree.two_sum_bsts;

import java.util.ArrayList;
import java.util.List;

public class TwoSumBsts {

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inOrder(root1, list1);
        inOrder(root2, list2);
        int i = 0, j = list2.size() - 1;
        while (i < list1.size() && j >= 0) {
            int sum = list1.get(i) + list2.get(j);
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
}