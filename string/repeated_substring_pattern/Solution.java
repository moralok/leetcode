package string.repeated_substring_pattern;

public class Solution {
    
    public boolean repeatedSubstringPattern(String s) {
        // 奇思妙想
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String case1 = "abab";
        String case2 = "aba";
        String case3 = "abcabcabcabc";
        System.out.println(solution.repeatedSubstringPattern(case1));
        System.out.println(solution.repeatedSubstringPattern(case2));
        System.out.println(solution.repeatedSubstringPattern(case3));
    }
}