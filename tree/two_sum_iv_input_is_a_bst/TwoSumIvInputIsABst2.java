package tree.two_sum_iv_input_is_a_bst;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSumIvInputIsABst2 {

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        int i = 0, j = list.size() - 1;
        while (i < j) {
            if ((list.get(i) + list.get(j)) == k) {
                return true;
            } else if ((list.get(i) + list.get(j)) > k) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}