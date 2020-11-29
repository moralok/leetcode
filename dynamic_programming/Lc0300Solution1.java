package dynamic_programming;

public class Lc0300Solution1 {
    public int lengthOfLIS(int[] nums) {
        // d[i] 存序列长度为i的最小末尾值
        // d[i] 单调递减的结论我。。。
        int n;
        if (nums == null || (n = nums.length) == 0) {
            return 0;
        }
        int len = 1;
        int[] d = new int[n + 1];
        d[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                // 每次二分法都有错。。。
                int l = 1, r = len;
                while (l <= r) {
                    int mid = l + ((r - l) >> 1);
                    if (d[mid] < nums[i]) {
                        l = mid + 1;
                    } else if (d[mid] > nums[i]) {
                        r = mid - 1;
                    } else {
                        // 原先在想不可能呢
                        l = mid;
                        break;
                    }
                }
                d[l] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Lc0300Solution1 solution = new Lc0300Solution1();
        int[] nums = new int[] {10,9,2,5,3,7,101,18};
        System.out.println(solution.lengthOfLIS(nums));
        nums = new int[] {0,1,0,3,2,3};
        System.out.println(solution.lengthOfLIS(nums));
        nums = new int[] {3,5,6,2,5,4,19,5,6,7,12};
        System.out.println(solution.lengthOfLIS(nums));
    }
}
