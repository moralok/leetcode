package daily;

import java.util.HashMap;
import java.util.Map;

public class Lc0383Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] charsOfRansomNote = ransomNote.toCharArray();
        char[] charsOfMagazine = magazine.toCharArray();
        Map<Character, Integer> countsOfRansomNote = new HashMap<>();
        for (char c : charsOfRansomNote) {
            Integer count = countsOfRansomNote.getOrDefault(c, 0);
            countsOfRansomNote.put(c, ++count);
        }
        Map<Character, Integer> countsOfMagazine = new HashMap<>();
        for (char c : charsOfMagazine) {
            Integer count = countsOfMagazine.getOrDefault(c, 0);
            countsOfMagazine.put(c, ++count);
        }
        for (Map.Entry<Character, Integer> entry : countsOfRansomNote.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            Integer limit = countsOfMagazine.getOrDefault(key, 0);
            if (value > limit) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote;
        String magazine;
        Lc0383Solution solution = new Lc0383Solution();

        ransomNote = "a";
        magazine = "b";
        assert !solution.canConstruct(ransomNote, magazine);

        ransomNote = "aa";
        magazine = "ab";
        assert !solution.canConstruct(ransomNote, magazine);

        ransomNote = "aa";
        magazine = "aab";
        assert solution.canConstruct(ransomNote, magazine);
    }
}
