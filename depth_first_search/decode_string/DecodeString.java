package depth_first_search.decode_string;

import java.util.Collections;
import java.util.LinkedList;

public class DecodeString {

    private int index = 0;

    public String decodeString(String s) {
        // 感觉好麻烦，数字可以多位的细节开始也没考虑到
        LinkedList<String> stack = new LinkedList<>();
        while (index < s.length()) {
            char ch = s.charAt(index);
            if (Character.isDigit(ch)) {
                stack.push(getDigit(s));
            } else if (Character.isLetter(ch) || '[' == ch) {
                stack.push(String.valueOf(ch));
                index++;
            } else {
                index++;
                LinkedList<String> tmpStack = new LinkedList<>();
                while (!stack.peek().equals("[")) {
                    tmpStack.push(stack.pop());
                }
                stack.pop();
                String tmpString = getString(tmpStack);
                Integer repeatTimes = Integer.valueOf(stack.pop());
                StringBuilder sb = new StringBuilder();
                while (repeatTimes > 0) {
                    sb.append(tmpString);
                    repeatTimes--;
                }
                stack.push(sb.toString());
            }
        }
        Collections.reverse(stack);
        return getString(stack);
    }

    private String getString(LinkedList<String> tmpStack) {
        StringBuilder sb = new StringBuilder();
        while (!tmpStack.isEmpty()) {
            sb.append(tmpStack.pop());
        }
        return sb.toString();
    }

    private String getDigit(String s) {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(s.charAt(index))) {
            sb.append(s.charAt(index++));
        }
        return sb.toString();
    }
}