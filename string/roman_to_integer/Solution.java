package string.roman_to_integer;

public class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int val = getValue(s.charAt(i));
            if (preNum < val) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = val;
        }
        sum += preNum;
        return sum;
    }
    
    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        String case1 = "III";
        String case2 = "IV";
        String case3 = "IX";
        String case4 = "LVIII";
        String case5 = "MCMXCIV";
        Solution solution = new Solution();
        System.out.println(solution.romanToInt(case1));
        System.out.println(solution.romanToInt(case2));
        System.out.println(solution.romanToInt(case3));
        System.out.println(solution.romanToInt(case4));
        System.out.println(solution.romanToInt(case5));
    }
}