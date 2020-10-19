package daily;

import java.util.LinkedList;

public class Lc0844Solution {

    public boolean backspaceCompare(String S, String T) {
        // 栈
        LinkedList<Character> stack1 = new LinkedList<>();
        LinkedList<Character> stack2 = new LinkedList<>();
        getStack(S, stack1);
        getStack(T, stack2);
        if (stack1.size() != stack2.size()) {
            return false;
        }
        while (!stack1.isEmpty()) {
            char c1 = stack1.pop();
            char c2 = stack2.pop();
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }

    private void getStack(String s, LinkedList<Character> stack) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
    }
}
