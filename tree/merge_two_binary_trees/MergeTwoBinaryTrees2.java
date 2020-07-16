package tree.merge_two_binary_trees;

import java.util.Stack;

public class MergeTwoBinaryTrees2 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[] {t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] nodes = stack.pop();
            nodes[0].val += nodes[1].val;
            if (nodes[0].left == null) {
                nodes[0].left = nodes[1].left;
            } else if (nodes[0].left != null && nodes[1].left != null) {
                // 注意，不能省略else，否则上条分支结果会影响本分支
                stack.push(new TreeNode[] {nodes[0].left, nodes[1].left});
            }
            if (nodes[0].right == null) {
                nodes[0].right = nodes[1].right;
            } else if (nodes[0].right != null && nodes[1].right != null) {
                stack.push(new TreeNode[] {nodes[0].right, nodes[1].right});
            }
        }
        return t1;
    }

    public static void main(String[] args) {
        
    }
}