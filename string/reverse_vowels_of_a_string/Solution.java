package string.reverse_vowels_of_a_string;

public class Solution {

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            while (left < right && !isVowel(chars[left])) {
                left++;
            }
            while (left < right && !isVowel(chars[right])) {
                right--;
            }
            if (left < right) {
                swap(chars, left++, right--);
            }
        }
        return new String(chars);
    }

    private void swap(char[] chars, int left, int right) {
        char tmp = chars[left];
        chars[left] = chars[right];
        chars[right] = tmp;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' 
        || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        String case1 = "hello";
        String case2 = "leetcode";
        System.out.println(solution.reverseVowels(case1));
        System.out.println(solution.reverseVowels(case2));
    }
}