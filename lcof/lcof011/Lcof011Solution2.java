package lcof.lcof011;

public class Lcof011Solution2 {
    public int minArray(int[] numbers) {
        // 二分查找 O(log(n))
        // 这个非常规模板很容易犯错啊
        int lo = 0, hi = numbers.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (numbers[mid] > numbers[hi]) {
                // 大的时候不考虑
                lo = mid + 1;
            } else if (numbers[mid] < numbers[hi]) {
                // 小的时候还不能舍弃
                hi = mid;
            } else {
                // 无法确定左右区间
                hi--;
            }
        }
        return numbers[lo];
    }
}