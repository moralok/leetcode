package leetbook.data_structure_binary_tree.populating_next_right_pointers_in_each_node_ii;

public class PopulatingNextRightPointersInEachNodeIi {

    private Node last, nextStart;

    public Node connect(Node root) {
        // 利用已建立的next指针迭代
        if (root == null) {
            return root;
        }
        Node start = root;
        while (start != null) {
            last = null;
            nextStart = null;
            for (Node p = start; p != null; p = p.next) {
                if (p.left != null) {
                    handle(p.left);
                }
                if (p.right != null) {
                    handle(p.right);
                }
            }
            start = nextStart;
        }
        return root;
    }

    private void handle(Node node) {
        // 有点妙啊
        if (last != null) {
            last.next = node;
        }
        if (nextStart == null) {
            nextStart = node;
        }
        last = node;
    }
}
