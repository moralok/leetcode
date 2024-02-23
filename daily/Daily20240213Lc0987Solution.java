package daily;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Daily20240213Lc0987Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodeList = new ArrayList<>();
        dfs(root, 0, 0, nodeList);
        nodeList.sort((o1, o2) -> {
            if (o1[1] < o2[1]) {
                return -1;
            } else if (o1[1] > o2[1]) {
                return 1;
            } else if (o1[0] < o2[0]) {
                return -1;
            } else if (o1[0] > o2[0]) {
                return 1;
            } else return Integer.compare(o1[2], o2[2]);
        });
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = null;
        int preCol = Integer.MIN_VALUE;
        for (int[] node : nodeList) {
            if (node[1] != preCol) {
                if (tmp != null) {
                    res.add(tmp);
                }
                preCol = node[1];
                tmp = new ArrayList<>();
                tmp.add(node[2]);
            } else {
                tmp.add(node[2]);
            }
        }
        if (tmp != null) {
            res.add(tmp);
        }
        return res;
    }

    private void dfs(TreeNode node, int i, int j, List<int[]> nodeList) {
        if (node == null) {
            return;
        }
        nodeList.add(new int[] {i, j, node.val});
        dfs(node.left, i + 1, j - 1, nodeList);
        dfs(node.right, i + 1, j + 1, nodeList);
    }
}
