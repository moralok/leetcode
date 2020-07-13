package string.reverse_words_in_a_string_iii;

public class Solution2 {
    public String reverseWords(String s) {
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        for (; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                for (int k = i - 1; k >= j; k--) {
                    sb.append(s.charAt(k));
                }
                sb.append(" ");
                j = i + 1;
            }
        }
        for (int k = i - 1; k >= j; k--) {
            sb.append(s.charAt(k));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String case1 = "Let's take LeetCode contest";
        System.out.println(solution.reverseWords(case1));
    }
}