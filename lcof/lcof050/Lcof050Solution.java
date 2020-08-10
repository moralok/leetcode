package lcof.lcof050;

import java.util.HashMap;
import java.util.Map;

public class Lcof050Solution {

    public char firstUniqChar(String s) {
        // 哈希表，遍历两轮
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : s.toCharArray()) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }
        return ' ';
    }
}