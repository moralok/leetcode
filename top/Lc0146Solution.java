package top;

import java.util.HashMap;
import java.util.Map;

public class Lc0146Solution {

    private int capacity;

    private int size;

    private DLinkedNode head, tail;

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    
    public Lc0146Solution(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.prev = tail;
        head.next = tail;
        tail.prev = head;
        tail.next = head;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            removeNode(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            node = new DLinkedNode(key, value);
            cache.put(key, node);
            addToHead(node);
            size++;
            if (size > capacity) {
                removeTail();
                size--;
            }
        } else {
            node.value = value;
            removeNode(node);
            addToHead(node);
        }
    }

    private void removeTail() {
        DLinkedNode node = tail.prev;
        removeNode(node);
        cache.remove(node.key);
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public class DLinkedNode {

        int key;

        int value;
    
        DLinkedNode prev;

        DLinkedNode next;

        DLinkedNode() {
        }

        DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Lc0146Solution solution = new Lc0146Solution(2);
        int ret = 0;
        solution.put(1, 1);
        solution.put(2, 2);
        ret = solution.get(1);
        solution.put(3, 3);
        ret = solution.get(2);
        solution.put(4, 4);
        ret = solution.get(1);
        ret = solution.get(3);
        ret = solution.get(4);
        System.out.println(ret);
    }
}
