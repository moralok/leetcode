package lcof.lcof006;

import java.util.LinkedList;
import java.util.List;

public class Lcof006Solution {
    public int[] reversePrint(ListNode head) {
        // 借助集合
        // O(n) O(n)
        List<Integer> list = new LinkedList<>();
        ListNode node = head;
        while (node != null) {
            list.add(0, node.val);
            node = node.next;
        }
        int[] res = new int[list.size()];
        int idx = 0;
        for (Integer item : list) {
            res[idx++] = item;
        }
        return res;
    }
}