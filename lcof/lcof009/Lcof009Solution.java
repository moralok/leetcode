package lcof.lcof009;

import java.util.LinkedList;

public class Lcof009Solution {

    private LinkedList<Integer> stack1;

    private LinkedList<Integer> stack2;
    
    public Lcof009Solution() {
        // 双栈模拟
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }
    
    // O(1)
    public void appendTail(int value) {
        stack1.push(value);
    }
    
    // 摊销 O(1)
    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        }
        return stack2.pop();
    }
}