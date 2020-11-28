package sliding_window;

public class Lc0424Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] map = new int[26];
        int left = 0, right = 0;
        int max = 0;
        while (right < s.length()) {
            int idx = s.charAt(right) - 'A';
            map[idx]++;
            max = Math.max(max, map[idx]);
            if (right - left + 1 > max + k) {
                map[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return s.length() - left;
    }
}
