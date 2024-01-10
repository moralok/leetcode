package daily;

import java.util.ArrayDeque;
import java.util.Deque;

public class Lc2696Solution {

    public int minLength(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'B' && !stack.isEmpty() && stack.peek() == 'A') {
                stack.pop();
            } else if (s.charAt(i) == 'D' && !stack.isEmpty() && stack.peek() == 'C') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        Lc2696Solution solution = new Lc2696Solution();
        String s;

        s = "ABFCACDB";
        assert solution.minLength(s) == 2;

        s = "ACBBD";
        assert solution.minLength(s) == 5;
    }
}
