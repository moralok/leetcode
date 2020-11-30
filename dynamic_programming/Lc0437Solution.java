package dynamic_programming;

import java.util.HashMap;
import java.util.Map;

// 给定一个二叉树，它的每个结点都存放着一个整数值。

// 找出路径和等于给定数值的路径总数。

// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。

// 示例：

// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

//       10
//      /  \
//     5   -3
//    / \    \
//   3   2   11
//  / \   \
// 3  -2   1

// 返回 3。和等于 8 的路径有:

// 1.  5 -> 3
// 2.  5 -> 2 -> 1
// 3.  -3 -> 11
public class Lc0437Solution {

    private Map<Integer, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int sum) {
        // 这也算动态规划。。。
        if (root == null) {
            return 0;
        }
        int total = 0;
        // 初始化为1很重要
        map.put(0, 1);
        return dfs(root, total, sum);
    }

    private int dfs(TreeNode node, int total, int sum) {
        total += node.val;
        int ret = 0;
        ret += map.getOrDefault(total - sum, 0);
        map.put(total, map.getOrDefault(total, 0) + 1);
        if (node.left != null) {
            ret += dfs(node.left, total, sum);
        }
        if (node.right != null) {
            ret += dfs(node.right, total, sum);
        }
        map.put(total, map.get(total) - 1);
        return ret;
    }
}