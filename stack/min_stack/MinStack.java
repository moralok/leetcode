package stack.min_stack;

import java.util.LinkedList;

public class MinStack {

    private LinkedList<Integer> stack;
    private LinkedList<Integer> helper;
    private int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        helper = new LinkedList<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (x < min) {
            min = x;
        }
        helper.push(min);
    }
    
    public void pop() {
        stack.pop();
        helper.pop();
        // 犯错，要更新最小值
        if (helper.size() > 0) {
            min = getMin();
        } else {
            min = Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        return stack.getFirst();
    }
    
    public int getMin() {
        return helper.getFirst();
    }
}