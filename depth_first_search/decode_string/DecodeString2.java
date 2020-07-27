package depth_first_search.decode_string;

public class DecodeString2 {

    private String src;

    private int index;

    public String decodeString(String s) {
        src = s;
        index = 0;
        return getString();
    }

    private String getString() {
        if (index == src.length() || src.charAt(index) == ']') {
            return "";
        }
        char ch = src.charAt(index);
        int repeatTime = 1;
        String res = "";
        if (Character.isDigit(ch)) {
            repeatTime = getDigit();
            // 跳过左括号
            index++;
            String tmp = getString();
            // 跳过右括号
            index++;
            while (repeatTime--  > 0) {
                res += tmp;
            }
        } else if (Character.isLetter(ch)) {
            res = String.valueOf(ch);
            // 忘记更新指针
            index++;
        }
        return res + getString();
    }

    private int getDigit() {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(src.charAt(index))) {
            sb.append(src.charAt(index++));
        }
        return Integer.valueOf(sb.toString());
    }
}