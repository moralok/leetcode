package string.reverse_string_ii;

public class Solution {

    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            int begin = i;
            int end = Math.min(i + k - 1, s.length() - 1);
            while (begin < end) {
                char tmp = a[begin];
                a[begin++] = a[end];
                a[end--] = tmp;
            }
        }
        return new String(a);
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        String case1 = "abcdefg";
        int k1 = 2;
        System.out.println(solution.reverseStr(case1, k1));
    }
}