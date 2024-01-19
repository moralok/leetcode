package daily;

import common.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lc2809Solution {

    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int n = nums1.size(), s1 = 0, s2 = 0;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            int a = nums1.get(i);
            int b = nums2.get(i);
            pairs[i][0] = a;
            pairs[i][1] = b;
            s1 += a;
            s2 += b;
        }

        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));

        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int a = pairs[i][0];
            int b = pairs[i][1];
            for (int j = i + 1; j > 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - 1] + a + b * j);
            }
        }

        for (int i = 0; i <= n; i++) {
            if (s1 + s2 * i - dp[i] <= x) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Lc2809Solution solution = new Lc2809Solution();
        List<Integer> num1 = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();
        int x;

        num1.clear();
        num2.clear();
        x = 4;
        for (int anInt : Utils.buildInts("[1,2,3]")) {
            num1.add(anInt);
        }
        for (int anInt : Utils.buildInts("[1,2,3]")) {
            num2.add(anInt);
        }
        assert solution.minimumTime(num1, num2, 4) == 3;

        num1.clear();
        num2.clear();
        x = 4;
        for (int anInt : Utils.buildInts("[1,2,3]")) {
            num1.add(anInt);
        }
        for (int anInt : Utils.buildInts("[3,3,3]")) {
            num2.add(anInt);
        }
        assert solution.minimumTime(num1, num2, 4) == -1;
    }
}
