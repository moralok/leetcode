package daily;

import java.util.ArrayDeque;
import java.util.Queue;

public class Daily20240303Lc0225Solution {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public Daily20240303Lc0225Solution() {
        this.queue1 = new ArrayDeque<>();
        this.queue2 = new ArrayDeque<>();
    }

    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
