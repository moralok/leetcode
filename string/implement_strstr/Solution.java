package string.implement_strstr;

public class Solution {
    
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String haystack1 = "hello", needle1 = "ll";
        System.out.println(solution.strStr(haystack1, needle1));
        String haystack2 = "aaaaa", needle2 = "bba";
        System.out.println(solution.strStr(haystack2, needle2));
    }
}