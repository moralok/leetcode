package string.longest_common_prefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    private String longestCommonPrefix(String prefix, String string) {
        int length = Math.min(prefix.length(), string.length());
        int index = 0;
        while (index < length && prefix.charAt(index) == string.charAt(index)) {
            index++;
        }
        return prefix.substring(0, index);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] case1 = new String[] {"flower","flow","flight"};
        String[] case2 = new String[] {"dog","racecar","car"};
        String[] case3 = new String[] {};
        System.out.println(solution.longestCommonPrefix(case1));
        System.out.println(solution.longestCommonPrefix(case2));
        System.out.println(solution.longestCommonPrefix(case3));
    }
}