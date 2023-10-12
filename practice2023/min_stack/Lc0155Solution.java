package practice2023.min_stack;

import java.util.Stack;

public class Lc0155Solution {

    private Stack<Integer> data;
    private Stack<Integer> minStack;
    
    public Lc0155Solution() {
        data = new Stack<>();
        // 官方题解中添加了最大值作为栈底很巧妙
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        data.push(val);
        // 注意边界条件和使用最大值
        int currentMin = minStack.empty() ? Integer.MAX_VALUE : minStack.peek();
        if (val <= currentMin) {
            minStack.push(val);
        } else {
            minStack.push(currentMin);
        }
    }
    
    public void pop() {
        data.pop();
        minStack.pop();
    }
    
    public int top() {
        return data.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
