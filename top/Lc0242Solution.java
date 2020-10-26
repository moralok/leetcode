package top;

public class Lc0242Solution {
    public boolean isAnagram(String s, String t) {
        // 哈希表，数量有限和字母有关用数组代替
        // O(n) O(n)
        if (s.length() != t.length()) {
            return false;
        }
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            // 可以一次循环，结果变慢了是几个意思。。。
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
