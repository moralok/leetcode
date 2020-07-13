package string.add_binary;

public class Solution {
    
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? b.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 2;
            sb.append(tmp % 2);
            i--;
            j--;
        }
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a1 = "11";
        String b1 = "1";
        String a2 = "1010";
        String b2 = "1011";
        System.out.println(solution.addBinary(a1, b1));
        System.out.println(solution.addBinary(a2, b2));

    }
}