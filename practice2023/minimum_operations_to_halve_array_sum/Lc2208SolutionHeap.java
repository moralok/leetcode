package practice2023.minimum_operations_to_halve_array_sum;

/**
 * 使用自定义的堆
 */
public class Lc2208SolutionHeap {

    public int halveArray(int[] nums) {
        int len = nums.length;
        long[] pq = new long[len];
        
        long sum = 0l;
        // 创建堆
        for (int i = 0; i < len; i++) {
            long tmp = (long) nums[i] << 20;
            sum += tmp;
            pq[i] = tmp;
        }
        heapify(pq);

        sum /= 2;

        long minusSum = 0l;
        int ans = 0;
        while (minusSum < sum) {
            pq[0] /= 2;
            minusSum += pq[0];
            sink(pq, 0, len);
            ans++;
        }
        return ans;
    }

    private boolean less(long[] pq, int i, int j) {
        return pq[i] < pq[j];
    }

    private void swap(long[] pq, int i, int j) {
        long tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    private void sink(long[] pq, int i, int size) {
        int j = 2 * i + 1;
        while (j < size) {
            if (j + 1 < size && pq[j + 1] > pq[j]) {
                j++;
            }
            if (!less(pq, i, j)) {
                break;
            }
            swap(pq, i, j);
            i = j;
            j = 2 * i + 1;
        }
    }

    private void heapify(long[] pq) {
        int len = pq.length;
        int n = (len - 2) / 2;
        while (n >= 0) {
            sink(pq, n--, len);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {5,19,8,1};
        Lc2208SolutionHeap lc2208Solution = new Lc2208SolutionHeap();
        int ans = lc2208Solution.halveArray(nums);
        System.out.println(ans);
    }
}
