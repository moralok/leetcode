package sliding_window;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lc0438Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() < p.length()) {
            return Collections.emptyList();
        }
        int[] windows = new int[26];
        int[] need = new int[26];
        for (int i = 0; i < p.length(); i++) {
            need[p.charAt(i)-'a']++;
            windows[s.charAt(i)-'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (windows[i] == need[i]) {
                count++;
            }
        }
        List<Integer> ret = new ArrayList<>();
        if (count == 26) {
            ret.add(0);
        }
        int pLen = p.length();
        for (int i = 0; i < s.length() - pLen; i++) {
            int l = s.charAt(i) - 'a', r = s.charAt(i + pLen) - 'a';
            windows[r]++;
            if (windows[r] == need[r]) {
                count++;
            } else if (windows[r] == need[r] + 1) {
                count--;
            }
            // 顺序很重要
            windows[l]--;
            if (windows[l] == need[l]) {
                count++;
            } else if (windows[l] == need[l] - 1) {
                count--;
            }
            if (count == 26) {
                // emmm
                ret.add(i+1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Lc0438Solution solution = new Lc0438Solution();
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(solution.findAnagrams(s, p));
    }
}
