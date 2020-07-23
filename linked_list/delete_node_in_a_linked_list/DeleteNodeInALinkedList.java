package linked_list.delete_node_in_a_linked_list;

public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        // 牛！一直在想这题究竟在考什么
        node.val = node.next.val;
        node.next = node.next.next;
    }
}