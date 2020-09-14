package lcof.lcof051;

public class Lcof051Solution {
    
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }
        int[] tmp = new int[len];
        return reversePairs(copy, 0, len - 1, tmp);
    }

    private int reversePairs(int[] copy, int left, int right, int[] tmp) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(copy, left, mid, tmp);
        int rightPairs = reversePairs(copy, mid + 1, right, tmp);
        int mergePairs = mergeAndCount(copy, left, mid, right, tmp);
        return leftPairs + rightPairs + mergePairs;
    }

    private int mergeAndCount(int[] copy, int left, int mid, int right, int[] tmp) {
        if (copy[mid] <= copy[mid + 1]) {
            return 0;
        }
        for (int i = left; i <= right; i++) {
            tmp[i] = copy[i];
        }
        int i = left, j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                copy[k] = tmp[j++];
            } else if (j == right + 1) {
                copy[k] = tmp[i++];
            } else if (tmp[i] <= tmp[j]) {
                copy[k] = tmp[i++];
            } else {
                copy[k] = tmp[j++];
                // 归并中怎么计算逆序对不要搞错了
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
