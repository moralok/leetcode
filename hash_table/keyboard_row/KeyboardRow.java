package hash_table.keyboard_row;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyboardRow {
    
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        String[] lines = new String[] {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (String word : words) {
            // 小写处理
            if (find(word.toLowerCase(), lines)) {
                list.add(word);
            }
        }
        return list.toArray(new String[list.size()]);
    }

    private boolean find(String word, String[] lines) {
        String theLine = "";
        for (String line : lines) {
            if (line.indexOf(word.charAt(0)) != -1) {
                theLine = line;
                break;
            }
        }
        for (int i = 0; i < word.length(); i++) {
            if (theLine.indexOf(word.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        KeyboardRow keyboardRow = new KeyboardRow();
        String[] case1 = new String[] {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.toString(keyboardRow.findWords(case1)));
    }
}