package tree.merge_two_binary_trees;

public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // 递归
        // 这个卫语句比我想的漂亮多了！
        if (t1 == null) {
            return t2;
        }    
        if (t2 == null) {
            return t1;
        }
        // 修改在t1上
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public static void main(String[] args) {
        
    }
}