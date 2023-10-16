package practice2023.minimum_operations_to_halve_array_sum;

import java.util.PriorityQueue;

public class Lc2208SolutionPriorityQueue {

    public int halveArray(int[] nums) {
        int len = nums.length;
        PriorityQueue<Double> pq = new PriorityQueue<>(len, (e1, e2) -> {
            if (e1 > e2) {
                return -1;
            } else if (e1 < e2) {
                return 1;
            } else {
                return 0;
            }
        });
        Double sum = 0d;
        // 创建堆
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            pq.offer((double)nums[i]);
        }
        sum /= 2;
        Double minusSum = 0d;
        int ans = 0;
        while (minusSum < sum) {
            Double head = pq.poll();
            head /= 2;
            minusSum += head;
            pq.offer(head);
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,8,20};
        Lc2208SolutionPriorityQueue lc2208Solution = new Lc2208SolutionPriorityQueue();
        int ans = lc2208Solution.halveArray(nums);
        System.out.println(ans);
    }
}
