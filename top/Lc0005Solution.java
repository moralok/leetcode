package top;

public class Lc0005Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 寻找当前字符的连续相同段，确定左右边界
            int left = i, right = i;
            while (right + 1 < s.length() && s.charAt(right + 1) == s.charAt(right)) {
                right++;
            }
            i = right;
            // 向两边生长并比较
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            // 如果长度更大，则更新答案的边界
            if (right - left > end - start) {
                start = left;
                end = right;
            }
        }
        return s.substring(start + 1, end);
    }

    public static void main(String[] args) {
        Lc0005Solution solution = new Lc0005Solution();
        String s = "babad";
        System.out.println(solution.longestPalindrome(s));
        s = "cbbd";
        System.out.println(solution.longestPalindrome(s));
    }
}
