package linked_list.palindrome_linked_list;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        // 复制到数组再用双指针
        // O(n) O(n)
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int i = 0, j  = list.size() - 1;
        while (i < j) {
            // 注意Integer的比较（犯错）
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}