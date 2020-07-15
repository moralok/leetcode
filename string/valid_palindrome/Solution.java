package string.valid_palindrome;

public class Solution {

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String case1 = "A man, a plan, a canal: Panama";
        String case2 = "race a car";
        System.out.println(solution.isPalindrome(case1));
        System.out.println(solution.isPalindrome(case2));
    }
}