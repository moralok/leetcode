package string.longest_uncommon_subsequence_i;

public class Solution {

    public int findLUSlength(String a, String b) {
        // 注意字符串相同的判断
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a1 = "aba";
        String b1 = "cdc";
        String a2 = "aaa";
        String b2 = "bbb";
        String a3 = "aaa";
        String b3 = "aaa";
        System.out.println(solution.findLUSlength(a1, b1));
        System.out.println(solution.findLUSlength(a2, b2));
        System.out.println(solution.findLUSlength(a3, b3));
    }
}