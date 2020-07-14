package string.count_binary_substrings;

public class Solution2 {
    
    public int countBinarySubstrings(String s) {
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                ans += countBinarySubstrings(s, i);
            }
        }
        return ans;
    }

    private int countBinarySubstrings(String s, int i) {
        int j = i - 1, count = 0;
        char left = s.charAt(j);
        char right = s.charAt(i);
        while (j >= 0 && i < s.length() && s.charAt(j) == left && s.charAt(i) == right) {
            count++;
            j--;
            i++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String case1 = "00110011";
        String case2 = "10101";
        System.out.println(solution.countBinarySubstrings(case1));
        System.out.println(solution.countBinarySubstrings(case2));
    }
}