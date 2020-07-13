package string.longest_common_prefix;

import java.util.Arrays;

public class Solution4 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        return longestCommonPrefix(first, last);
    }

    private String longestCommonPrefix(String first, String last) {
        int length = Math.min(first.length(), last.length());
        int index = 0;
        while (index < length && first.charAt(index) == last.charAt(index)) {
            index++;
        }
        return first.substring(0, index);
    }

    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        String[] case1 = new String[] {"flower","flow","flight"};
        String[] case2 = new String[] {"dog","racecar","car"};
        String[] case3 = new String[] {};
        System.out.println(solution.longestCommonPrefix(case1));
        System.out.println(solution.longestCommonPrefix(case2));
        System.out.println(solution.longestCommonPrefix(case3));
    }
}