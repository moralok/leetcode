package daily;

public class Lc0383Solution2 {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (char ch : magazine.toCharArray()) {
            counts[ch - 'a']++;
        }
        for (char ch : ransomNote.toCharArray()) {
            counts[ch - 'a']--;
        }
        for (int count : counts){
            if (count < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote;
        String magazine;
        Lc0383Solution2 solution = new Lc0383Solution2();

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
