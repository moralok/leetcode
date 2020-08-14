package lcof.lcof059_ii;

import java.util.LinkedList;

public class Lcof059IiSolution {

    private LinkedList<Integer> queue;
    private LinkedList<Integer> helper;

    public Lcof059IiSolution() {
        queue = new LinkedList<>();
        helper = new LinkedList<>();
    }
    
    public int max_value() {
        if (helper.isEmpty()) {
            return -1;
        }
        return helper.peekFirst();
    }
    
    public void push_back(int value) {
        queue.addLast(value);
        while (!helper.isEmpty() && helper.peekLast() < value) {
            helper.removeLast();
        }
        helper.addLast(value);
    }
    
    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int pop = queue.pollFirst();
        if (helper.peekFirst().equals(pop)) {
            helper.pollFirst();
        }
        return pop;
    }
}