package practice2023.implement_stack_using_queues;

import java.util.LinkedList;

public class Lc0225Solution {

    private LinkedList<Integer> queue = new LinkedList<>();
    
    public Lc0225Solution() {

    }
    
    public void push(int x) {
        int size = queue.size();
        queue.offer(x);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}
