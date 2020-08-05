package lcof.lcof031;

import java.util.LinkedList;

public class Lcof031Solution2 {
    
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 大佬写的真漂亮
        LinkedList<Integer> stack = new LinkedList<>();
        int i = 0;
        for (Integer item : pushed) {
            stack.push(item);
            while (!stack.isEmpty() && stack.peek().equals(popped[i])) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}