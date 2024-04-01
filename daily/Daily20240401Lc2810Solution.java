package daily;

import java.util.ArrayDeque;
import java.util.Deque;

public class Daily20240401Lc2810Solution {

    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == 'i') {
                sb.reverse();
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String finalString1(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        boolean head = true;
        for (char c : s.toCharArray()) {
            if (c == 'i') {
                head = !head;
            } else {
                if (head) {
                    deque.offer(c);
                } else {
                    deque.offerFirst(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (head) {
            while (!deque.isEmpty()) {
                sb.append(deque.poll());
            }
        } else {
            while (!deque.isEmpty()) {
                sb.append(deque.pollLast());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Daily20240401Lc2810Solution solution = new Daily20240401Lc2810Solution();
        assert solution.finalString("string").equals("rtsng");
        assert solution.finalString("poiinter").equals("ponter");

        assert solution.finalString1("string").equals("rtsng");
        assert solution.finalString1("poiinter").equals("ponter");
    }
}
