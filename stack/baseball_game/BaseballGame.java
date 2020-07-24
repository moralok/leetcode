package stack.baseball_game;

import java.util.LinkedList;

public class BaseballGame {
    public int calPoints(String[] ops) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (String op : ops) {
            if (op.equals("+")) {
                int a = stack.pop();
                int b = stack.peek();
                int c = a + b;
                stack.push(a);
                stack.push(c);
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        int res = 0;
        for (Integer i : stack) {
            res += i;
        }
        return res;
    }
}