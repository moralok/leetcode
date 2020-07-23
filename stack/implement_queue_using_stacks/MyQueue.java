package stack.implement_queue_using_stacks;

import java.util.LinkedList;

public class MyQueue {

    private LinkedList<Integer> stack1;
    private LinkedList<Integer> stack2;
    int front;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        // 每次倒空stack1再插入，就更新front
        // 妙啊，如果每次插入都倒出再倒入，复杂度就是O(n)，现在是O(1)
        if (stack1.isEmpty()) {
            front = x;
        }
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}