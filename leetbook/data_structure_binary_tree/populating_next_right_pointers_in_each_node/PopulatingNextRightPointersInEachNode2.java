package leetbook.data_structure_binary_tree.populating_next_right_pointers_in_each_node;

public class PopulatingNextRightPointersInEachNode2 {

    public Node connect(Node root) {
        // 迭代，利用已经建立的next指针，空间复杂度O(1)
        if (root == null) {
            return null;
        }
        Node leftMost = root;
        while (leftMost.left != null) {
            Node head = leftMost;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
}
