package leetbook.data_structure_binary_tree.serialize_and_deserialize_binary_tree;

/**
 * 括号表示编码 + 递归下降解码
 */
public class SerializeAndDeserializeBinaryTree3 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "X";
        }
        String l = "(" + serialize(root.left) + ")";
        String r = "(" + serialize(root.right) + ")";
        return l + root.val + r;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] index = new int[]{0};
        return parse(data, index);
    }

    private TreeNode parse(String data, int[] index) {
        if (data.charAt(index[0]) == 'X') {
            index[0]++;
            return null;
        }
        TreeNode cur = new TreeNode(0);
        cur.left = parseSubtree(data, index);
        cur.val = parseInt(data, index);
        cur.right = parseSubtree(data, index);
        return cur;
    }

    private int parseInt(String data, int[] index) {
        int x = 0, sign = 1;
        if (!Character.isDigit(data.charAt(index[0]))) {
            sign = -1;
            index[0]++;
        }
        while (Character.isDigit(data.charAt(index[0]))) {
            x = x * 10 + (data.charAt(index[0]++) - '0');
        }
        return x * sign;
    }

    private TreeNode parseSubtree(String data, int[] index) {
        // 跳过左括号
        index[0]++;
        TreeNode subtree = parse(data, index);
        // 跳过右括号
        index[0]++;
        return subtree;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree3 solution = new SerializeAndDeserializeBinaryTree3();
        TreeNode node = solution.deserialize("((X)2(X))1(((X)4(X))3((X)5(X)))");
        String str = solution.serialize(node);
        System.out.println(str);
        return;
    }
}
