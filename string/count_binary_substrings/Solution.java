package string.count_binary_substrings;

public class Solution {

    public int countBinarySubstrings(String s) {
        int pre = 0, cur = 1, ans = 0; 
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                ans += Math.min(pre, cur);
                pre = cur;
                cur = 1;
            }
        }
        ans += Math.min(pre, cur);
        return ans;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        String case1 = "00110011";
        String case2 = "10101";
        System.out.println(solution.countBinarySubstrings(case1));
        System.out.println(solution.countBinarySubstrings(case2));
    }
}