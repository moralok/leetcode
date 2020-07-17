package tree.find_mode_in_binary_search_tree;

import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree2 {
    
    public int[] findMode(TreeNode root) {
        // Morris
        int curCount = 0;
        int maxCount = 0;
        List<Integer> list = new ArrayList<>();
        TreeNode pre = null;
        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                if (pre == null || pre.val != node.val) {
                    curCount = 1;
                } else {
                    curCount++;
                }
                if (curCount > maxCount) {
                    maxCount = curCount;
                    list.clear();
                    list.add(node.val);
                } else if (curCount == maxCount) {
                    list.add(node.val);
                }
                // 更新pre（犯错1）
                pre = node;
                node = node.right;
            } else {
                TreeNode preceding = getPreceding(node);
                // （犯错2）
                if (preceding.right == null) {
                    // 第一次到达，指针标记
                    preceding.right = node;
                    node = node.left;
                } else {
                    // 第二次到达，删除指针
                    preceding.right = null;
                    // 做着和左子树为空时相同的事情
                    if (pre == null || pre.val != node.val) {
                        curCount = 1;
                    } else {
                        curCount++;
                    }
                    if (curCount > maxCount) {
                        maxCount = curCount;
                        list.clear();
                        list.add(node.val);
                    } else if (curCount == maxCount) {
                        list.add(node.val);
                    }
                    // 更新pre
                    pre = node;
                    node = node.right;
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private TreeNode getPreceding(TreeNode node) {
        // 获取前驱
        TreeNode preceding = node.left;
        // （犯错3）前驱的右节点判断
        while (preceding.right != null && preceding.right != node) {
            preceding = preceding.right;
        }
        return preceding;
    }
}