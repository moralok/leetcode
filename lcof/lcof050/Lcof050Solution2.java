package lcof.lcof050;

import java.util.LinkedHashMap;
import java.util.Map;

public class Lcof050Solution2 {

    public char firstUniqChar(String s) {
        // 有序哈希表，遍历一轮
        Map<Character, Boolean> map = new LinkedHashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, !map.containsKey(ch));
        }
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}