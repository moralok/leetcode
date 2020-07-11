package array.remove_element;

public class Solution2 {

    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            // 利用无顺序要求对删除元素较少时的优化
            if (val == nums[i]) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] case1 = new int[] {3,2,2,3};
        int[] case2 = new int[] {0,1,2,2,3,0,4,2};
        Solution2 solution = new Solution2();
        System.out.println(solution.removeElement(case1, 3));
        System.out.println(solution.removeElement(case2, 2));
    }
}