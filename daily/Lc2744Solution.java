package daily;

public class Lc2744Solution {

    public int maximumNumberOfStringPairs(String[] words) {
        int ans = 0;
        boolean[][] seen = new boolean[26][26];
        for (String word : words) {
            int x = word.charAt(0) - 'a';
            int y = word.charAt(1) - 'a';
            if (seen[y][x]) {
                ans++;
            } else {
                seen[x][y] = true;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Lc2744Solution solution = new Lc2744Solution();
        String[] words;

        words = new String[] {"cd","ac","dc","ca","zz"};
        assert solution.maximumNumberOfStringPairs(words) == 2;

        words = new String[] {"ab","ba","cc"};
        assert solution.maximumNumberOfStringPairs(words) == 1;

        words = new String[] {"aa","ab"};
        assert solution.maximumNumberOfStringPairs(words) == 0;
    }
}
