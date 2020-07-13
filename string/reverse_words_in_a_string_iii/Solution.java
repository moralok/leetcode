package string.reverse_words_in_a_string_iii;

public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(new StringBuilder(word).reverse()).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String case1 = "Let's take LeetCode contest";
        System.out.println(solution.reverseWords(case1));
    }
}