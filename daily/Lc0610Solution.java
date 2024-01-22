package daily;

public class Lc0610Solution {

    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int n = chars.length;
        int max = num;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(chars, i, j);
                max = Math.max(max, Integer.parseInt(new String(chars)));
                swap(chars, i, j);
            }
        }
        return max;
    }

    private void swap(char[] chars, int i, int j) {
        char ch = chars[i];
        chars[i] = chars[j];
        chars[j] = ch;
    }

    public static void main(String[] args) {
        Lc0610Solution solution = new Lc0610Solution();

        int num = 2736;
        assert solution.maximumSwap(num) == 7236;

        num = 9973;
        assert solution.maximumSwap(num) == 9973;
    }
}
