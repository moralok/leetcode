package string.length_of_last_word;

public class Solution {

    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int start = end;
        while (end >= 0 && s.charAt(end) != ' ') {
            end--;
        }
        return start - end;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        String case1 = "Hello World";
        System.out.println(solution.lengthOfLastWord(case1));
    }
}