package daily;

public class Lc2182Solution {

    public String repeatLimitedString(String s, int repeatLimit) {
        int n = s.length();
        int[] counts = new int[26];
        for (int i = 0; i < n; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        for (int i = 25, j = 24; i >= 0 && j >= 0;) {
            if (counts[i] == 0) {
                cur = 0;
                i--;
            } else if (cur < repeatLimit) {
                counts[i]--;
                sb.append((char) ('a' + i));
                cur++;
            } else if (j >= i || counts[j] == 0) {
                j--;
            } else {
                counts[j]--;
                sb.append((char) ('a' + j));
                cur = 0;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Lc2182Solution solution = new Lc2182Solution();
        String s;
        int repeatLimit;

        s = "cczazcc";
        repeatLimit = 3;
        assert "zzcccac".equals(solution.repeatLimitedString(s, repeatLimit));


        s = "aababab";
        repeatLimit = 2;
        assert "bbabaa".equals(solution.repeatLimitedString(s, repeatLimit));
    }
}
