package daily;

public class Lc2645Solution2 {

    public int addMinimum(String word) {
        int n = word.length();
        int group = 1;
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) <= word.charAt(i - 1)) {
                group++;
            }
        }
        return group * 3 - n;
    }

    public static void main(String[] args) {
        Lc2645Solution2 solution = new Lc2645Solution2();
        String word;

        word = "b";
        assert solution.addMinimum(word) == 2;

        word = "aaa";
        assert solution.addMinimum(word) == 6;

        word = "abc";
        assert solution.addMinimum(word) == 0;
    }
}
