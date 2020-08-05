package lcof.lcof033;

public class Lcof033Solution {
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    private boolean helper(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int p = i, mid = -1;
        while (postorder[p] < postorder[j]) {
            p++;
        }
        mid = p;
        while (postorder[p] > postorder[j]) {
            p++;
        }
        // 不要忘了 p == j
        return p == j && helper(postorder, i, mid - 1) && helper(postorder, mid, j - 1);
    }
}