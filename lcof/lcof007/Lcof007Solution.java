package lcof.lcof007;

import java.util.HashMap;
import java.util.Map;

public class Lcof007Solution {

    private Map<Integer, Integer> indexMap;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 递归，只传preorderLeft也行
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preorderLeft, int preOrderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preOrderRight) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preorderLeft]);
        int inorderIndex = indexMap.get(preorder[preorderLeft]);
        node.left = buildTree(preorder, inorder, preorderLeft + 1, inorderIndex - inorderLeft + preorderLeft , inorderLeft , inorderIndex - 1);
        node.right = buildTree(preorder, inorder, inorderIndex - inorderLeft + preorderLeft + 1, preOrderRight ,inorderIndex + 1 , inorderRight);
        return node;
    }
}