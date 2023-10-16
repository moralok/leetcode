package practice2023.merge_k_sorted_lists;

import common.ListNode;

/**
 * 不要做题做傻了啊！！！可以直接用 PriorityQueue 啊。
 */
public class Lc0023SolutionHeap {

    public ListNode mergeKLists(ListNode[] lists) {
        // 堆化
        heapify(lists);
        ListNode dummy = new ListNode(), tail = dummy;;
        int size = lists.length;
        while (size >= 1) {
            ListNode node = lists[0];
            if (node == null) {
                // 交换到末尾
                swap(lists, 0, --size);
            } else {
                // 取最小
                tail.next = node;
                tail = tail.next;
                lists[0] = lists[0].next;
            }
            sink(lists, 0, size);
        }
        return dummy.next;
    }

    private void swap(ListNode[] lists, int i, int j) {
        ListNode tmp = lists[i];
        lists[i] = lists[j];
        lists[j] = tmp;
    }

    private boolean less(ListNode[] lists, int i, int j) {
        if (lists[i] != null && lists[j] != null) {
            return lists[i].val < lists[j].val;
        } else if (lists[i] == null && lists[j] == null) {
            return false;
        } else if (lists[i] == null) {
            return false;
        } else {
            return true;
        }
    }

    private void sink(ListNode[] lists, int i, int size) {
        int j = 2 * i + 1;
        while (j < size) {
            if (j + 1 < size && less(lists, j + 1, j)) {
                j++;
            }
            if (!less(lists, j, i)) {
                break;
            }
            swap(lists, i, j);
            i = j;
            j = 2 * i + 1;
        }
    }

    private void heapify(ListNode[] lists) {
        int n = (lists.length - 2) / 2;
        while (n >= 0) {
            sink(lists, n--, lists.length);
        }
    }
    
}
