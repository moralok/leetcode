package daily;

import common.TreeNode;

import java.util.*;

public class Daily20240224Lc2476Solution {

    // 超时
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> res = new ArrayList<>();
        for (Integer target : queries) {
            List<Integer> tuple = new ArrayList<>(2);
            tuple.add(-1);
            tuple.add(-1);
            dfs(root, target, tuple);
            res.add(tuple);
        }
        return res;
    }

    private void dfs(TreeNode node, Integer target, List<Integer> tuple) {
        if (node == null) {
            return;
        }
        if (node.val == target) {
            tuple.set(0, target);
            tuple.set(1, target);
            return;
        }
        if (node.val < target) {
            tuple.set(0, node.val);
            dfs(node.right, target, tuple);
        } else {
            tuple.set(1, node.val);
            dfs(node.left, target, tuple);
        }
    }

    public List<List<Integer>> closestNodes1(TreeNode root, List<Integer> queries) {
        List<Integer> arr = new ArrayList<>();
        dfs(root, arr);

        List<List<Integer>> res = new ArrayList<>();
        for (int val : queries) {
            int maxVal = -1, minVal = -1;
            int idx = binarySearch(arr, val);
            if (idx != arr.size()) {
                maxVal = arr.get(idx);
                if (arr.get(idx) == val) {
                    minVal = val;
                    List<Integer> list = new ArrayList<>();
                    list.add(minVal);
                    list.add(maxVal);
                    res.add(list);
                    continue;
                }
            }
            if (idx > 0) {
                minVal = arr.get(idx - 1);
            }
            List<Integer> list2 = new ArrayList<>();
            list2.add(minVal);
            list2.add(maxVal);
            res.add(list2);
        }
        return res;
    }

    public void dfs(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        dfs(root.left, arr);
        arr.add(root.val);
        dfs(root.right, arr);
    }

    public int binarySearch(List<Integer> arr, int target) {
        int low = 0, high = arr.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
