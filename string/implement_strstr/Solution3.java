package string.implement_strstr;

public class Solution3 {
    
    public int strStr(String haystack, String needle) {
        int haystackLen = haystack.length(), needleLen = needle.length();
        if (needleLen > haystackLen) {
            return -1;
        }
        int a = 26;
        long refHash = 0, hash = 0;
        // 防止溢出，取余
        long modulus = (long)Math.pow(2, 31);
        for (int i = 0; i < needleLen; i++) {
            refHash = (refHash * a + charToInt(needle.charAt(i))) % modulus;
            hash = (hash * a + charToInt(haystack.charAt(i))) % modulus;
        }
        if (refHash == hash) {
            return 0;
        }
        // 计算滚动哈希的常用数
        long aL = 1;
        for (int i = 0; i < needleLen; i++) {
            // 为了防止溢出吗？
            aL = (aL * a) % modulus;
        }
        for (int i = 1; i < haystackLen - needleLen + 1; i++) {
            // 取余
            hash = ((hash * a - charToInt(haystack.charAt(i-1)) * aL) + charToInt(haystack.charAt(i + needleLen - 1))) % modulus;
            if (hash == refHash) {
                return i;
            }
        }
        return -1;
    }

    private int charToInt(char c) {
        return c - 'a';
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        String haystack1 = "hello", needle1 = "ll";
        System.out.println(solution.strStr(haystack1, needle1));
        String haystack2 = "aaaaa", needle2 = "bba";
        System.out.println(solution.strStr(haystack2, needle2));
    }
}