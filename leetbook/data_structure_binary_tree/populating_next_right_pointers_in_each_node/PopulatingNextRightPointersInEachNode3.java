package leetbook.data_structure_binary_tree.populating_next_right_pointers_in_each_node;

public class PopulatingNextRightPointersInEachNode3 {

    public Node connect(Node root) {
        // 递归，按题意调用栈不算占用空间
        if (root == null) {
            return root;
        }
        connect(root.left, root.right);
        return root;
    }

    private void connect(Node left, Node right) {
        if (left == null) {
            return;
        }
        left.next = right;
        connect(left.left, left.right);
        // 这一块重复工作，效率不高
        connect(left.right, right.left);
        connect(right.left, right.right);
    }
}
