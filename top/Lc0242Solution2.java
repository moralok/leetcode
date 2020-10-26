package top;

import java.util.Arrays;

public class Lc0242Solution2 {
    public boolean isAnagram(String s, String t) {
        // O(nlog(n)) O(1)
        if (s.length() != t.length()) {
            return false;
        }
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        Arrays.sort(sa);
        Arrays.sort(ta);
        return Arrays.equals(sa, ta);
    }
}
