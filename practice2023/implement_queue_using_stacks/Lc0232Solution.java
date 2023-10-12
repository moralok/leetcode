package practice2023.implement_queue_using_stacks;

import java.util.Stack;

public class Lc0232Solution {

    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out =  new Stack<>();

    public Lc0232Solution() {

    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        inToOut();
        return out.pop();
    }
    
    public int peek() {
        inToOut();
        return out.peek();
    }
    
    public boolean empty() {
        return in.empty() && out.empty();
    }

    private void inToOut() {
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
    }
}
