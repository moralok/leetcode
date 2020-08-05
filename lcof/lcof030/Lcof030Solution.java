package lcof.lcof030;

import java.util.LinkedList;

public class Lcof030Solution {

    private LinkedList<Integer> stack1;
    // 可用另一种方式压缩stack2
    private LinkedList<Integer> stack2;
    private Integer min = Integer.MAX_VALUE;
    
    /** initialize your data structure here. */
    public Lcof030Solution() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }
    
    public void push(int x) {
        stack1.push(x);
        if (x < min) {
            min = x;
        }
        stack2.push(min);
    }
    
    public void pop() {
        stack1.pop();
        stack2.pop();
        // !!注意
        if (stack2.isEmpty()) {
            min = Integer.MAX_VALUE;
        } else {
            min = stack2.peek();
        }
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int min() {
        return stack2.peek();
    }
}