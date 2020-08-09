package lcof.lcof039;

public class Lcof039Solution2 {

    public int majorityElement(int[] nums) {
        // 投票法
        int votes = 0, x = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }
            if (x == num) {
                votes++;
            } else {
                votes--;
            }
        }
        return x;
    }
}