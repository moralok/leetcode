package daily;

import java.util.ArrayDeque;
import java.util.Deque;

public class Daily20240304Lc0232Solution {

    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    public Daily20240304Lc0232Solution() {
        this.stack1 = new ArrayDeque<>();
        this.stack2 = new ArrayDeque<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        beforePop();
        return stack2.pop();
    }

    public int peek() {
        beforePop();
        return stack2.peek();
    }

    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }

    private void beforePop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}
