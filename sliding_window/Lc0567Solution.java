package sliding_window;

public class Lc0567Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] need = new int[26];
        int[] window = new int[26];
        int winLen = s1.length();
        for (int i = 0; i < winLen; i++) {
            need[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (window[i] == need[i]) {
                count++;
            }
        }
        if (count == 26) {
            return true;
        }
        for (int i = 0; i < s2.length() - winLen; i++) {
            int l = s2.charAt(i) - 'a', r = s2.charAt(i + winLen) - 'a';
            window[r]++;
            if (window[r] == need[r]) {
                count++;
            } else if (window[r] == need[r] + 1) {
                count--;
            }
            window[l]--;
            if (window[l] == need[l]) {
                count++;
            } else if (window[l] == need[l] - 1) {
                count--;
            }
            if (count == 26) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Lc0567Solution solution = new Lc0567Solution();
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(solution.checkInclusion(s1, s2));
    }
}
