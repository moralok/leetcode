package string.valid_parentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    private Map<Character, Character> map = new HashMap<>();

    public Solution() {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                char top = stack.empty() ? '#' : stack.pop();
                if (top != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String case1 = "()";
        String case2 = "()[]{}";
        String case3 = "(]";
        String case4 = "([)]";
        String case5 = "{[]}";
        System.out.println(solution.isValid(case1));
        System.out.println(solution.isValid(case2));
        System.out.println(solution.isValid(case3));
        System.out.println(solution.isValid(case4));
        System.out.println(solution.isValid(case5));
    }
}