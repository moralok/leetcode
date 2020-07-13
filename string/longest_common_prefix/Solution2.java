package string.longest_common_prefix;

public class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        for (int i = 0; i < length; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                // 长度检查
                if (i == strs[j].length() || ch != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String[] case1 = new String[] {"flower","flow","flight"};
        String[] case2 = new String[] {"dog","racecar","car"};
        String[] case3 = new String[] {};
        System.out.println(solution.longestCommonPrefix(case1));
        System.out.println(solution.longestCommonPrefix(case2));
        System.out.println(solution.longestCommonPrefix(case3));
    }
}