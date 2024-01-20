package daily;

import common.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc2788Solution {

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                if (c == separator) {
                    if (sb.length() > 0) {
                        res.add(sb.toString());
                        sb = new StringBuilder();
                    }
                } else {
                    sb.append(c);
                }
            }
            if (sb.length() > 0) {
                res.add(sb.toString());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Lc2788Solution solution = new Lc2788Solution();

        String[] strings = Utils.buildStrings("[\"one.two.three\",\"four.five\",\"six\"]");
        List<String> words = new ArrayList<>(Arrays.asList(strings));
        List<String> list = solution.splitWordsBySeparator(words, '.');
        System.out.println(list);
    }
}
