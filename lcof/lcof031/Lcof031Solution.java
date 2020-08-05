package lcof.lcof031;

import java.util.LinkedList;

public class Lcof031Solution {
    
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList<>();
        int i = 0, j = 0;
        while (i < pushed.length) {
            if (stack.isEmpty() || !stack.peek().equals(popped[j])) {
                stack.push(pushed[i++]);
            } else {
                stack.pop();
                j++;
            }
        }
        // 第一次写的忘记了最后的处理，大佬写的好简洁啊
        while (!stack.isEmpty() && stack.peek().equals(popped[j])) {
            stack.pop();
            j++;
        }
        return stack.isEmpty();
    }
}