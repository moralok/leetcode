package string.implement_strstr;

public class Solution2 {
    
    public int strStr(String haystack, String needle) {
        // needle 长度为0的情况被处理了
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        for (int i = 0; i < haystackLen - needleLen + 1; i++) {
            int needleP = 0;
            int haystackP = i;
            while (needleP < needleLen && needle.charAt(needleP) == haystack.charAt(haystackP)) {
                needleP++;
                haystackP++;
            }
            if (needleP == needleLen) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String haystack1 = "hello", needle1 = "ll";
        System.out.println(solution.strStr(haystack1, needle1));
        String haystack2 = "aaaaa", needle2 = "bba";
        System.out.println(solution.strStr(haystack2, needle2));
    }
}