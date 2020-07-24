package binary_search.is_subsequence;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for (char ch : s.toCharArray()) {
            while (i < t.length() && ch != t.charAt(i)) {
                i++;
            }
            i++;
        }
        return i <= t.length();
    }
}