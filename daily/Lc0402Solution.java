package daily;

import java.util.Deque;
import java.util.LinkedList;

public class Lc0402Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int len = num.length();
        for (int i = 0; i < len; i++) {
            char ch = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && ch < deque.peekLast()) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(ch);
        }
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char ch = deque.pollFirst();
            if (leadingZero && ch == '0') {
                continue;
            }
            leadingZero = false;
            sb.append(ch);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
