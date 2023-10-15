package practice2023.reverse_pairs;

public class Lc0493Solution {

    // private static int MAX = 50000;
    private static int[] aux;

    public int reversePairs(int[] nums) {
        if (nums == null) {
            return 0;
        }
        aux = new int[nums.length];
        return reversePairs(nums, 0, nums.length - 1);
    }

    private int reversePairs(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        return reversePairs(nums, left, mid) + reversePairs(nums, mid + 1, right) + merge(nums, left, mid, right);
    }

    private int merge(int[] nums, int left, int mid, int right) {
        // 一定要排序，不能提前返回！！
        int ans = 0, sum = 0;
        for (int i = left, j = mid + 1; i <= mid; i++) {
            // 注意边界和判断
            while (j <= right && (long)nums[i] > (long)nums[j] * 2) {
                j++;
                sum++;
            }
            ans += sum;
        }
        if (nums[mid] <= nums[mid + 1]) {
            return ans;
        }
        for (int i = left; i <= right; i++) {
            aux[i] = nums[i];
        }
        int i = left, j = mid + 1, k = left;
        while (i <= mid || j <= right) {
            if (i > mid) {
                nums[k++] = aux[j++];
            } else if (j > right) {
                nums[k++] = aux[i++];
            } else {
                nums[k++] = aux[i] <= aux[j] ? aux[i++] : aux[j++];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,2,3,1};
        Lc0493Solution lc0493Solution = new Lc0493Solution();
        int ans = lc0493Solution.reversePairs(nums);
        System.out.println(ans);
    }
}
