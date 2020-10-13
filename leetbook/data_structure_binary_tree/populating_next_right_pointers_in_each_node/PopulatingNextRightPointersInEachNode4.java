package leetbook.data_structure_binary_tree.populating_next_right_pointers_in_each_node;

public class PopulatingNextRightPointersInEachNode4 {

    public Node connect(Node root) {
        // 递归，利用已经建立的next指针
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
