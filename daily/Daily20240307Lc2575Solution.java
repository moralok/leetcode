package daily;

import java.util.Arrays;

public class Daily20240307Lc2575Solution {

    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] res = new int[n];
        long cur = 0;
        for (int i = 0; i < n; i++) {
            cur = cur * 10 + (word.charAt(i) - '0');
            cur %= m;
            if (cur == 0) {
                res[i] = 1;
            } else {
                res[i] = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Daily20240307Lc2575Solution solution = new Daily20240307Lc2575Solution();
        String word = "998244353";
        int m = 3;
        assert Arrays.equals(solution.divisibilityArray(word, m), new int[]{1, 1, 0, 0, 0, 1, 1, 0, 0});
    }
}
