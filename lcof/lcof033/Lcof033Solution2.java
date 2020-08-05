package lcof.lcof033;

import java.util.LinkedList;

public class Lcof033Solution2 {
    public boolean verifyPostorder(int[] postorder) {
        // 这也太牛了，反复思想也不过能感受到那点意思，并不能融会贯通
        LinkedList<Integer> stack = new LinkedList<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }
}