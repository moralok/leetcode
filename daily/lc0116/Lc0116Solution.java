package daily.lc0116;

public class Lc0116Solution {
    public Node connect(Node root) {
        // 好巧，没两天就在每日一题撞见
        if (root == null) {
            return root;
        }
        Node start = root;
        while (start.left != null) {
            for (Node head = start; head != null; head = head.next) {
                head.left.next = head.right;
                head.right.next = head.next != null ? head.next.left : null;
            }
            start = start.left;
        }
        return root;
    }
}
