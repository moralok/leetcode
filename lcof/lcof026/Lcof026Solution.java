package lcof.lcof026;

public class Lcof026Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 先序遍历中判断是否相同
        return (A != null && B != null) && (helper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean helper(TreeNode a, TreeNode b) {
        // 卫语句写的好好
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }
        return helper(a.left, b.left) && helper(a.right, b.right);
    }
}