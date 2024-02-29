package daily;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Daily20240222Lc0889Solution {

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            indexMap.put(postorder[i], i);
        }
        return dfs(preorder, 0, postorder.length - 1, postorder, 0, postorder.length - 1, indexMap);
    }

    private TreeNode dfs(int[] preorder, int preLeft, int preRight, int[] postorder, int postLeft, int postRight, Map<Integer, Integer> indexMap) {
        if (preLeft > preRight) {
            return null;
        }
        if (preLeft == preRight) {
            return new TreeNode(preorder[preLeft]);
        }
        TreeNode node = new TreeNode(preorder[preLeft]);
        int nextVal = preorder[preLeft + 1];
        Integer index = indexMap.get(nextVal);
        node.left = dfs(preorder, preLeft + 1, preLeft + index - postLeft + 1, postorder, postLeft, index, indexMap);
        node.right = dfs(preorder, preLeft + index - postLeft + 2, preRight, postorder, index + 1, postRight - 1, indexMap);
        return node;
    }
}
