package daily;

public class Daily20240310Lc0299Solution {

    public String getHint(String secret, String guess) {
        int[] secretCount = new int[10];
        int[] guessCount = new int[10];
        int n = secret.length();
        int A = 0, B = 0;
        for (int i = 0; i < n; i++) {
            int sIndex = secret.charAt(i) - '0';
            int gIndex = guess.charAt(i) - '0';
            if (sIndex == gIndex) {
                A++;
            } else {
                secretCount[sIndex]++;
                guessCount[gIndex]++;
            }
        }
        for (int i = 0; i < 10; i++) {
            B += Math.min(secretCount[i], guessCount[i]);
        }
        return A + "A" + B + "B";
    }

    public static void main(String[] args) {
        Daily20240310Lc0299Solution solution = new Daily20240310Lc0299Solution();
        String secret = "1807";
        String guess = "7810";
        assert solution.getHint(secret, guess).equals("1A3B");
    }
}
