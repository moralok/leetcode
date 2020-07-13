package string.reverse_string;

import java.util.Arrays;

public class Solution {

    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char c = s[i];
            s[i++] = s[j];
            s[j--] = c;
        }
    }
 
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] case1 = new char[] {'h','e','l','l','o'};
        char[] case2 = new char[] {'H','a','n','n','a','h'};
        solution.reverseString(case1);
        System.out.println(Arrays.toString(case1));
        solution.reverseString(case2);
        System.out.println(Arrays.toString(case2));
    }
}