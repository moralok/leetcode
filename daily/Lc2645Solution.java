package daily;

public class Lc2645Solution {

    public int addMinimum(String word) {
        char[] chars = new char[] {'a', 'b', 'c'};
        int idx = 0;
        int ret = 0;
        for (int i = 0; i < word.length();) {
            if (chars[idx] != word.charAt(i)) {
                ret++;
            } else {
                i++;
            }
            idx = (idx + 1) % 3;
        }
        ret += (3 - idx) % 3;
        return ret;
    }

    public static void main(String[] args) {
        Lc2645Solution solution = new Lc2645Solution();
        String word;

        word = "b";
        assert solution.addMinimum(word) == 2;

        word = "aaa";
        assert solution.addMinimum(word) == 6;

        word = "abc";
        assert solution.addMinimum(word) == 0;
    }
}
