package array.array_partition_i;

public class Solution2 {

    public int arrayPairSum(int[] nums) {
        int[] buckets = new int[20001];
        for (int i : nums) {
            buckets[i+10000]++;
        }
        int sum = 0;
        int flag = 0;
        for (int i = 0; i < buckets.length; i++) {
            // 这里的处理好厉害啊！！！
            sum += (buckets[i] + 1 - flag) / 2 * (i-10000);
            flag = (buckets[i] - flag + 2) % 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println((-1) & 1);
        System.out.println((-1) % 1);
        int[] case1 = new int[] {1,4,3,2};
        Solution solution = new Solution();
        System.out.println(solution.arrayPairSum(case1));
    }
}