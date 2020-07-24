package binary_search.search_insert_position;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        // 感觉自己对于终止条件和最终的返回值还不够敏锐啊
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
}