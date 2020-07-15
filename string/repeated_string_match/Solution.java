package string.repeated_string_match;

public class Solution {

    public int repeatedStringMatch(String A, String B) {
        // 评论中有人指出，关键在于循环终止条件
        // 比如最小k，或k+1
        // 比如lenB + 2 * lenA
        int lenA = A.length(), lenB = B.length();
        int k = lenB / lenA + (lenB % lenA > 0 ? 1 : 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(A);
        }
        String str1 = sb.toString();
        if (str1.contains(B)) {
            return k;
        }
        sb.append(A);
        String str2 = sb.toString();
        if (str2.contains(B)) {
            return k + 1;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        String A1 = "abcd";
        String B1 = "cdabcdab";
        System.out.println(solution.repeatedStringMatch(A1, B1));
        String A2 = "a";
        String B2 = "aa";
        System.out.println(solution.repeatedStringMatch(A2, B2));
    }
}