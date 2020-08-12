package lcof.lcof036;

public class Lcof036Solution {

    private Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        if (pre == null) {
            head = node;
        } else {
            pre.right = node;
        }
        node.left = pre;
        pre = node;
        dfs(node.right);
    }
}