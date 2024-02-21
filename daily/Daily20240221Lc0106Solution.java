package daily;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Daily20240221Lc0106Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return dfs(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, indexMap);
    }

    private TreeNode dfs(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight, Map<Integer, Integer> indexMap) {
        if (postLeft > postRight) {
            return null;
        }
        if (postLeft == postRight) {
            return new TreeNode(postorder[postRight]);
        }
        TreeNode treeNode = new TreeNode(postorder[postRight]);
        Integer index = indexMap.get(postorder[postRight]);
        int rightLen = inRight - index;
        treeNode.right = dfs(inorder, index + 1, inRight, postorder, postRight - rightLen, postRight - 1, indexMap);
        treeNode.left = dfs(inorder, inLeft, index - 1, postorder, postLeft, postRight - rightLen - 1, indexMap);
        return treeNode;
    }

    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        int inorderIndex = inorder.length - 1;
        for (int i = postorder.length - 2; i >= 0; i--) {
            int postorderVal = postorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.right = new TreeNode(postorderVal);
                stack.push(node.right);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(postorderVal);
                stack.push(node.left);
            }
        }
        return root;
    }
}
