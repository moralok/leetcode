package queue.moving_average_from_data_stream;

import java.util.ArrayDeque;
import java.util.Deque;

public class MovingAverage {

    // 双端队列

    int sum = 0, size =0, count = 0;
    Deque<Integer> deque = new ArrayDeque<>();

    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        count++;
        deque.add(val);
        int tail = count > size ? deque.poll() : 0;
        sum = sum - tail + val;
        return sum * 1.0 / Math.min(size, count);
    }
}