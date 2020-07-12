package string.count_and_say;

public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        int pre = 0;
        int cur = 1;
        StringBuilder sb = new StringBuilder();
        String str = countAndSay(n - 1);
        for (cur = 1; cur < str.length(); cur++) {
            if (str.charAt(cur) != str.charAt(pre)) {
                sb.append(cur - pre).append(str.charAt(pre));
                pre = cur;
            }
        }
        if (cur != pre) {
            sb.append(cur - pre).append(str.charAt(pre));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(1));
        System.out.println(solution.countAndSay(4));
    }
}