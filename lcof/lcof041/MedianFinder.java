package lcof.lcof041;

import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> queue1, queue2;

    /** initialize your data structure here. */
    public MedianFinder() {
        // 小顶堆
        queue1 = new PriorityQueue<>();
        // 大顶堆
        queue2 = new PriorityQueue<>((x, y) -> (y - x));
    }
    
    public void addNum(int num) {
        if (queue1.size() == queue2.size()) {
            queue2.add(num);
            queue1.add(queue2.poll());
        } else {
            queue1.add(num);
            queue2.add(queue1.poll());
        }
    }
    
    public double findMedian() {
        // 注意小数
        return queue1.size() != queue2.size() ? queue1.peek() : (queue1.peek() + queue2.peek()) / 2.0;
    }
}