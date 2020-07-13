package string.longest_common_prefix;

public class Solution3 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length-1);
    }

    private String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        }
        int mid = (start + end) >> 1;
        String leftPrefix = longestCommonPrefix(strs, start, mid);
        String rightPrefix = longestCommonPrefix(strs, mid + 1, end);
        return longestCommonPrefix(leftPrefix, rightPrefix);
    }

    private String longestCommonPrefix(String leftPrefix, String rightPrefix) {
        int length = Math.min(leftPrefix.length(), rightPrefix.length());
        int index = 0;
        while (index < length && leftPrefix.charAt(index) == rightPrefix.charAt(index)) {
            index++;
        }
        return leftPrefix.substring(0, index);
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        String[] case1 = new String[] {"flower","flow","flight"};
        String[] case2 = new String[] {"dog","racecar","car"};
        String[] case3 = new String[] {};
        System.out.println(solution.longestCommonPrefix(case1));
        System.out.println(solution.longestCommonPrefix(case2));
        System.out.println(solution.longestCommonPrefix(case3));
    }
}