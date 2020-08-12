package lcof.lcof038;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Lcof038Solution {

    private List<String> res = new LinkedList<>();
    private char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int x) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);
            swap(x, i);
            dfs(x + 1);
            swap(x, i);
        }
    }

    private void swap(int x, int i) {
        char tmp = c[x];
        c[x] = c[i];
        c[i] = tmp;
    }
}