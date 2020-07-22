package queue.moving_average_from_data_stream;

public class MovingAverage2 {

    int[] arr;
    int size = 0;
    int count = 0;
    int sum = 0;

    public MovingAverage2(int size) {
        // 基于数组的循环队列
        arr = new int[size];
        this.size = size;
    }
    
    public double next(int val) {
        count++;
        int idx = (count-1) % size;
        sum = sum - arr[idx] + val;
        arr[idx] = val;
        return sum * 1.0 / Math.min(size, count);
    }
}