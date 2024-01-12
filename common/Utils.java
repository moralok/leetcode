package common;

public class Utils {

    public static ListNode buildListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode();
        for (int i = arr.length - 1; i >= 0; i--) {
            ListNode node = new ListNode(arr[i]);
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
    }

    public static ListNode buildListNode(String str) {
        int[] ints = buildInts(str);
        return buildListNode(ints);
    }

    public static int[] buildInts(String str) {
        String[] splits = buildStrings(str);
        int[] ret = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            ret[i] = Integer.parseInt(splits[i]);
        }
        return ret;
    }

    public static String[] buildStrings(String str) {
        if (str == null) {
            return null;
        }
        if (str.charAt(0) == '[') {
            str = str.substring(1);
        }
        if (str.charAt(str.length() - 1) == ']') {
            str = str.substring(0, str.length() - 1);
        }
        return str.split(",");
    }

    public static String buildStr(ListNode head) {
        if (head == null) {
            return "[]";
        }
        boolean isHead = true;
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            if (isHead) {
                sb.append(head.val);
                isHead = false;
            } else {
                sb.append(",").append(head.val);
            }
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
